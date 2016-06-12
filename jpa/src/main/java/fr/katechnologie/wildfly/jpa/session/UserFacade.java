/**
 * @author KATechnologie
 */
package fr.katechnologie.wildfly.jpa.session;

import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import javax.ejb.Stateless; 
import fr.katechnologie.wildfly.jpa.entity.User;
import fr.katechnologie.wildfly.jpa.entity.Firm;
import fr.katechnologie.wildfly.jpa.entity.Person;
import fr.katechnologie.wildfly.jpa.entity.Employee;
import fr.katechnologie.wildfly.jpa.session.PersonFacade;
 

/**
 * Implémentation du service de gestion des utilisateurs
 */
@Stateless
@LocalBean
public class UserFacade extends BaseFacade<User>
{
 
	/**
	 * Lecture d'un utilisateur via son identifiant
	 *
	 * @param id Identifiant de l'utilisateur
	 * @return Identifiant de l'utilisateur
	 */
	public User find( String identifier )
	{
	  	User user = null;

		if ( null != identifier )
		{
	        try 
	        {
	        	Query query = entityManager.createNamedQuery( "User.findByidentifier" );

	        	query.setParameter( "identifier", identifier );
	        	
	            user = (User ) query.getSingleResult();

	        } 
	        catch ( NoResultException error ) 
	        {
	            user = null;
	        }
	        catch ( Exception error ) 
	        {
	            user = null;
	        }
		}

		return user;
	}


	/**
	 * Enregistre un nouvel utilisateur
	 *
	 * @param identifier Identifiant de l'utilisateur
	 * @param password Mot de passe de l'utilisateur
	 * @return Utilisateur
	 */
	public User register( String familyName, String givenName, String identifier, String password )
	{
	  	User user = null;

		if ( null != identifier )
		{
			Person person = new Person();
			person.setFamilyName( familyName );
			person.setGivenName( givenName );

			user = new User();
			user.setPerson( person );
			user.setIdentifier( identifier );
			user.setPassword( password );

			Date date = new Date();
 			user.setRegisterDate( new Timestamp( date.getTime() ) );

 			try 
	        {
	        	entityManager.persist( user );
	        }
	        catch ( Exception error ) 
	        {
	            user = null;
	        }
			
		}

		return user;
	}

	/**
	 * Change le mot de passe d'un utilisateur enregistré.
	 *
	 * @param uid Identifiant de l'utilisateur
	 * @param password Mot de passe de l'utilisateur
	 * @param confirmPassword Confirmation du mot de passe de l'utilisateur
	 * @return Utilisateur
	 */
	public void changePwd( String identifier, String password )
	{
		if ( null != identifier && null != password )
		{
			try 
	        {
	        	Query query = entityManager.createNamedQuery( "User.changePassword" );
	        	query.setParameter( "identifier", identifier );
	        	query.setParameter( "pwd", password );
	            int rc = query.executeUpdate();
	        } 
	        catch ( NoResultException error ) 
	        {
				error = null;
	        }
	        catch ( Exception error ) 
	        {
				error = null;
	        }	
		}

	}

	/**
	 * Gets the related employee from a given user.
	 *
	 * @param user An user
	 * @return The related employee from a given user
	 */
	public Employee getEmployee( User user )
	{
		Employee employee = null;

		if ( null != user )
		{
			Firm firm = user.getFirm();
			try 
	        {
	        	if ( null != firm )
	        	{
		        	Query query = entityManager.createNamedQuery( "Employee.findByPersonAndFirm" );
		        	query.setParameter( "person", user.getPerson() );
	        		query.setParameter( "firm", firm );
	        		employee = (Employee ) query.getSingleResult();
	        	}
	        	else
	        	{
	        		Query query = entityManager.createNamedQuery( "Employee.findByPerson" );
	        		query.setParameter( "person", user.getPerson() );
	        		employee = (Employee ) query.getSingleResult();
	        	}
	        } 
	        catch ( NoResultException error ) 
	        {
				error = null;
	        }
	        catch ( Exception error ) 
	        {
				error = null;
	        }
		}

		return employee;
	}
 
}
