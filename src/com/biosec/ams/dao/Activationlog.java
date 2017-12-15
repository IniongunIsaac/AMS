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
@Table(name = "ACTIVATIONLOG")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Activationlog.findAll", query = "SELECT a FROM Activationlog a"), @NamedQuery(name = "Activationlog.findById", query = "SELECT a FROM Activationlog a WHERE a.id = :id"), @NamedQuery(name = "Activationlog.findByChipid", query = "SELECT a FROM Activationlog a WHERE a.chipid = :chipid"), @NamedQuery(name = "Activationlog.findByTs", query = "SELECT a FROM Activationlog a WHERE a.ts = :ts"), @NamedQuery(name = "Activationlog.findByUsername", query = "SELECT a FROM Activationlog a WHERE a.username = :username"), @NamedQuery(name = "Activationlog.findByMessage", query = "SELECT a FROM Activationlog a WHERE a.message = :message"), @NamedQuery(name = "Activationlog.findByMocFinger", query = "SELECT a FROM Activationlog a WHERE a.mocFinger = :mocFinger"), @NamedQuery(name = "Activationlog.findByActionresult", query = "SELECT a FROM Activationlog a WHERE a.actionresult = :actionresult"), @NamedQuery(name = "Activationlog.findByActiontype", query = "SELECT a FROM Activationlog a WHERE a.actiontype = :actiontype") })
public class Activationlog implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CHIPID")
    private String chipid;
    @Column(name = "TS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ts;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "MESSAGE")
    private String message;
    @Column(name = "MOC_FINGER")
    private String mocFinger;
    @Column(name = "ACTIONRESULT")
    private String actionresult;
    @Column(name = "ACTIONTYPE")
    private String actiontype;
    @Column(name = "minutie")
    private byte[] minutie;
    
    public Activationlog() {
    }
    
    public Activationlog(final Integer id) {
        this.id = id;
    }
    
    public byte[] getMinutie() {
        return this.minutie;
    }
    
    public void setMinutie(final byte[] minutie) {
        this.minutie = minutie;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public String getChipid() {
        return this.chipid;
    }
    
    public void setChipid(final String chipid) {
        this.chipid = chipid;
    }
    
    public Date getTs() {
        return this.ts;
    }
    
    public void setTs(final Date ts) {
        this.ts = ts;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(final String username) {
        this.username = username;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public String getMocFinger() {
        return this.mocFinger;
    }
    
    public void setMocFinger(final String mocFinger) {
        this.mocFinger = mocFinger;
    }
    
    public String getActionresult() {
        return this.actionresult;
    }
    
    public void setActionresult(final String actionresult) {
        this.actionresult = actionresult;
    }
    
    public String getActiontype() {
        return this.actiontype;
    }
    
    public void setActiontype(final String actiontype) {
        this.actiontype = actiontype;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += ((this.id != null) ? this.id.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof Activationlog)) {
            return false;
        }
        final Activationlog other = (Activationlog)object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }
    
    @Override
    public String toString() {
        return "com.biosec.dao.Activationlog[ id=" + this.id + " ]";
    }
}
