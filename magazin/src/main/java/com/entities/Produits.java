/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author administrateur
 */
@Entity
@Table(name = "produits", catalog = "magazin", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produits.findAll", query = "SELECT p FROM Produits p")
    , @NamedQuery(name = "Produits.findByIdprod", query = "SELECT p FROM Produits p WHERE p.idprod = :idprod")
    , @NamedQuery(name = "Produits.findByDesignation", query = "SELECT p FROM Produits p WHERE p.designation = :designation")
    , @NamedQuery(name = "Produits.findByDetails", query = "SELECT p FROM Produits p WHERE p.details = :details")
    , @NamedQuery(name = "Produits.findByQte", query = "SELECT p FROM Produits p WHERE p.qte = :qte")
    , @NamedQuery(name = "Produits.findByDateDispo", query = "SELECT p FROM Produits p WHERE p.dateDispo = :dateDispo")
    , @NamedQuery(name = "Produits.findByPrix", query = "SELECT p FROM Produits p WHERE p.prix = :prix")
    , @NamedQuery(name = "Produits.findByLivraison", query = "SELECT p FROM Produits p WHERE p.livraison = :livraison")})
public class Produits implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "idprod", nullable = false, length = 100)
    private String idprod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "designation", nullable = false, length = 200)
    private String designation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 600)
    @Column(name = "details", nullable = false, length = 600)
    private String details;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qte", nullable = false)
    private int qte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateDispo", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDispo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix", nullable = false)
    private float prix;
    @Basic(optional = false)
    @NotNull
    @Column(name = "livraison", nullable = false)
    private boolean livraison;
    @JoinColumn(name = "idu", referencedColumnName = "idu", nullable = false)
    @ManyToOne(optional = false)
    private Users idu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprod")
    private List<Publication> publicationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprod")
    private List<Commande> commandeList;

    public Produits() {
    }

    public Produits(String idprod) {
        this.idprod = idprod;
    }

    public Produits(String idprod, String designation, String details, int qte, Date dateDispo, float prix, boolean livraison) {
        this.idprod = idprod;
        this.designation = designation;
        this.details = details;
        this.qte = qte;
        this.dateDispo = dateDispo;
        this.prix = prix;
        this.livraison = livraison;
    }

    public String getIdprod() {
        return idprod;
    }

    public void setIdprod(String idprod) {
        this.idprod = idprod;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public Date getDateDispo() {
        return dateDispo;
    }

    public void setDateDispo(Date dateDispo) {
        this.dateDispo = dateDispo;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public boolean getLivraison() {
        return livraison;
    }

    public void setLivraison(boolean livraison) {
        this.livraison = livraison;
    }

    public Users getIdu() {
        return idu;
    }

    public void setIdu(Users idu) {
        this.idu = idu;
    }

    @XmlTransient
    public List<Publication> getPublicationList() {
        return publicationList;
    }

    public void setPublicationList(List<Publication> publicationList) {
        this.publicationList = publicationList;
    }

    @XmlTransient
    public List<Commande> getCommandeList() {
        return commandeList;
    }

    public void setCommandeList(List<Commande> commandeList) {
        this.commandeList = commandeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprod != null ? idprod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produits)) {
            return false;
        }
        Produits other = (Produits) object;
        if ((this.idprod == null && other.idprod != null) || (this.idprod != null && !this.idprod.equals(other.idprod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Produits[ idprod=" + idprod + " ]";
    }
    
}
