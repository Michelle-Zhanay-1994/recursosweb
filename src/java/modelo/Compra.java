/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
 * @author LENOVO
 */
@Entity
@Table(name = "compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c")
    , @NamedQuery(name = "Compra.findByIdCompra", query = "SELECT c FROM Compra c WHERE c.idCompra = :idCompra")
    , @NamedQuery(name = "Compra.findByNumeroMotocicleta", query = "SELECT c FROM Compra c WHERE c.numeroMotocicleta = :numeroMotocicleta")
    , @NamedQuery(name = "Compra.findByFechacompra", query = "SELECT c FROM Compra c WHERE c.fechacompra = :fechacompra")
    , @NamedQuery(name = "Compra.findByPrecioTotal", query = "SELECT c FROM Compra c WHERE c.precioTotal = :precioTotal")
    , @NamedQuery(name = "Compra.findByCantidadMotocicleta", query = "SELECT c FROM Compra c WHERE c.cantidadMotocicleta = :cantidadMotocicleta")})
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCompra")
    private Integer idCompra;
    @Size(max = 45)
    @Column(name = "NumeroMotocicleta")
    private String numeroMotocicleta;
    @Column(name = "Fechacompra")
    @Temporal(TemporalType.DATE)
    private Date fechacompra;
    @Column(name = "PrecioTotal")
    private Long precioTotal;
    @Column(name = "CantidadMotocicleta")
    private Integer cantidadMotocicleta;
    @JoinColumn(name = "Cliente_idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente clienteidCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compraidCompra")
    private Collection<Motocicleta> motocicletaCollection;

    public Compra() {
    }

    public Compra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getNumeroMotocicleta() {
        return numeroMotocicleta;
    }

    public void setNumeroMotocicleta(String numeroMotocicleta) {
        this.numeroMotocicleta = numeroMotocicleta;
    }

    public Date getFechacompra() {
        return fechacompra;
    }

    public void setFechacompra(Date fechacompra) {
        this.fechacompra = fechacompra;
    }

    public Long getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Long precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Integer getCantidadMotocicleta() {
        return cantidadMotocicleta;
    }

    public void setCantidadMotocicleta(Integer cantidadMotocicleta) {
        this.cantidadMotocicleta = cantidadMotocicleta;
    }

    public Cliente getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(Cliente clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    @XmlTransient
    public Collection<Motocicleta> getMotocicletaCollection() {
        return motocicletaCollection;
    }

    public void setMotocicletaCollection(Collection<Motocicleta> motocicletaCollection) {
        this.motocicletaCollection = motocicletaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompra != null ? idCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.idCompra == null && other.idCompra != null) || (this.idCompra != null && !this.idCompra.equals(other.idCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Compra[ idCompra=" + idCompra + " ]";
    }
    
}
