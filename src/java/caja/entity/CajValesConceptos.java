/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "caj_vales_conceptos", schema = "caja")
@NamedQueries({
    @NamedQuery(name = "CajValesConceptos.findAll", query = "SELECT c FROM CajValesConceptos c"),
    @NamedQuery(name = "CajValesConceptos.findByConcEmpresa", query = "SELECT c FROM CajValesConceptos c WHERE c.cajValesConceptosPK.concEmpresa = :concEmpresa"),
    @NamedQuery(name = "CajValesConceptos.findByConcCodigo", query = "SELECT c FROM CajValesConceptos c WHERE c.cajValesConceptosPK.concCodigo = :concCodigo"),
    @NamedQuery(name = "CajValesConceptos.findByConcDetalle", query = "SELECT c FROM CajValesConceptos c WHERE c.concDetalle = :concDetalle"),
    @NamedQuery(name = "CajValesConceptos.findByConcInactivo", query = "SELECT c FROM CajValesConceptos c WHERE c.concInactivo = :concInactivo"),
    @NamedQuery(name = "CajValesConceptos.findByUsrEmpresa", query = "SELECT c FROM CajValesConceptos c WHERE c.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "CajValesConceptos.findByUsrCodigo", query = "SELECT c FROM CajValesConceptos c WHERE c.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "CajValesConceptos.findByUsrFechaInserta", query = "SELECT c FROM CajValesConceptos c WHERE c.usrFechaInserta = :usrFechaInserta")})
public class CajValesConceptos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CajValesConceptosPK cajValesConceptosPK;
    @Basic(optional = false)
    @Column(name = "conc_detalle")
    private String concDetalle;
    @Basic(optional = false)
    @Column(name = "conc_inactivo")
    private boolean concInactivo;
    @Basic(optional = false)
    @Column(name = "usr_empresa")
    private String usrEmpresa;
    @Basic(optional = false)
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Column(name = "usr_fecha_inserta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInserta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cajValesConceptos")
    private List<CajVales> cajValesList;

    public CajValesConceptos() {
    }

    public CajValesConceptos(CajValesConceptosPK cajValesConceptosPK) {
        this.cajValesConceptosPK = cajValesConceptosPK;
    }

    public CajValesConceptos(CajValesConceptosPK cajValesConceptosPK, String concDetalle, boolean concInactivo, String usrEmpresa, String usrCodigo) {
        this.cajValesConceptosPK = cajValesConceptosPK;
        this.concDetalle = concDetalle;
        this.concInactivo = concInactivo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
    }

    public CajValesConceptos(String concEmpresa, String concCodigo) {
        this.cajValesConceptosPK = new CajValesConceptosPK(concEmpresa, concCodigo);
    }

    public CajValesConceptosPK getCajValesConceptosPK() {
        return cajValesConceptosPK;
    }

    public void setCajValesConceptosPK(CajValesConceptosPK cajValesConceptosPK) {
        this.cajValesConceptosPK = cajValesConceptosPK;
    }

    public String getConcDetalle() {
        return concDetalle;
    }

    public void setConcDetalle(String concDetalle) {
        this.concDetalle = concDetalle;
    }

    public boolean getConcInactivo() {
        return concInactivo;
    }

    public void setConcInactivo(boolean concInactivo) {
        this.concInactivo = concInactivo;
    }

    public String getUsrEmpresa() {
        return usrEmpresa;
    }

    public void setUsrEmpresa(String usrEmpresa) {
        this.usrEmpresa = usrEmpresa;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public Date getUsrFechaInserta() {
        return usrFechaInserta;
    }

    public void setUsrFechaInserta(Date usrFechaInserta) {
        this.usrFechaInserta = usrFechaInserta;
    }

    public List<CajVales> getCajValesList() {
        return cajValesList;
    }

    public void setCajValesList(List<CajVales> cajValesList) {
        this.cajValesList = cajValesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cajValesConceptosPK != null ? cajValesConceptosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CajValesConceptos)) {
            return false;
        }
        CajValesConceptos other = (CajValesConceptos) object;
        if ((this.cajValesConceptosPK == null && other.cajValesConceptosPK != null) || (this.cajValesConceptosPK != null && !this.cajValesConceptosPK.equals(other.cajValesConceptosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "caja.entity.CajValesConceptos[ cajValesConceptosPK=" + cajValesConceptosPK + " ]";
    }
    
}
