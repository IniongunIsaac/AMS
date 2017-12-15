// 
// Decompiled by Procyon v0.5.30
// 

package com.biosec.ams.dao;

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
@Table(name = "PARAMT")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Paramt.findAll", query = "SELECT p FROM Paramt p"), @NamedQuery(name = "Paramt.findById", query = "SELECT p FROM Paramt p WHERE p.id = :id"), @NamedQuery(name = "Paramt.findBySysid", query = "SELECT p FROM Paramt p WHERE p.sysid = :sysid"), @NamedQuery(name = "Paramt.findByCentercode", query = "SELECT p FROM Paramt p WHERE p.centercode = :centercode"), @NamedQuery(name = "Paramt.findByCentername", query = "SELECT p FROM Paramt p WHERE p.centername = :centername") })
public class Paramt implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Short id;
    @Column(name = "SYSID")
    private String sysid;
    @Column(name = "CENTERCODE")
    private String centercode;
    @Column(name = "CENTERNAME")
    private String centername;
    
    public Paramt() {
    }
    
    public Paramt(final Short id) {
        this.id = id;
    }
    
    public Short getId() {
        return this.id;
    }
    
    public void setId(final Short id) {
        this.id = id;
    }
    
    public String getSysid() {
        return this.sysid;
    }
    
    public void setSysid(final String sysid) {
        this.sysid = sysid;
    }
    
    public String getCentercode() {
        return this.centercode;
    }
    
    public void setCentercode(final String centercode) {
        this.centercode = centercode;
    }
    
    public String getCentername() {
        return this.centername;
    }
    
    public void setCentername(final String centername) {
        this.centername = centername;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += ((this.id != null) ? this.id.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof Paramt)) {
            return false;
        }
        final Paramt other = (Paramt)object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }
    
    @Override
    public String toString() {
        return "com.biosec.dao.Paramt[ id=" + this.id + " ]";
    }
}
