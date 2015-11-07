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
public class PrdLiquidacionMotivoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "lm_empresa")
    private String lmEmpresa;
    @Basic(optional = false)
    @Column(name = "lm_codigo")
    private String lmCodigo;

    public PrdLiquidacionMotivoPK() {
    }

    public PrdLiquidacionMotivoPK(String lmEmpresa, String lmCodigo) {
        this.lmEmpresa = lmEmpresa;
        this.lmCodigo = lmCodigo;
    }

    public String getLmEmpresa() {
        return lmEmpresa;
    }

    public void setLmEmpresa(String lmEmpresa) {
        this.lmEmpresa = lmEmpresa;
    }

    public String getLmCodigo() {
        return lmCodigo;
    }

    public void setLmCodigo(String lmCodigo) {
        this.lmCodigo = lmCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lmEmpresa != null ? lmEmpresa.hashCode() : 0);
        hash += (lmCodigo != null ? lmCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrdLiquidacionMotivoPK)) {
            return false;
        }
        PrdLiquidacionMotivoPK other = (PrdLiquidacionMotivoPK) object;
        if ((this.lmEmpresa == null && other.lmEmpresa != null) || (this.lmEmpresa != null && !this.lmEmpresa.equals(other.lmEmpresa))) {
            return false;
        }
        if ((this.lmCodigo == null && other.lmCodigo != null) || (this.lmCodigo != null && !this.lmCodigo.equals(other.lmCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produccion.entity.PrdLiquidacionMotivoPK[ lmEmpresa=" + lmEmpresa + ", lmCodigo=" + lmCodigo + " ]";
    }
    
}
