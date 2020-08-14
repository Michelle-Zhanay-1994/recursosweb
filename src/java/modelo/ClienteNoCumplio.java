/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "cliente_no_cumplio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteNoCumplio.findAll", query = "SELECT c FROM ClienteNoCumplio c")
    , @NamedQuery(name = "ClienteNoCumplio.findByIdclienteNoCumplio", query = "SELECT c FROM ClienteNoCumplio c WHERE c.idclienteNoCumplio = :idclienteNoCumplio")})
public class ClienteNoCumplio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcliente_no_cumplio")
    private Integer idclienteNoCumplio;

    public ClienteNoCumplio() {
    }

    public ClienteNoCumplio(Integer idclienteNoCumplio) {
        this.idclienteNoCumplio = idclienteNoCumplio;
    }

    public Integer getIdclienteNoCumplio() {
        return idclienteNoCumplio;
    }

    public void setIdclienteNoCumplio(Integer idclienteNoCumplio) {
        this.idclienteNoCumplio = idclienteNoCumplio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclienteNoCumplio != null ? idclienteNoCumplio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteNoCumplio)) {
            return false;
        }
        ClienteNoCumplio other = (ClienteNoCumplio) object;
        if ((this.idclienteNoCumplio == null && other.idclienteNoCumplio != null) || (this.idclienteNoCumplio != null && !this.idclienteNoCumplio.equals(other.idclienteNoCumplio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ClienteNoCumplio[ idclienteNoCumplio=" + idclienteNoCumplio + " ]";
    }
    
}
