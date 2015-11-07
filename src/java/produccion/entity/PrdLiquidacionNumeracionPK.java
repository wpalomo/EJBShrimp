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
public class PrdLiquidacionNumeracionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "num_empresa")
    private String numEmpresa;
    @Basic(optional = false)
    @Column(name = "num_motivo")
    private String numMotivo;

    public PrdLiquidacionNumeracionPK() {
    }

    public PrdLiquidacionNumeracionPK(String numEmpresa, String numMotivo) {
        this.numEmpresa = numEmpresa;
        this.numMotivo = numMotivo;
    }

    public String getNumEmpresa() {
        return numEmpresa;
    }

    public void setNumEmpresa(String numEmpresa) {
        this.numEmpresa = numEmpresa;
    }

    public String getNumMotivo() {
        return numMotivo;
    }

    public void setNumMotivo(String numMotivo) {
        this.numMotivo = numMotivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numEmpresa != null ? numEmpresa.hashCode() : 0);
        hash += (numMotivo != null ? numMotivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrdLiquidacionNumeracionPK)) {
            return false;
        }
        PrdLiquidacionNumeracionPK other = (PrdLiquidacionNumeracionPK) object;
        if ((this.numEmpresa == null && other.numEmpresa != null) || (this.numEmpresa != null && !this.numEmpresa.equals(other.numEmpresa))) {
            return false;
        }
        if ((this.numMotivo == null && other.numMotivo != null) || (this.numMotivo != null && !this.numMotivo.equals(other.numMotivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produccion.entity.PrdLiquidacionNumeracionPK[ numEmpresa=" + numEmpresa + ", numMotivo=" + numMotivo + " ]";
    }
    
}
