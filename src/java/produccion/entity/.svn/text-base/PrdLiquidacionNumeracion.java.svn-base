/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "prd_liquidacion_numeracion", schema = "produccion")
@NamedQueries({
    @NamedQuery(name = "PrdLiquidacionNumeracion.findAll", query = "SELECT p FROM PrdLiquidacionNumeracion p"),
    @NamedQuery(name = "PrdLiquidacionNumeracion.findByNumEmpresa", query = "SELECT p FROM PrdLiquidacionNumeracion p WHERE p.prdLiquidacionNumeracionPK.numEmpresa = :numEmpresa"),
    @NamedQuery(name = "PrdLiquidacionNumeracion.findByNumMotivo", query = "SELECT p FROM PrdLiquidacionNumeracion p WHERE p.prdLiquidacionNumeracionPK.numMotivo = :numMotivo"),
    @NamedQuery(name = "PrdLiquidacionNumeracion.findByNumSecuencia", query = "SELECT p FROM PrdLiquidacionNumeracion p WHERE p.numSecuencia = :numSecuencia")})
public class PrdLiquidacionNumeracion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrdLiquidacionNumeracionPK prdLiquidacionNumeracionPK;
    @Basic(optional = false)
    @Column(name = "num_secuencia")
    private String numSecuencia;

    public PrdLiquidacionNumeracion() {
    }

    public PrdLiquidacionNumeracion(PrdLiquidacionNumeracionPK prdLiquidacionNumeracionPK) {
        this.prdLiquidacionNumeracionPK = prdLiquidacionNumeracionPK;
    }

    public PrdLiquidacionNumeracion(PrdLiquidacionNumeracionPK prdLiquidacionNumeracionPK, String numSecuencia) {
        this.prdLiquidacionNumeracionPK = prdLiquidacionNumeracionPK;
        this.numSecuencia = numSecuencia;
    }

    public PrdLiquidacionNumeracion(String numEmpresa, String numMotivo) {
        this.prdLiquidacionNumeracionPK = new PrdLiquidacionNumeracionPK(numEmpresa, numMotivo);
    }

    public PrdLiquidacionNumeracionPK getPrdLiquidacionNumeracionPK() {
        return prdLiquidacionNumeracionPK;
    }

    public void setPrdLiquidacionNumeracionPK(PrdLiquidacionNumeracionPK prdLiquidacionNumeracionPK) {
        this.prdLiquidacionNumeracionPK = prdLiquidacionNumeracionPK;
    }

    public String getNumSecuencia() {
        return numSecuencia;
    }

    public void setNumSecuencia(String numSecuencia) {
        this.numSecuencia = numSecuencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prdLiquidacionNumeracionPK != null ? prdLiquidacionNumeracionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrdLiquidacionNumeracion)) {
            return false;
        }
        PrdLiquidacionNumeracion other = (PrdLiquidacionNumeracion) object;
        if ((this.prdLiquidacionNumeracionPK == null && other.prdLiquidacionNumeracionPK != null) || (this.prdLiquidacionNumeracionPK != null && !this.prdLiquidacionNumeracionPK.equals(other.prdLiquidacionNumeracionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produccion.entity.PrdLiquidacionNumeracion[ prdLiquidacionNumeracionPK=" + prdLiquidacionNumeracionPK + " ]";
    }
    
}
