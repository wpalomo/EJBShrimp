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
public class PrdLiquidacionTallaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "talla_empresa")
    private String tallaEmpresa;
    @Basic(optional = false)
    @Column(name = "talla_codigo")
    private String tallaCodigo;

    public PrdLiquidacionTallaPK() {
    }

    public PrdLiquidacionTallaPK(String tallaEmpresa, String tallaCodigo) {
        this.tallaEmpresa = tallaEmpresa;
        this.tallaCodigo = tallaCodigo;
    }

    public String getTallaEmpresa() {
        return tallaEmpresa;
    }

    public void setTallaEmpresa(String tallaEmpresa) {
        this.tallaEmpresa = tallaEmpresa;
    }

    public String getTallaCodigo() {
        return tallaCodigo;
    }

    public void setTallaCodigo(String tallaCodigo) {
        this.tallaCodigo = tallaCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tallaEmpresa != null ? tallaEmpresa.hashCode() : 0);
        hash += (tallaCodigo != null ? tallaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrdLiquidacionTallaPK)) {
            return false;
        }
        PrdLiquidacionTallaPK other = (PrdLiquidacionTallaPK) object;
        if ((this.tallaEmpresa == null && other.tallaEmpresa != null) || (this.tallaEmpresa != null && !this.tallaEmpresa.equals(other.tallaEmpresa))) {
            return false;
        }
        if ((this.tallaCodigo == null && other.tallaCodigo != null) || (this.tallaCodigo != null && !this.tallaCodigo.equals(other.tallaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produccion.entity.PrdLiquidacionTallaPK[ tallaEmpresa=" + tallaEmpresa + ", tallaCodigo=" + tallaCodigo + " ]";
    }
    
}
