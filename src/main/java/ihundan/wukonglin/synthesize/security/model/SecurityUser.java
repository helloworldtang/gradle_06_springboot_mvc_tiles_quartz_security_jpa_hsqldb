package ihundan.wukonglin.synthesize.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_user")
public class SecurityUser {
	
	private int objid;
	private String username;
	private String password;
	private String roles;
	
	
	/****************************get and set*******************************/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getObjid() {
		return objid;
	}
	public void setObjid(int objid) {
		this.objid = objid;
	}
	
	@Column(name="username",unique=true,nullable=true)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="password",nullable=true)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="roles")
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	/****************************constractor*******************************/
	public SecurityUser() {
	}
	public SecurityUser(int objid, String username, String password,
			String roles) {
		this.objid = objid;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "SecurityUser [objid=" + objid + ", username=" + username
				+ ", password=" + password + ", roles=" + roles + "]";
	}
}
