/**
 * @author KATechnologie
 */
package fr.katechnologie.wildfly.jpa.entity;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;


@Entity
@Table( name = "T_E_ROLE_ROL" )
@NamedQueries( { 
	@NamedQuery(name = "Role.find", query = "SELECT p FROM Role p WHERE p.uid = :uid")
} )
public class Role implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column( name = "ROL_UID")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long uid;
	public Long getUid() { return uid; }
	public void setUid( Long value ) { this.uid = value; }

	@Column( name = "ROL_LABEL" )
	private String label;
	public String getLabel() { return label; }
	public void setLabel( String value ) { this.label = value; }

	
	@Override
	public String toString()
	{
		return "User [ uid = " + getUid() + "\n" +
		             "]";
	}

}
