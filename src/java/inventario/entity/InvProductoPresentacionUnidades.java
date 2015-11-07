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
@Table(name = "inv_producto_presentacion_unidades", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvProductoPresentacionUnidades.findAll", query = "SELECT i FROM InvProductoPresentacionUnidades i"),
    @NamedQuery(name = "InvProductoPresentacionUnidades.findByPresuEmpresa", query = "SELECT i FROM InvProductoPresentacionUnidades i WHERE i.invProductoPresentacionUnidadesPK.presuEmpresa = :presuEmpresa"),
    @NamedQuery(name = "InvProductoPresentacionUnidades.findByPresuCodigo", query = "SELECT i FROM InvProductoPresentacionUnidades i WHERE i.invProductoPresentacionUnidadesPK.presuCodigo = :presuCodigo"),
    @NamedQuery(name = "InvProductoPresentacionUnidades.findByPresuDetalle", query = "SELECT i FROM InvProductoPresentacionUnidades i WHERE i.presuDetalle = :presuDetalle"),
    @NamedQuery(name = "InvProductoPresentacionUnidades.findByPresuAbreviado", query = "SELECT i FROM InvProductoPresentacionUnidades i WHERE i.presuAbreviado = :presuAbreviado"),
    @NamedQuery(name = "InvProductoPresentacionUnidades.findByUsrEmpresa", query = "SELECT i FROM InvProductoPresentacionUnidades i WHERE i.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "InvProductoPresentacionUnidades.findByUsrCodigo", query = "SELECT i FROM InvProductoPresentacionUnidades i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvProductoPresentacionUnidades.findByUsrFechaInserta", query = "SELECT i FROM InvProductoPresentacionUnidades i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvProductoPresentacionUnidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvProductoPresentacionUnidadesPK invProductoPresentacionUnidadesPK;
    @Basic(optional = false)
    @Column(name = "presu_detalle")
    private String presuDetalle;
    @Basic(optional = false)
    @Column(name = "presu_abreviado")
    private String presuAbreviado;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invProductoPresentacionUnidades")
    private List<InvProducto> invProductoList;

    public InvProductoPresentacionUnidades() {
    }

    public InvProductoPresentacionUnidades(InvProductoPresentacionUnidadesPK invProductoPresentacionUnidadesPK) {
        this.invProductoPresentacionUnidadesPK = invProductoPresentacionUnidadesPK;
    }

    public InvProductoPresentacionUnidades(InvProductoPresentacionUnidadesPK invProductoPresentacionUnidadesPK, String presuDetalle, String presuAbreviado, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.invProductoPresentacionUnidadesPK = invProductoPresentacionUnidadesPK;
        this.presuDetalle = presuDetalle;
        this.presuAbreviado = presuAbreviado;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public InvProductoPresentacionUnidades(String presuEmpresa, String presuCodigo) {
        this.invProductoPresentacionUnidadesPK = new InvProductoPresentacionUnidadesPK(presuEmpresa, presuCodigo);
    }

    public InvProductoPresentacionUnidadesPK getInvProductoPresentacionUnidadesPK() {
        return invProductoPresentacionUnidadesPK;
    }

    public void setInvProductoPresentacionUnidadesPK(InvProductoPresentacionUnidadesPK invProductoPresentacionUnidadesPK) {
        this.invProductoPresentacionUnidadesPK = invProductoPresentacionUnidadesPK;
    }

    public String getPresuDetalle() {
        return presuDetalle;
    }

    public void setPresuDetalle(String presuDetalle) {
        this.presuDetalle = presuDetalle;
    }

    public String getPresuAbreviado() {
        return presuAbreviado;
    }

    public void setPresuAbreviado(String presuAbreviado) {
        this.presuAbreviado = presuAbreviado;
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
        hash += (invProductoPresentacionUnidadesPK != null ? invProductoPresentacionUnidadesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProductoPresentacionUnidades)) {
            return false;
        }
        InvProductoPresentacionUnidades other = (InvProductoPresentacionUnidades) object;
        if ((this.invProductoPresentacionUnidadesPK == null && other.invProductoPresentacionUnidadesPK != null) || (this.invProductoPresentacionUnidadesPK != null && !this.invProductoPresentacionUnidadesPK.equals(other.invProductoPresentacionUnidadesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvProductoPresentacionUnidades[ invProductoPresentacionUnidadesPK=" + invProductoPresentacionUnidadesPK + " ]";
    }
    
}
