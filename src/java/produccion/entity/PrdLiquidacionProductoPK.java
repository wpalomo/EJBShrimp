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
public class PrdLiquidacionProductoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "prod_empresa")
    private String prodEmpresa;
    @Basic(optional = false)
    @Column(name = "prod_codigo")
    private String prodCodigo;

    public PrdLiquidacionProductoPK() {
    }

    public PrdLiquidacionProductoPK(String prodEmpresa, String prodCodigo) {
        this.prodEmpresa = prodEmpresa;
        this.prodCodigo = prodCodigo;
    }

    public String getProdEmpresa() {
        return prodEmpresa;
    }

    public void setProdEmpresa(String prodEmpresa) {
        this.prodEmpresa = prodEmpresa;
    }

    public String getProdCodigo() {
        return prodCodigo;
    }

    public void setProdCodigo(String prodCodigo) {
        this.prodCodigo = prodCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodEmpresa != null ? prodEmpresa.hashCode() : 0);
        hash += (prodCodigo != null ? prodCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrdLiquidacionProductoPK)) {
            return false;
        }
        PrdLiquidacionProductoPK other = (PrdLiquidacionProductoPK) object;
        if ((this.prodEmpresa == null && other.prodEmpresa != null) || (this.prodEmpresa != null && !this.prodEmpresa.equals(other.prodEmpresa))) {
            return false;
        }
        if ((this.prodCodigo == null && other.prodCodigo != null) || (this.prodCodigo != null && !this.prodCodigo.equals(other.prodCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produccion.entity.PrdLiquidacionProductoPK[ prodEmpresa=" + prodEmpresa + ", prodCodigo=" + prodCodigo + " ]";
    }
    
}
