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
@Table(name = "inv_ventas_complemento", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvVentasComplemento.findAll", query = "SELECT i FROM InvVentasComplemento i"),
    @NamedQuery(name = "InvVentasComplemento.findByComEmpresa", query = "SELECT i FROM InvVentasComplemento i WHERE i.invVentasComplementoPK.comEmpresa = :comEmpresa"),
    @NamedQuery(name = "InvVentasComplemento.findByComPeriodo", query = "SELECT i FROM InvVentasComplemento i WHERE i.invVentasComplementoPK.comPeriodo = :comPeriodo"),
    @NamedQuery(name = "InvVentasComplemento.findByComMotivo", query = "SELECT i FROM InvVentasComplemento i WHERE i.invVentasComplementoPK.comMotivo = :comMotivo"),
    @NamedQuery(name = "InvVentasComplemento.findByComNumero", query = "SELECT i FROM InvVentasComplemento i WHERE i.invVentasComplementoPK.comNumero = :comNumero"),
    @NamedQuery(name = "InvVentasComplemento.findByComDocumentoTipo", query = "SELECT i FROM InvVentasComplemento i WHERE i.comDocumentoTipo = :comDocumentoTipo"),
    @NamedQuery(name = "InvVentasComplemento.findByComDocumentoNumero", query = "SELECT i FROM InvVentasComplemento i WHERE i.comDocumentoNumero = :comDocumentoNumero")})
public class InvVentasComplemento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvVentasComplementoPK invVentasComplementoPK;
    @Basic(optional = false)
    @Column(name = "com_documento_tipo")
    private String comDocumentoTipo;
    @Basic(optional = false)
    @Column(name = "com_documento_numero")
    private String comDocumentoNumero;
    @JoinColumns({
        @JoinColumn(name = "vta_empresa", referencedColumnName = "vta_empresa"),
        @JoinColumn(name = "vta_periodo", referencedColumnName = "vta_periodo"),
        @JoinColumn(name = "vta_motivo", referencedColumnName = "vta_motivo"),
        @JoinColumn(name = "vta_numero", referencedColumnName = "vta_numero")})
    @ManyToOne(optional = false)
    private InvVentas invVentas;

    public InvVentasComplemento() {
    }

    public InvVentasComplemento(InvVentasComplementoPK invVentasComplementoPK) {
        this.invVentasComplementoPK = invVentasComplementoPK;
    }

    public InvVentasComplemento(InvVentasComplementoPK invVentasComplementoPK, String comDocumentoTipo, String comDocumentoNumero) {
        this.invVentasComplementoPK = invVentasComplementoPK;
        this.comDocumentoTipo = comDocumentoTipo;
        this.comDocumentoNumero = comDocumentoNumero;
    }

    public InvVentasComplemento(String comEmpresa, String comPeriodo, String comMotivo, String comNumero) {
        this.invVentasComplementoPK = new InvVentasComplementoPK(comEmpresa, comPeriodo, comMotivo, comNumero);
    }

    public InvVentasComplementoPK getInvVentasComplementoPK() {
        return invVentasComplementoPK;
    }

    public void setInvVentasComplementoPK(InvVentasComplementoPK invVentasComplementoPK) {
        this.invVentasComplementoPK = invVentasComplementoPK;
    }

    public String getComDocumentoTipo() {
        return comDocumentoTipo;
    }

    public void setComDocumentoTipo(String comDocumentoTipo) {
        this.comDocumentoTipo = comDocumentoTipo;
    }

    public String getComDocumentoNumero() {
        return comDocumentoNumero;
    }

    public void setComDocumentoNumero(String comDocumentoNumero) {
        this.comDocumentoNumero = comDocumentoNumero;
    }

    public InvVentas getInvVentas() {
        return invVentas;
    }

    public void setInvVentas(InvVentas invVentas) {
        this.invVentas = invVentas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invVentasComplementoPK != null ? invVentasComplementoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvVentasComplemento)) {
            return false;
        }
        InvVentasComplemento other = (InvVentasComplemento) object;
        if ((this.invVentasComplementoPK == null && other.invVentasComplementoPK != null) || (this.invVentasComplementoPK != null && !this.invVentasComplementoPK.equals(other.invVentasComplementoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvVentasComplemento[ invVentasComplementoPK=" + invVentasComplementoPK + " ]";
    }
    
}
