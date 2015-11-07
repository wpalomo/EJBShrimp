/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author developer1
 */
@Embeddable
public class PrdVehiculosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "veh_empresa")
    private String vehEmpresa;
    @Basic(optional = false)
    @Column(name = "veh_establecimiento")
    private String vehEstablecimiento;
    @Basic(optional = false)
    @Column(name = "veh_placa")
    private String vehPlaca;

    public PrdVehiculosPK() {
    }

    public PrdVehiculosPK(String vehEmpresa, String vehEstablecimiento, String vehPlaca) {
        this.vehEmpresa = vehEmpresa;
        this.vehEstablecimiento = vehEstablecimiento;
        this.vehPlaca = vehPlaca;
    }

    public String getVehEmpresa() {
        return vehEmpresa;
    }

    public void setVehEmpresa(String vehEmpresa) {
        this.vehEmpresa = vehEmpresa;
    }

    public String getVehEstablecimiento() {
        return vehEstablecimiento;
    }

    public void setVehEstablecimiento(String vehEstablecimiento) {
        this.vehEstablecimiento = vehEstablecimiento;
    }

    public String getVehPlaca() {
        return vehPlaca;
    }

    public void setVehPlaca(String vehPlaca) {
        this.vehPlaca = vehPlaca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehEmpresa != null ? vehEmpresa.hashCode() : 0);
        hash += (vehEstablecimiento != null ? vehEstablecimiento.hashCode() : 0);
        hash += (vehPlaca != null ? vehPlaca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrdVehiculosPK)) {
            return false;
        }
        PrdVehiculosPK other = (PrdVehiculosPK) object;
        if ((this.vehEmpresa == null && other.vehEmpresa != null) || (this.vehEmpresa != null && !this.vehEmpresa.equals(other.vehEmpresa))) {
            return false;
        }
        if ((this.vehEstablecimiento == null && other.vehEstablecimiento != null) || (this.vehEstablecimiento != null && !this.vehEstablecimiento.equals(other.vehEstablecimiento))) {
            return false;
        }
        if ((this.vehPlaca == null && other.vehPlaca != null) || (this.vehPlaca != null && !this.vehPlaca.equals(other.vehPlaca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produccion.entity.PrdVehiculosPK[ vehEmpresa=" + vehEmpresa + ", vehEstablecimiento=" + vehEstablecimiento + ", vehPlaca=" + vehPlaca + " ]";
    }
    
}
