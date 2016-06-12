/**
 * @author KATechnologie
 */
package fr.katechnologie.wildfly.jpa.entity;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import fr.katechnologie.wildfly.jpa.entity.AddressLine;
import fr.katechnologie.wildfly.jpa.entity.AddressZipcode;


/**
 * Modèle définissant une adresse postale d'une entité.
 */

@Entity
@Table( name = "T_E_ADDRESS_ADR" )
@NamedQueries( { 
	@NamedQuery(name = "Address.find", query = "SELECT p FROM Address p WHERE p.uid = :uid")
} )
public class Address implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column( name = "ADR_UID")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long uid;
	public Long getUid() { return uid; }
	public void setUid( Long value ) { this.uid = value; }

	@OneToMany( mappedBy = "address" )
	private List< AddressLine > lines = new ArrayList< AddressLine >();
	public void addline( AddressLine value ) { lines.add( value ); }
	public List< AddressLine > getLines() { return lines; }
	
	@OneToOne( cascade = CascadeType.PERSIST )
	@JoinColumn( name = "ADR_ZIPCODE", referencedColumnName = "ADZ_UID" )
	private AddressZipcode zipCode;
	public AddressZipcode getZipCode() { return zipCode; }
	public void setZipCode( AddressZipcode value ) { this.zipCode = value; }

	@Override
	public String toString()
	{
		return "User [ uid = " + getUid() + "\n" +
		             " zipCode = " + getZipCode() + "\n" +
		             "]";
	}

}
