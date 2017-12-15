// 
// Decompiled by Procyon v0.5.30
// 

package com.biosec.ams.dao;

import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Basic;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Table;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Table(name = "USERS")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"), @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username"), @NamedQuery(name = "Users.findBySurname", query = "SELECT u FROM Users u WHERE u.surname = :surname"), @NamedQuery(name = "Users.findByFirstname", query = "SELECT u FROM Users u WHERE u.firstname = :firstname"), @NamedQuery(name = "Users.findByNin", query = "SELECT u FROM Users u WHERE u.nin = :nin"), @NamedQuery(name = "Users.findByPhone", query = "SELECT u FROM Users u WHERE u.phone = :phone"), @NamedQuery(name = "Users.findByAccesstype", query = "SELECT u FROM Users u WHERE u.accesstype = :accesstype"), @NamedQuery(name = "Users.findByStatus", query = "SELECT u FROM Users u WHERE u.status = :status"), @NamedQuery(name = "Users.findByCreationtime", query = "SELECT u FROM Users u WHERE u.creationtime = :creationtime"), @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"), @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email") })
public class Users implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "NIN")
    private String nin;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "ACCESSTYPE")
    private String accesstype;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "CREATIONTIME")
    @Temporal(TemporalType.TIME)
    private Date creationtime;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL")
    private String email;
    
    public Users() {
    }
    
    public Users(final String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(final String username) {
        this.username = username;
    }
    
    public String getSurname() {
        return this.surname;
    }
    
    public void setSurname(final String surname) {
        this.surname = surname;
    }
    
    public String getFirstname() {
        return this.firstname;
    }
    
    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }
    
    public String getNin() {
        return this.nin;
    }
    
    public void setNin(final String nin) {
        this.nin = nin;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(final String phone) {
        this.phone = phone;
    }
    
    public String getAccesstype() {
        return this.accesstype;
    }
    
    public void setAccesstype(final String accesstype) {
        this.accesstype = accesstype;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    public Date getCreationtime() {
        return this.creationtime;
    }
    
    public void setCreationtime(final Date creationtime) {
        this.creationtime = creationtime;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += ((this.username != null) ? this.username.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof Users)) {
            return false;
        }
        final Users other = (Users)object;
        return (this.username != null || other.username == null) && (this.username == null || this.username.equals(other.username));
    }
    
    @Override
    public String toString() {
        return "com.biosec.dao.Users[ username=" + this.username + " ]";
    }
}
