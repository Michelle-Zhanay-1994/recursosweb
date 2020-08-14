/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "otrosclientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Otrosclientes.findAll", query = "SELECT o FROM Otrosclientes o")
    , @NamedQuery(name = "Otrosclientes.findByIdOtrosClientes", query = "SELECT o FROM Otrosclientes o WHERE o.idOtrosClientes = :idOtrosClientes")
    , @NamedQuery(name = "Otrosclientes.findByDni", query = "SELECT o FROM Otrosclientes o WHERE o.dni = :dni")
    , @NamedQuery(name = "Otrosclientes.findByTelefono", query = "SELECT o FROM Otrosclientes o WHERE o.telefono = :telefono")
    , @NamedQuery(name = "Otrosclientes.findByDireccion", query = "SELECT o FROM Otrosclientes o WHERE o.direccion = :direccion")})
public class Otrosclientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idOtrosClientes")
    private Integer idOtrosClientes;
    @Size(max = 45)
    @Column(name = "Dni")
    private String dni;
    @Size(max = 45)
    @Column(name = "Telefono")
    private String telefono;
    @Size(max = 45)
    @Column(name = "Direccion")
    private String direccion;
    @ManyToMany(mappedBy = "otrosclientesCollection")
    private Collection<Cliente> clienteCollection;

    public Otrosclientes() {
    }

    public Otrosclientes(Integer idOtrosClientes) {
        this.idOtrosClientes = idOtrosClientes;
    }

    public Integer getIdOtrosClientes() {
        return idOtrosClientes;
    }

    public void setIdOtrosClientes(Integer idOtrosClientes) {
        this.idOtrosClientes = idOtrosClientes;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOtrosClientes != null ? idOtrosClientes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Otrosclientes)) {
            return false;
        }
        Otrosclientes other = (Otrosclientes) object;
        if ((this.idOtrosClientes == null && other.idOtrosClientes != null) || (this.idOtrosClientes != null && !this.idOtrosClientes.equals(other.idOtrosClientes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Otrosclientes[ idOtrosClientes=" + idOtrosClientes + " ]";
    }
    
}
