/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "inv_numeracion_varios", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvNumeracionVarios.findAll", query = "SELECT i FROM InvNumeracionVarios i"),
    @NamedQuery(name = "InvNumeracionVarios.findByNumEmpresa", query = "SELECT i FROM InvNumeracionVarios i WHERE i.numEmpresa = :numEmpresa"),
    @NamedQuery(name = "InvNumeracionVarios.findByNumClientes", query = "SELECT i FROM InvNumeracionVarios i WHERE i.numClientes = :numClientes"),
    @NamedQuery(name = "InvNumeracionVarios.findByNumProveedores", query = "SELECT i FROM InvNumeracionVarios i WHERE i.numProveedores = :numProveedores"),
    @NamedQuery(name = "InvNumeracionVarios.findByNumProductos", query = "SELECT i FROM InvNumeracionVarios i WHERE i.numProductos = :numProductos"),
    @NamedQuery(name = "InvNumeracionVarios.findByEmpCodigo", query = "SELECT i FROM InvNumeracionVarios i WHERE i.empCodigo = :empCodigo")})
public class InvNumeracionVarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "num_empresa")
    private String numEmpresa;
    @Basic(optional = false)
    @Column(name = "num_clientes")
    private String numClientes;
    @Basic(optional = false)
    @Column(name = "num_proveedores")
    private String numProveedores;
    @Basic(optional = false)
    @Column(name = "num_productos")
    private String numProductos;
    @Basic(optional = false)
    @Column(name = "emp_codigo")
    private String empCodigo;

    public InvNumeracionVarios() {
    }

    public InvNumeracionVarios(String numEmpresa) {
        this.numEmpresa = numEmpresa;
    }

    public InvNumeracionVarios(String numEmpresa, String numClientes, String numProveedores, String numProductos, String empCodigo) {
        this.numEmpresa = numEmpresa;
        this.numClientes = numClientes;
        this.numProveedores = numProveedores;
        this.numProductos = numProductos;
        this.empCodigo = empCodigo;
    }

    public String getNumEmpresa() {
        return numEmpresa;
    }

    public void setNumEmpresa(String numEmpresa) {
        this.numEmpresa = numEmpresa;
    }

    public String getNumClientes() {
        return numClientes;
    }

    public void setNumClientes(String numClientes) {
        this.numClientes = numClientes;
    }

    public String getNumProveedores() {
        return numProveedores;
    }

    public void setNumProveedores(String numProveedores) {
        this.numProveedores = numProveedores;
    }

    public String getNumProductos() {
        return numProductos;
    }

    public void setNumProductos(String numProductos) {
        this.numProductos = numProductos;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numEmpresa != null ? numEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvNumeracionVarios)) {
            return false;
        }
        InvNumeracionVarios other = (InvNumeracionVarios) object;
        if ((this.numEmpresa == null && other.numEmpresa != null) || (this.numEmpresa != null && !this.numEmpresa.equals(other.numEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvNumeracionVarios[ numEmpresa=" + numEmpresa + " ]";
    }
    
}
