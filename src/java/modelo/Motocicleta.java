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
 * @author LENOVO
 */
@Entity
@Table(name = "motocicleta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Motocicleta.findAll", query = "SELECT m FROM Motocicleta m")
    , @NamedQuery(name = "Motocicleta.findByIdMotocicleta", query = "SELECT m FROM Motocicleta m WHERE m.idMotocicleta = :idMotocicleta")
    , @NamedQuery(name = "Motocicleta.findByMatricula", query = "SELECT m FROM Motocicleta m WHERE m.matricula = :matricula")
    , @NamedQuery(name = "Motocicleta.findByCilindraje", query = "SELECT m FROM Motocicleta m WHERE m.cilindraje = :cilindraje")
    , @NamedQuery(name = "Motocicleta.findByColor", query = "SELECT m FROM Motocicleta m WHERE m.color = :color")
    , @NamedQuery(name = "Motocicleta.findByPrecio", query = "SELECT m FROM Motocicleta m WHERE m.precio = :precio")
    , @NamedQuery(name = "Motocicleta.findByMarca", query = "SELECT m FROM Motocicleta m WHERE m.marca = :marca")})
public class Motocicleta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMotocicleta")
    private Integer idMotocicleta;
    @Size(max = 45)
    @Column(name = "Matricula")
    private String matricula;
    @Size(max = 45)
    @Column(name = "Cilindraje")
    private String cilindraje;
    @Size(max = 45)
    @Column(name = "Color")
    private String color;
    @Column(name = "Precio")
    private Long precio;
    @Size(max = 45)
    @Column(name = "Marca")
    private String marca;
    @JoinColumn(name = "Compra_idCompra", referencedColumnName = "idCompra")
    @ManyToOne(optional = false)
    private Compra compraidCompra;

    public Motocicleta() {
    }

    public Motocicleta(Integer idMotocicleta) {
        this.idMotocicleta = idMotocicleta;
    }

    public Integer getIdMotocicleta() {
        return idMotocicleta;
    }

    public void setIdMotocicleta(Integer idMotocicleta) {
        this.idMotocicleta = idMotocicleta;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Compra getCompraidCompra() {
        return compraidCompra;
    }

    public void setCompraidCompra(Compra compraidCompra) {
        this.compraidCompra = compraidCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMotocicleta != null ? idMotocicleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motocicleta)) {
            return false;
        }
        Motocicleta other = (Motocicleta) object;
        if ((this.idMotocicleta == null && other.idMotocicleta != null) || (this.idMotocicleta != null && !this.idMotocicleta.equals(other.idMotocicleta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Motocicleta[ idMotocicleta=" + idMotocicleta + " ]";
    }
    
}
