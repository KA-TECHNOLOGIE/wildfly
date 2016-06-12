/**
 * @author KATechnologie
 */
package fr.katechnologie.wildfly.jpa.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;


/**
 * Modèle définissant une ligne d'adresse postale d'une entité.
 */

@Entity
@Table( name = "T_E_ADDRESS_LINE_ADL" )
@NamedQueries( { 
	@NamedQuery(name = "AddressLine.find", query = "SELECT p FROM AddressLine p WHERE p.uid = :uid"),
	@NamedQuery(name = "AddressLine.findByAdr", query = "SELECT p FROM AddressLine p WHERE p.address = :address")
} )
public class AddressLine implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column( name = "ADL_UID")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long uid;
	public Long getUid() { return uid; }
	public void setUid( Long value ) { this.uid = value; }

	@ManyToOne( fetch=FetchType.LAZY )
	@JoinColumn( name = "ADL_ADDRESS", referencedColumnName = "ADR_UID" )
	private Address address;
	public Address getAddress() { return address; }
	public void setAddress( Address value ) { this.address = value; }

	@Column( name = "ADL_POSITION" )
	private Integer pos;
	public Integer getPosition() { return pos; }
	public void setPosition( Integer value ) { this.pos = value; }

	@Column( name = "ADL_LABEL" )
	private String label;
	public String getLabel() { return label; }
	public void setLabel( String value ) { this.label = value; }

	@Column( name = "ADL_STREET" )
	private Boolean isStreet;
	public Boolean getIsStreet() { return isStreet; }
	public void seIsStreet( Boolean value ) { this.isStreet = value; }

	
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
