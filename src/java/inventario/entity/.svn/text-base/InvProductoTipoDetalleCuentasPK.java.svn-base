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
public class InvProductoTipoDetalleCuentasPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "det_empresa")
    private String detEmpresa;
    @Basic(optional = false)
    @Column(name = "det_tipo")
    private String detTipo;
    @Basic(optional = false)
    @Column(name = "det_sector")
    private String detSector;
    @Basic(optional = false)
    @Column(name = "det_piscina")
    private String detPiscina;
    @Basic(optional = false)
    @Column(name = "det_cuenta")
    private String detCuenta;

    public InvProductoTipoDetalleCuentasPK() {
    }

    public InvProductoTipoDetalleCuentasPK(String detEmpresa, String detTipo, String detSector, String detPiscina, String detCuenta) {
        this.detEmpresa = detEmpresa;
        this.detTipo = detTipo;
        this.detSector = detSector;
        this.detPiscina = detPiscina;
        this.detCuenta = detCuenta;
    }

    public String getDetEmpresa() {
        return detEmpresa;
    }

    public void setDetEmpresa(String detEmpresa) {
        this.detEmpresa = detEmpresa;
    }

    public String getDetTipo() {
        return detTipo;
    }

    public void setDetTipo(String detTipo) {
        this.detTipo = detTipo;
    }

    public String getDetSector() {
        return detSector;
    }

    public void setDetSector(String detSector) {
        this.detSector = detSector;
    }

    public String getDetPiscina() {
        return detPiscina;
    }

    public void setDetPiscina(String detPiscina) {
        this.detPiscina = detPiscina;
    }

    public String getDetCuenta() {
        return detCuenta;
    }

    public void setDetCuenta(String detCuenta) {
        this.detCuenta = detCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detEmpresa != null ? detEmpresa.hashCode() : 0);
        hash += (detTipo != null ? detTipo.hashCode() : 0);
        hash += (detSector != null ? detSector.hashCode() : 0);
        hash += (detPiscina != null ? detPiscina.hashCode() : 0);
        hash += (detCuenta != null ? detCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProductoTipoDetalleCuentasPK)) {
            return false;
        }
        InvProductoTipoDetalleCuentasPK other = (InvProductoTipoDetalleCuentasPK) object;
        if ((this.detEmpresa == null && other.detEmpresa != null) || (this.detEmpresa != null && !this.detEmpresa.equals(other.detEmpresa))) {
            return false;
        }
        if ((this.detTipo == null && other.detTipo != null) || (this.detTipo != null && !this.detTipo.equals(other.detTipo))) {
            return false;
        }
        if ((this.detSector == null && other.detSector != null) || (this.detSector != null && !this.detSector.equals(other.detSector))) {
            return false;
        }
        if ((this.detPiscina == null && other.detPiscina != null) || (this.detPiscina != null && !this.detPiscina.equals(other.detPiscina))) {
            return false;
        }
        if ((this.detCuenta == null && other.detCuenta != null) || (this.detCuenta != null && !this.detCuenta.equals(other.detCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvProductoTipoDetalleCuentasPK[ detEmpresa=" + detEmpresa + ", detTipo=" + detTipo + ", detSector=" + detSector + ", detPiscina=" + detPiscina + ", detCuenta=" + detCuenta + " ]";
    }
    
}
