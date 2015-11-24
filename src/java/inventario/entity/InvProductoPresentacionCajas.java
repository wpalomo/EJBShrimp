/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "inv_producto_presentacion_cajas", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvProductoPresentacionCajas.findAll", query = "SELECT i FROM InvProductoPresentacionCajas i"),
    @NamedQuery(name = "InvProductoPresentacionCajas.findByPrescEmpresa", query = "SELECT i FROM InvProductoPresentacionCajas i WHERE i.invProductoPresentacionCajasPK.prescEmpresa = :prescEmpresa"),
    @NamedQuery(name = "InvProductoPresentacionCajas.findByPrescCodigo", query = "SELECT i FROM InvProductoPresentacionCajas i WHERE i.invProductoPresentacionCajasPK.prescCodigo = :prescCodigo"),
    @NamedQuery(name = "InvProductoPresentacionCajas.findByPrescDetalle", query = "SELECT i FROM InvProductoPresentacionCajas i WHERE i.prescDetalle = :prescDetalle"),
    @NamedQuery(name = "InvProductoPresentacionCajas.findByPrescAbreviado", query = "SELECT i FROM InvProductoPresentacionCajas i WHERE i.prescAbreviado = :prescAbreviado"),
    @NamedQuery(name = "InvProductoPresentacionCajas.findByUsrEmpresa", query = "SELECT i FROM InvProductoPresentacionCajas i WHERE i.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "InvProductoPresentacionCajas.findByUsrCodigo", query = "SELECT i FROM InvProductoPresentacionCajas i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvProductoPresentacionCajas.findByUsrFechaInserta", query = "SELECT i FROM InvProductoPresentacionCajas i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvProductoPresentacionCajas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvProductoPresentacionCajasPK invProductoPresentacionCajasPK;
    @Basic(optional = false)
    @Column(name = "presc_detalle")
    private String prescDetalle;
    @Basic(optional = false)
    @Column(name = "presc_abreviado")
    private String prescAbreviado;
    @Basic(optional = false)
    @Column(name = "usr_empresa")
    private String usrEmpresa;
    @Basic(optional = false)
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Basic(optional = false)
    @Column(name = "usr_fecha_inserta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInserta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invProductoPresentacionCajas")
    private List<InvProducto> invProductoList;

    public InvProductoPresentacionCajas() {
    }

    public InvProductoPresentacionCajas(InvProductoPresentacionCajasPK invProductoPresentacionCajasPK) {
        this.invProductoPresentacionCajasPK = invProductoPresentacionCajasPK;
    }

    public InvProductoPresentacionCajas(InvProductoPresentacionCajasPK invProductoPresentacionCajasPK, String prescDetalle, String prescAbreviado, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.invProductoPresentacionCajasPK = invProductoPresentacionCajasPK;
        this.prescDetalle = prescDetalle;
        this.prescAbreviado = prescAbreviado;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public InvProductoPresentacionCajas(String prescEmpresa, String prescCodigo) {
        this.invProductoPresentacionCajasPK = new InvProductoPresentacionCajasPK(prescEmpresa, prescCodigo);
    }

    public InvProductoPresentacionCajasPK getInvProductoPresentacionCajasPK() {
        return invProductoPresentacionCajasPK;
    }

    public void setInvProductoPresentacionCajasPK(InvProductoPresentacionCajasPK invProductoPresentacionCajasPK) {
        this.invProductoPresentacionCajasPK = invProductoPresentacionCajasPK;
    }

    public String getPrescDetalle() {
        return prescDetalle;
    }

    public void setPrescDetalle(String prescDetalle) {
        this.prescDetalle = prescDetalle;
    }

    public String getPrescAbreviado() {
        return prescAbreviado;
    }

    public void setPrescAbreviado(String prescAbreviado) {
        this.prescAbreviado = prescAbreviado;
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

    public List<InvProducto> getInvProductoList() {
        return invProductoList;
    }

    public void setInvProductoList(List<InvProducto> invProductoList) {
        this.invProductoList = invProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invProductoPresentacionCajasPK != null ? invProductoPresentacionCajasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProductoPresentacionCajas)) {
            return false;
        }
        InvProductoPresentacionCajas other = (InvProductoPresentacionCajas) object;
        if ((this.invProductoPresentacionCajasPK == null && other.invProductoPresentacionCajasPK != null) || (this.invProductoPresentacionCajasPK != null && !this.invProductoPresentacionCajasPK.equals(other.invProductoPresentacionCajasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvProductoPresentacionCajas[ invProductoPresentacionCajasPK=" + invProductoPresentacionCajasPK + " ]";
    }
    
}
