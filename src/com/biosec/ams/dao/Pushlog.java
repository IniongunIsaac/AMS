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
@Table(name = "PUSHLOG")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Pushlog.findAll", query = "SELECT p FROM Pushlog p"), @NamedQuery(name = "Pushlog.findById", query = "SELECT p FROM Pushlog p WHERE p.id = :id"), @NamedQuery(name = "Pushlog.findByChipid", query = "SELECT p FROM Pushlog p WHERE p.chipid = :chipid"), @NamedQuery(name = "Pushlog.findByStatus", query = "SELECT p FROM Pushlog p WHERE p.status = :status"), @NamedQuery(name = "Pushlog.findByTs", query = "SELECT p FROM Pushlog p WHERE p.ts = :ts") })
public class Pushlog implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CHIPID")
    private String chipid;
    @Column(name = "STATUS")
    private Short status;
    @Column(name = "TS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ts;
    
    public Pushlog() {
    }
    
    public Pushlog(final Integer id) {
        this.id = id;
    }
    
    public Pushlog(final Integer id, final String chipid) {
        this.id = id;
        this.chipid = chipid;
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
    
    public Short getStatus() {
        return this.status;
    }
    
    public void setStatus(final Short status) {
        this.status = status;
    }
    
    public Date getTs() {
        return this.ts;
    }
    
    public void setTs(final Date ts) {
        this.ts = ts;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += ((this.id != null) ? this.id.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof Pushlog)) {
            return false;
        }
        final Pushlog other = (Pushlog)object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }
    
    @Override
    public String toString() {
        return "com.biosec.dao.Pushlog[ id=" + this.id + " ]";
    }
}
