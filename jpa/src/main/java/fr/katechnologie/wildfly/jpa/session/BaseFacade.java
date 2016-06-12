/**
 * @author KATechnologie
 */
package fr.katechnologie.wildfly.jpa.session;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
 

/**
 * Generic implementation of any entity service.
 */
public class BaseFacade< E > implements BaseFacadeLocal<E>
{
    @PersistenceContext( unitName = "datasource-pu" )
	protected EntityManager entityManager;

	private Class< E > entityBeanType;
 
	/**
	 * Constructeur par défaut définissant le type de bean de l'entité
	 */
	@SuppressWarnings("unchecked")
	public BaseFacade()
	{
	    this.entityBeanType = (Class<E> ) ((ParameterizedType ) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}


	/**
	 * Définition du gestionnaire d'entités
	 */
	public void setEntityManager( EntityManager entityManager )
	{
	    this.entityManager = entityManager;
	}

	/**
	 * Create method.
	 */
	@Override
	public E create( E entity ) 
	{
		this.entityManager.persist( entity );
		
		return entity;
	}


	/**
	 * Update method.
	 */
	@Override
	public E update( E entity )
	{
		return entityManager.merge(entity);
	}


	/**
	 * Delete method.
	 */
	@Override
	public void delete( E entity )
	{
		entityManager.remove( entity );
	}


	/**
	 * find an entity method.
	 */	
	@Override
	public E find( Long uid )
	{
		return entityManager.find( entityBeanType, uid );
	}


	/**
	 * find all entities method.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<E> list()
	{
		final String namedQuery = this.entityBeanType.getSimpleName() + ".List";
		Query query = entityManager.createNamedQuery( namedQuery );

		return (List<E> ) query.getResultList();
	}
 
}
