/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author administrateur
 */
@Entity
@Table(name = "publication", catalog = "magazin", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publication.findAll", query = "SELECT p FROM Publication p")
    , @NamedQuery(name = "Publication.findByIdpub", query = "SELECT p FROM Publication p WHERE p.idpub = :idpub")
    , @NamedQuery(name = "Publication.findByDatepub", query = "SELECT p FROM Publication p WHERE p.datepub = :datepub")})
public class Publication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "idpub", nullable = false, length = 100)
    private String idpub;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datepub", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datepub;
    @JoinColumn(name = "idu", referencedColumnName = "idu", nullable = false)
    @ManyToOne(optional = false)
    private Users idu;
    @JoinColumn(name = "idprod", referencedColumnName = "idprod", nullable = false)
    @ManyToOne(optional = false)
    private Produits idprod;

    public Publication() {
    }

    public Publication(String idpub) {
        this.idpub = idpub;
    }

    public Publication(String idpub, Date datepub) {
        this.idpub = idpub;
        this.datepub = datepub;
    }

    public String getIdpub() {
        return idpub;
    }

    public void setIdpub(String idpub) {
        this.idpub = idpub;
    }

    public Date getDatepub() {
        return datepub;
    }

    public void setDatepub(Date datepub) {
        this.datepub = datepub;
    }

    public Users getIdu() {
        return idu;
    }

    public void setIdu(Users idu) {
        this.idu = idu;
    }

    public Produits getIdprod() {
        return idprod;
    }

    public void setIdprod(Produits idprod) {
        this.idprod = idprod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpub != null ? idpub.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publication)) {
            return false;
        }
        Publication other = (Publication) object;
        if ((this.idpub == null && other.idpub != null) || (this.idpub != null && !this.idpub.equals(other.idpub))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Publication[ idpub=" + idpub + " ]";
    }
    
}
