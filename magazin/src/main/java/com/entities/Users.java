/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author administrateur
 */
@Entity
@Table(name = "users", catalog = "magazin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"mail"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByIdu", query = "SELECT u FROM Users u WHERE u.idu = :idu")
    , @NamedQuery(name = "Users.findByMail", query = "SELECT u FROM Users u WHERE u.mail = :mail")
    , @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username")
    , @NamedQuery(name = "Users.findByTel", query = "SELECT u FROM Users u WHERE u.tel = :tel")
    , @NamedQuery(name = "Users.findByPsw", query = "SELECT u FROM Users u WHERE u.psw = :psw")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "idu", nullable = false, length = 100)
    private String idu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "mail", nullable = false, length = 100)
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "userName", nullable = false, length = 100)
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tel", nullable = false, length = 30)
    private String tel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "psw", nullable = false, length = 60)
    private String psw;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "adresse", nullable = false, length = 65535)
    private String adresse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idu")
    private List<Produits> produitsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idu")
    private List<Publication> publicationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idu")
    private List<Commande> commandeList;

    public Users() {
    }

    public Users(String idu) {
        this.idu = idu;
    }

    public Users(String idu, String mail, String tel, String psw, String adresse) {
        this.idu = idu;
        this.mail = mail;
        this.tel = tel;
        this.psw = psw;
        this.adresse = adresse;
    }

    public String getIdu() {
        return idu;
    }

    public void setIdu(String idu) {
        this.idu = idu;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @XmlTransient
    public List<Produits> getProduitsList() {
        return produitsList;
    }

    public void setProduitsList(List<Produits> produitsList) {
        this.produitsList = produitsList;
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
        hash += (idu != null ? idu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.idu == null && other.idu != null) || (this.idu != null && !this.idu.equals(other.idu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Users[ idu=" + idu + " ]";
    }
    
}
