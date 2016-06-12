/**
 * @author KATechnologie
 */
package fr.katechnologie.wildfly.jpa.session;


import fr.katechnologie.wildfly.jpa.entity.Role;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.Date;


/**
 * Implémentation du service de gestion des utilisateurs
 */
@Stateless
@LocalBean
public class RoleFacade extends BaseFacade< Role >
{

	public Role find( Long uid )
	{
		Role role = null;

		if ( null != uid ) {
			Query query = null;
	        try {
	        	query = entityManager.createNamedQuery( "Role.find" );
	        	query.setParameter( "uid", uid );
				role = (Role ) query.getSingleResult();

	        } 
	        catch ( NoResultException error ) {
				role = null;
	        }
	        catch ( Exception error ) {
				role = null;
	        }
		}

		return role;
	}

	public Role register( String label )
	{
		Role role = null;

		if ( null != label ) {
			role = new Role();
			role.setLabel( label );

 			try  {
	        	entityManager.persist( role );
	        }
	        catch ( Exception error ) {
				role = null;
	        }
		}

		return role;
	}
 
}
