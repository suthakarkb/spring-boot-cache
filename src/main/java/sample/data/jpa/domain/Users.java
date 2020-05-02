package sample.data.jpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Users implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="id_generator", sequenceName="id_sequence", initialValue = 100)
	@GeneratedValue(generator = "id_generator")
	private Long id;

	@Column(nullable = false)
	private String userId;
	
	@Column(nullable = false)
	private String userRole;

	@Column(nullable = true)
	private String name;
	
	@Column(nullable = true)
	private String password;
	
	@Column(nullable = true)
	private String departCode;	
	
	@Column(nullable = true)
	private String company;	
	
	protected Users() {
	}

	public Users(String userId, String userRole) {
		super();
		this.userId = userId;
		this.userRole = userRole;
	}	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepartCode() {
		return departCode;
	}
	public void setDepartCode(String departCode) {
		this.departCode = departCode;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}	

	@Override
	public String toString() {
		return getUserId() + "," + getName()+ "," + getCompany();
	}	

}
