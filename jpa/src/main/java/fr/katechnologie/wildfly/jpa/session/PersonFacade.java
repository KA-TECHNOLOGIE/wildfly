/**
 * @author KATechnologie
 */
package fr.katechnologie.wildfly.jpa.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import javax.ejb.Stateless; 
import fr.katechnologie.wildfly.jpa.entity.Person;
 

/**
 * Implémentation du service de gestion des personnes physiques
 */
@Stateless
@LocalBean
public class PersonFacade extends BaseFacade<Person>
{
 
	/**
	 * Recherche d'une personne par son identifiant unique
	 *
	 * @param uid Identifiant unique de la personne
	 * @return Personne
	 */
	public Person find( String uid )
	{
	  	Person person = null;

		if ( null != uid )
		{
	        try 
	        {
	        	Query query = entityManager.createNamedQuery( "Person.findbyuid" );

	        	query.setParameter( "uid", uid );
	        	
	            person = (Person ) query.getSingleResult();
	        } 
	        catch ( NoResultException error ) 
	        {
	            person = null;
	        }
	        catch ( Exception error ) 
	        {
	            person = null;
	        }
		}

		

		return person;
	}

	/**
	 * Enregistre une nouvelle personne
	 *
	 * @param familyName Nom de famille de la personne
	 * @param givenName Prénom de la personne
	 * @return Personne
	 */
	public Person register( String familyName, String givenName )
	{

	  	Person person = null;

		if ( null != familyName && null != givenName )
		{
			person = new Person();
			person.setFamilyName( familyName );
			person.setGivenName( givenName );

 			try 
	        {
	        	if ( null != entityManager )
	        	{
	        		entityManager.persist( person );
				}
	        }
	        catch ( Exception error ) 
	        {
	            person = null;
	        }

	        if ( null != person )
	        {
				try 
		        {
		        	Query query = entityManager.createNamedQuery( "Person.findByNames" );
		        	query.setParameter( "familyName", familyName );
		        	query.setParameter( "givenName", givenName );
		            person = (Person ) query.getSingleResult();

		        } 
		        catch ( NoResultException error ) 
		        {
		            person = null;
		        }
		        catch ( Exception error ) 
		        {
		            person = null;
		        }
		    }

		}

		return person;
	}
 
}
