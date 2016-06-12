/**
 * @author KATechnologie
 */
package fr.katechnologie.wildfly.jpa.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.NamedQuery;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.NamedQueries;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import fr.katechnologie.wildfly.jpa.entity.Person;
import fr.katechnologie.wildfly.jpa.entity.Firm;


@Entity
@Table( name = "T_E_USER_USR" )
@NamedQueries( { 
	@NamedQuery(name = "User.List", query = "SELECT p FROM User p"),
	@NamedQuery(name = "User.findByUid", query = "SELECT p FROM User p WHERE p.uid = :uid"),
	@NamedQuery(name = "User.findByidentifier", query = "SELECT p FROM User p WHERE p.identifier = :identifier"),
	@NamedQuery(name = "User.changePassword", query = "UPDATE User p SET p.password = :pwd WHERE p.identifier = :identifier")
} )
public class User implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic( optional = false )
	@Column( name = "USR_UID")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long uid;
	public Long getUid() { return uid; }
	public void setUid( Long value ) { this.uid = value; }

	@OneToOne( cascade = CascadeType.PERSIST ) 
	@JoinColumn( name = "USR_PERSON", referencedColumnName = "PRS_UID" )
	private Person person;
	public Person getPerson() { return person; }
	public void setPerson( Person value ) { this.person = value; }

    @NotNull( message = "Veuillez saisir une adresse mail" )
	@Column( name = "USR_IDENTIFIER" )
	private String identifier;
	public String getIdentifier() { return identifier; }
	public void setIdentifier( String value ) { this.identifier = value; }

    @NotNull( message = "Veuillez saisir un mot de passe" )
	@Column( name = "USR_PASSWORD" )
	private String password;
	public String getPassword() { return password; }
	public void setPassword( String value ) { this.password = value; }

	@Basic(optional = false)
    @NotNull
	@Column( name = "USR_REGISTER_DATE" )
	private Timestamp registerDate;
	public Timestamp getRegisterDate() { return registerDate; }
	public void setRegisterDate( Timestamp value ) { this.registerDate = value; }
	
	@OneToOne( cascade = CascadeType.PERSIST ) 
	@JoinColumn( name = "USR_FIRM", referencedColumnName = "FRM_UID" )
	private Firm firm;
	public Firm getFirm() { return firm; }
	public void setFirm( Firm value ) { this.firm = value; }


	/**
	 * Conversion d'une instance User en String 
	 *
	 * @return String 
	 */
	@Override
	public String toString()
	{
		return "User [ uid = " + getUid() + "\n" +
		             " person = " + person.toString() + "\n" +
		             " identifier = " + getIdentifier() + "\n" +
		             " password = " + getPassword()  + "\n" +
		             "]";
	}

}
