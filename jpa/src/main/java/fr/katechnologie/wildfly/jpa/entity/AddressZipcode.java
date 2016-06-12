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


@Entity
@Table( name = "T_E_ADDRESS_ZIPCODE_ADZ" )
@NamedQueries( { 
	@NamedQuery(name = "AddressLine.findByuid", query = "SELECT p FROM AddressLine p WHERE p.uid = :uid")
} )
public class AddressZipcode implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column( name = "ADZ_UID")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long uid;
	public Long getUid() { return uid; }
	public void setUid( Long value ) { this.uid = value; }

	@Column( name = "ADZ_ZIPCODE" )
	private Integer zipcode;
	public Integer getZipcode() { return zipcode; }
	public void setZipcode( Integer value ) { this.zipcode = value; }

	@Column( name = "ADZ_CITY" )
	private String city;
	public String getCity() { return city; }
	public void setCity( String value ) { this.city = value; }

	
	@Override
	public String toString()
	{
		return "User [ uid = " + getUid() + "\n" +
		             "]";
	}

}
