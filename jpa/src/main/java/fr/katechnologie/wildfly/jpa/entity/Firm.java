/**
 * @author KATechnologie
 */
package fr.katechnologie.wildfly.jpa.entity;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import fr.katechnologie.wildfly.jpa.entity.Address;
import fr.katechnologie.wildfly.jpa.entity.Employee;


/**
 * Modèle définissant une personne morale (société).
 */
@Entity
@Table( name = "T_E_FIRM_FRM" )
@NamedQueries( { 
	@NamedQuery(name = "Firm.findByuid", query = "SELECT p FROM Person p WHERE p.uid = :uid") 
} )
public class Firm implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column( name = "FRM_UID")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long uid;
	public Long getUid() { return uid; }
	public void setUid( Long value ) { this.uid = value; }

	@Column( name = "FRM_LABEL" )
	private String label;
	public String getLabel() { return label; }
	public void setLabel( String value ) { this.label = value; }
	 
	@JoinColumn( name = "FRM_ADDRESS", referencedColumnName = "ADR_UID" )
	private Address address;
	public Address getAddress() { return address; }
	public void setPerson( Address value ) { this.address = value; }	

	@OneToMany( mappedBy = "firm" )
	private List< Employee > employees = new ArrayList< Employee >();
	public void addEmployee( Employee value ) { employees.add( value ); }
	public List< Employee > getEmployees() { return employees; }

	/**
	 * Conversion d'une instance Entity String 
	 *
	 * @return String 
	 */
	@Override
	public String toString()
	{
		return "Firm [ uid =" + getUid() + "\n" +
		       "       label = " + getLabel() + "\n" + "]";
	}

}
