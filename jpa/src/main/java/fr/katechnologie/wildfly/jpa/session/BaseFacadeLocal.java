/**
 * @author KATechnologie
 */
package fr.katechnologie.wildfly.jpa.session;

import java.util.List;


/**
 * Generic interface for local entity service.
 */
public interface BaseFacadeLocal<E> 
{ 
	/**
	 * Create service.
	 */
	public E create( E entity );
 
	/**
   	 * Update service.
   	 */
	public E update( E entity );
 
  	/**
   	 * Delete service.
   	 */
  	public void delete( E entity );

	/**
	 * Find service
	 */
	public E find( Long uid );
 
	/**
	 * Find all service
	 */
	public List<E> list();
}
