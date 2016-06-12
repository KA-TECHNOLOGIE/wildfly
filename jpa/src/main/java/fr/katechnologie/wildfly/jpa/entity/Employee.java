/**
 * @author KATechnologie
 */
package fr.katechnologie.wildfly.jpa.entity;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import fr.katechnologie.wildfly.jpa.entity.Person;
import fr.katechnologie.wildfly.jpa.entity.Firm;
import fr.katechnologie.wildfly.jpa.entity.Role;


/**
 * Modèle définissant une ligne d'adresse postale d'une entité.
 */

@Entity
@Table( name = "T_E_EMPLOYEE_EMP" )
@NamedQueries( { 
	@NamedQuery(name = "Employee.findByPerson", query = "SELECT p FROM Employee p WHERE p.person = :person"),
	@NamedQuery(name = "Employee.findByPersonAndFirm", query = "SELECT p FROM Employee p WHERE p.person = :person AND p.firm = :firm"),
} )
public class Employee implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column( name = "EMP_UID")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long uid;
	public Long getUid() { return uid; }
	public void setUid( Long value ) { this.uid = value; }

	@ManyToOne( fetch=FetchType.LAZY )
	@JoinColumn( name = "EMP_FIRM", referencedColumnName = "FRM_UID" )
	private Firm firm;
	public Firm getFirm() { return firm; }
	public void setFirm( Firm value ) { this.firm = value; }

	@OneToOne( cascade = CascadeType.PERSIST ) 
	@JoinColumn( name = "EMP_PERSON", referencedColumnName = "PRS_UID" )
	private Person person;
	public Person getPerson() { return person; }
	public void setPerson( Person value ) { this.person = value; }

	@Column( name = "EMP_EMAIL" )
	private String email;
	public String getEmail() { return email; }
	public void setEmail( String value ) { this.email = value; }

	@Column( name = "EMP_PHONE" )
	private String phone;
	public String getPhone() { return phone; }
	public void setPhone( String value ) { this.phone = value; }

	@OneToOne( cascade = CascadeType.PERSIST ) 
	@JoinColumn( name = "EMP_ROLE", referencedColumnName = "ROL_UID" )
	private Role role;
	public Role getRole() { return role; }
	public void setRole( Role value ) { this.role = value; }


	/**
	 * Conversion d'une instance User en String 
	 *
	 * @return String 
	 */
	@Override
	public String toString()
	{
		return "User [ uid = " + getUid() + "\n" +
		             "]";
	}

}
