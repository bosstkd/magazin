/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author administrateur
 */
@Entity
@Table(name = "commande", catalog = "magazin", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c")
    , @NamedQuery(name = "Commande.findByIdcmd", query = "SELECT c FROM Commande c WHERE c.idcmd = :idcmd")
    , @NamedQuery(name = "Commande.findByQte", query = "SELECT c FROM Commande c WHERE c.qte = :qte")})
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "idcmd", nullable = false, length = 100)
    private String idcmd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qte", nullable = false)
    private int qte;
    @JoinColumn(name = "idu", referencedColumnName = "idu", nullable = false)
    @ManyToOne(optional = false)
    private Users idu;
    @JoinColumn(name = "idprod", referencedColumnName = "idprod", nullable = false)
    @ManyToOne(optional = false)
    private Produits idprod;

    public Commande() {
    }

    public Commande(String idcmd) {
        this.idcmd = idcmd;
    }

    public Commande(String idcmd, int qte) {
        this.idcmd = idcmd;
        this.qte = qte;
    }

    public String getIdcmd() {
        return idcmd;
    }

    public void setIdcmd(String idcmd) {
        this.idcmd = idcmd;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
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
        hash += (idcmd != null ? idcmd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.idcmd == null && other.idcmd != null) || (this.idcmd != null && !this.idcmd.equals(other.idcmd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Commande[ idcmd=" + idcmd + " ]";
    }
    
}
