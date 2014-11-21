package com.kapava.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.kapava.common.enums.UserRole;


@Entity
@Proxy(lazy=false)
@Table(name="tbl_user")
public class User {

	@Id
	@Column(name="USER_NAME", length=16, nullable=false)
    private String userName;
	
	@Column(name="EMAIL_ADDRESS", length=100, nullable=true)
    private String emailAddress;
	
	@Column(name="PASSWORD", length=16, nullable=false)
    private String userPassword;

	@Column(name = "ROLE", length=20, nullable=false)
    private UserRole role;     
    
	@Column(name="FIRST_NAME", length=100, nullable=false)
    private String firstName;
    
	@Column(name="MIDDLE_NAME", length=100, nullable=true)
    private String middleName;
    
    @Column(name="LAST_NAME", length=100, nullable=false)
    private String lastName;
    
    @Column(name="PHONE_NUMBER", length=20, nullable=true)
    private String phoneNumber;
    
    @Column(name="ENABLED", nullable=false)
    private boolean enabled = false;
    
    @Column(name="CREDENTIALS_NON_EXPIRED", nullable=false)
    private boolean credentialsNonExpired = false;
    
    @Column(name="ACCOUNT_NON_EXPIRED", nullable=false)
    private boolean accountNonExpired = false;
    
    @Column(name="ACCOUNT_NON_LOCKED", nullable=false)
    private boolean accountNonLocked = false;
    
	@Column(name="LAST_MODIFIED", nullable=false)
	private Date lastModified;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
}
