/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author developer1
 */
@Embeddable
public class InvProductoSaldosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "stk_empresa")
    private String stkEmpresa;
    @Basic(optional = false)
    @Column(name = "stk_bodega")
    private String stkBodega;
    @Basic(optional = false)
    @Column(name = "stk_producto")
    private String stkProducto;

    public InvProductoSaldosPK() {
    }

    public InvProductoSaldosPK(String stkEmpresa, String stkBodega, String stkProducto) {
        this.stkEmpresa = stkEmpresa;
        this.stkBodega = stkBodega;
        this.stkProducto = stkProducto;
    }

    public String getStkEmpresa() {
        return stkEmpresa;
    }

    public void setStkEmpresa(String stkEmpresa) {
        this.stkEmpresa = stkEmpresa;
    }

    public String getStkBodega() {
        return stkBodega;
    }

    public void setStkBodega(String stkBodega) {
        this.stkBodega = stkBodega;
    }

    public String getStkProducto() {
        return stkProducto;
    }

    public void setStkProducto(String stkProducto) {
        this.stkProducto = stkProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stkEmpresa != null ? stkEmpresa.hashCode() : 0);
        hash += (stkBodega != null ? stkBodega.hashCode() : 0);
        hash += (stkProducto != null ? stkProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProductoSaldosPK)) {
            return false;
        }
        InvProductoSaldosPK other = (InvProductoSaldosPK) object;
        if ((this.stkEmpresa == null && other.stkEmpresa != null) || (this.stkEmpresa != null && !this.stkEmpresa.equals(other.stkEmpresa))) {
            return false;
        }
        if ((this.stkBodega == null && other.stkBodega != null) || (this.stkBodega != null && !this.stkBodega.equals(other.stkBodega))) {
            return false;
        }
        if ((this.stkProducto == null && other.stkProducto != null) || (this.stkProducto != null && !this.stkProducto.equals(other.stkProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvProductoSaldosPK[ stkEmpresa=" + stkEmpresa + ", stkBodega=" + stkBodega + ", stkProducto=" + stkProducto + " ]";
    }
    
}
