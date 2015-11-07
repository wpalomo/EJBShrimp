/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaWeb.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "sis_suceso", schema = "sistemaweb")
@NamedQueries({
    @NamedQuery(name = "SisSuceso.findAll", query = "SELECT s FROM SisSuceso s"),
    @NamedQuery(name = "SisSuceso.findBySusSecuencia", query = "SELECT s FROM SisSuceso s WHERE s.susSecuencia = :susSecuencia"),
    @NamedQuery(name = "SisSuceso.findBySusTabla", query = "SELECT s FROM SisSuceso s WHERE s.susTabla = :susTabla"),
    @NamedQuery(name = "SisSuceso.findBySusClave", query = "SELECT s FROM SisSuceso s WHERE s.susClave = :susClave"),
    @NamedQuery(name = "SisSuceso.findBySusSuceso", query = "SELECT s FROM SisSuceso s WHERE s.susSuceso = :susSuceso"),
    @NamedQuery(name = "SisSuceso.findBySusDetalle", query = "SELECT s FROM SisSuceso s WHERE s.susDetalle = :susDetalle"),
    @NamedQuery(name = "SisSuceso.findBySusMac", query = "SELECT s FROM SisSuceso s WHERE s.susMac = :susMac"),
    @NamedQuery(name = "SisSuceso.findBySusFecha", query = "SELECT s FROM SisSuceso s WHERE s.susFecha = :susFecha")})
public class SisSuceso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sus_secuencia")
    private Integer susSecuencia;
    @Basic(optional = false)
    @Column(name = "sus_tabla")
    private String susTabla;
    @Basic(optional = false)
    @Column(name = "sus_clave")
    private String susClave;
    @Basic(optional = false)
    @Column(name = "sus_suceso")
    private String susSuceso;
    @Column(name = "sus_detalle")
    private String susDetalle;
    @Basic(optional = false)
    @Column(name = "sus_mac")
    private String susMac;
    @Basic(optional = false)
    @Column(name = "sus_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date susFecha;
    @JoinColumns({
        @JoinColumn(name = "det_empresa", referencedColumnName = "det_empresa"),
        @JoinColumn(name = "det_usuario", referencedColumnName = "det_usuario")})
    @ManyToOne(optional = false)
    private SisUsuarioDetalle sisUsuarioDetalle;

    public SisSuceso() {
    }

    public SisSuceso(Integer susSecuencia) {
        this.susSecuencia = susSecuencia;
    }

    public SisSuceso(Integer susSecuencia, String susTabla, String susClave, String susSuceso, String susMac, Date susFecha) {
        this.susSecuencia = susSecuencia;
        this.susTabla = susTabla;
        this.susClave = susClave;
        this.susSuceso = susSuceso;
        this.susMac = susMac;
        this.susFecha = susFecha;
    }

    public Integer getSusSecuencia() {
        return susSecuencia;
    }

    public void setSusSecuencia(Integer susSecuencia) {
        this.susSecuencia = susSecuencia;
    }

    public String getSusTabla() {
        return susTabla;
    }

    public void setSusTabla(String susTabla) {
        this.susTabla = susTabla;
    }

    public String getSusClave() {
        return susClave;
    }

    public void setSusClave(String susClave) {
        this.susClave = susClave;
    }

    public String getSusSuceso() {
        return susSuceso;
    }

    public void setSusSuceso(String susSuceso) {
        this.susSuceso = susSuceso;
    }

    public String getSusDetalle() {
        return susDetalle;
    }

    public void setSusDetalle(String susDetalle) {
        this.susDetalle = susDetalle;
    }

    public String getSusMac() {
        return susMac;
    }

    public void setSusMac(String susMac) {
        this.susMac = susMac;
    }

    public Date getSusFecha() {
        return susFecha;
    }

    public void setSusFecha(Date susFecha) {
        this.susFecha = susFecha;
    }

    public SisUsuarioDetalle getSisUsuarioDetalle() {
        return sisUsuarioDetalle;
    }

    public void setSisUsuarioDetalle(SisUsuarioDetalle sisUsuarioDetalle) {
        this.sisUsuarioDetalle = sisUsuarioDetalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (susSecuencia != null ? susSecuencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SisSuceso)) {
            return false;
        }
        SisSuceso other = (SisSuceso) object;
        if ((this.susSecuencia == null && other.susSecuencia != null) || (this.susSecuencia != null && !this.susSecuencia.equals(other.susSecuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemaWeb.entity.SisSuceso[ susSecuencia=" + susSecuencia + " ]";
    }
    
}
