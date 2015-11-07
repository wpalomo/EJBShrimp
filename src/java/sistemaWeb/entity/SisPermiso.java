/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaWeb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "sis_permiso", schema = "sistemaweb")
@NamedQueries({
    @NamedQuery(name = "SisPermiso.findAll", query = "SELECT s FROM SisPermiso s"),
    @NamedQuery(name = "SisPermiso.findByPerEmpresa", query = "SELECT s FROM SisPermiso s WHERE s.sisPermisoPK.perEmpresa = :perEmpresa"),
    @NamedQuery(name = "SisPermiso.findByPerModulo", query = "SELECT s FROM SisPermiso s WHERE s.sisPermisoPK.perModulo = :perModulo"),
    @NamedQuery(name = "SisPermiso.findByPerMenu", query = "SELECT s FROM SisPermiso s WHERE s.sisPermisoPK.perMenu = :perMenu"),
    @NamedQuery(name = "SisPermiso.findByPerItem", query = "SELECT s FROM SisPermiso s WHERE s.sisPermisoPK.perItem = :perItem"),
    @NamedQuery(name = "SisPermiso.findByPerItemEtiqueta", query = "SELECT s FROM SisPermiso s WHERE s.perItemEtiqueta = :perItemEtiqueta"),
    @NamedQuery(name = "SisPermiso.findByPerSecuencia", query = "SELECT s FROM SisPermiso s WHERE s.perSecuencia = :perSecuencia"),
    @NamedQuery(name = "SisPermiso.findByPerUsuarios", query = "SELECT s FROM SisPermiso s WHERE s.perUsuarios = :perUsuarios")})
public class SisPermiso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SisPermisoPK sisPermisoPK;
    @Basic(optional = false)
    @Column(name = "per_item_etiqueta")
    private String perItemEtiqueta;
    @Basic(optional = false)
    @Column(name = "per_secuencia")
    private int perSecuencia;
    @Basic(optional = false)
    @Column(name = "per_usuarios")
    private String perUsuarios;
    @JoinColumn(name = "emp_codigo", referencedColumnName = "emp_codigo")
    @ManyToOne(optional = false)
    private SisEmpresa empCodigo;

    public SisPermiso() {
    }

    public SisPermiso(SisPermisoPK sisPermisoPK) {
        this.sisPermisoPK = sisPermisoPK;
    }

    public SisPermiso(SisPermisoPK sisPermisoPK, String perItemEtiqueta, int perSecuencia, String perUsuarios) {
        this.sisPermisoPK = sisPermisoPK;
        this.perItemEtiqueta = perItemEtiqueta;
        this.perSecuencia = perSecuencia;
        this.perUsuarios = perUsuarios;
    }

    public SisPermiso(String perEmpresa, String perModulo, String perMenu, String perItem) {
        this.sisPermisoPK = new SisPermisoPK(perEmpresa, perModulo, perMenu, perItem);
    }

    public SisPermisoPK getSisPermisoPK() {
        return sisPermisoPK;
    }

    public void setSisPermisoPK(SisPermisoPK sisPermisoPK) {
        this.sisPermisoPK = sisPermisoPK;
    }

    public String getPerItemEtiqueta() {
        return perItemEtiqueta;
    }

    public void setPerItemEtiqueta(String perItemEtiqueta) {
        this.perItemEtiqueta = perItemEtiqueta;
    }

    public int getPerSecuencia() {
        return perSecuencia;
    }

    public void setPerSecuencia(int perSecuencia) {
        this.perSecuencia = perSecuencia;
    }

    public String getPerUsuarios() {
        return perUsuarios;
    }

    public void setPerUsuarios(String perUsuarios) {
        this.perUsuarios = perUsuarios;
    }

    public SisEmpresa getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(SisEmpresa empCodigo) {
        this.empCodigo = empCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sisPermisoPK != null ? sisPermisoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SisPermiso)) {
            return false;
        }
        SisPermiso other = (SisPermiso) object;
        if ((this.sisPermisoPK == null && other.sisPermisoPK != null) || (this.sisPermisoPK != null && !this.sisPermisoPK.equals(other.sisPermisoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemaWeb.entity.SisPermiso[ sisPermisoPK=" + sisPermisoPK + " ]";
    }
    
}
