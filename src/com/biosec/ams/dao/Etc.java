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
@Table(name = "ETC")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Etc.findAll", query = "SELECT e FROM Etc e"), @NamedQuery(name = "Etc.findBySn", query = "SELECT e FROM Etc e WHERE e.sn = :sn"), @NamedQuery(name = "Etc.findByS", query = "SELECT e FROM Etc e WHERE e.s = :s"), @NamedQuery(name = "Etc.findByP", query = "SELECT e FROM Etc e WHERE e.p = :p"), @NamedQuery(name = "Etc.findByCid", query = "SELECT e FROM Etc e WHERE e.cid = :cid") })
public class Etc implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SN")
    private Long sn;
    @Column(name = "S")
    private Long s;
    @Column(name = "P")
    private Long p;
    @Column(name = "CID")
    private String cid;
    
    public Etc() {
    }
    
    public Etc(final Long sn) {
        this.sn = sn;
    }
    
    public Long getSn() {
        return this.sn;
    }
    
    public void setSn(final Long sn) {
        this.sn = sn;
    }
    
    public Long getS() {
        return this.s;
    }
    
    public void setS(final Long s) {
        this.s = s;
    }
    
    public Long getP() {
        return this.p;
    }
    
    public void setP(final Long p) {
        this.p = p;
    }
    
    public String getCid() {
        return this.cid;
    }
    
    public void setCid(final String cid) {
        this.cid = cid;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += ((this.sn != null) ? this.sn.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof Etc)) {
            return false;
        }
        final Etc other = (Etc)object;
        return (this.sn != null || other.sn == null) && (this.sn == null || this.sn.equals(other.sn));
    }
    
    @Override
    public String toString() {
        return "com.biosec.dao.Etc[ sn=" + this.sn + " ]";
    }
}
