package fr.katechnologie.wildfly.jpa.entity;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import fr.katechnologie.wildfly.jpa.entity.Address;


/**
 * Modèle définissant une personne physique.
 */
@Entity
@Table( name = "T_E_PERSON_PRS" )
@NamedQueries( { 
	@NamedQuery(name = "Person.findByuid", query = "SELECT p FROM Person p WHERE p.uid = :uid"),
	@NamedQuery(name = "Person.findByNames", query = "SELECT p FROM Person p WHERE p.familyName = :familyName AND p.givenName = :givenName ") 
} )
public class Person implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column( name = "PRS_UID")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long uid;
	public Long getUid() { return uid; }
	public void setUid( Long value ) { this.uid = value; }

	@Column( name = "PRS_FAMILY_NAME" )
	private String familyName;
	public String getFamilyName() { return familyName; }
	public void setFamilyName( String value ) { this.familyName = value; }
	
	@Column( name = "PRS_GIVEN_NAME" )
	private String givenName;
	public String getGivenName() { return givenName; }
	public void setGivenName( String value ) { this.givenName = value; }
	
	@OneToOne( cascade = CascadeType.PERSIST )
	@JoinColumn( name = "PRS_ADDRESS", referencedColumnName = "ADR_UID" )
	private Address address;
	public Address getAddress() { return address; }
	public void setPerson( Address value ) { this.address = value; }

	/**
	 * Conversion d'une instance Entity String 
	 *
	 * @return String 
	 */
	@Override
	public String toString()
	{
		return "Person [ uid =" + getUid() + "\n" +
		               " familyName = " + getFamilyName() + "\n" +
		               " givenName = " + getGivenName() + "]";
	}

}
