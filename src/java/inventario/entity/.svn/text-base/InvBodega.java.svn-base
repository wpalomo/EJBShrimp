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
@Table(name = "inv_bodega", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvBodega.findAll", query = "SELECT i FROM InvBodega i"),
    @NamedQuery(name = "InvBodega.findByBodEmpresa", query = "SELECT i FROM InvBodega i WHERE i.invBodegaPK.bodEmpresa = :bodEmpresa"),
    @NamedQuery(name = "InvBodega.findByBodCodigo", query = "SELECT i FROM InvBodega i WHERE i.invBodegaPK.bodCodigo = :bodCodigo"),
    @NamedQuery(name = "InvBodega.findByBodNombre", query = "SELECT i FROM InvBodega i WHERE i.bodNombre = :bodNombre"),
    @NamedQuery(name = "InvBodega.findByBodInactiva", query = "SELECT i FROM InvBodega i WHERE i.bodInactiva = :bodInactiva"),
    @NamedQuery(name = "InvBodega.findBySecEmpresa", query = "SELECT i FROM InvBodega i WHERE i.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "InvBodega.findBySecCodigo", query = "SELECT i FROM InvBodega i WHERE i.secCodigo = :secCodigo"),
    @NamedQuery(name = "InvBodega.findByDetEmpresa", query = "SELECT i FROM InvBodega i WHERE i.detEmpresa = :detEmpresa"),
    @NamedQuery(name = "InvBodega.findByDetUsuario", query = "SELECT i FROM InvBodega i WHERE i.detUsuario = :detUsuario"),
    @NamedQuery(name = "InvBodega.findByUsrEmpresa", query = "SELECT i FROM InvBodega i WHERE i.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "InvBodega.findByUsrCodigo", query = "SELECT i FROM InvBodega i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvBodega.findByUsrFechaInserta", query = "SELECT i FROM InvBodega i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvBodega implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvBodegaPK invBodegaPK;
    @Basic(optional = false)
    @Column(name = "bod_nombre")
    private String bodNombre;
    @Column(name = "bod_inactiva")
    private Boolean bodInactiva;
    @Basic(optional = false)
    @Column(name = "sec_empresa")
    private String secEmpresa;
    @Basic(optional = false)
    @Column(name = "sec_codigo")
    private String secCodigo;
    @Column(name = "det_empresa")
    private String detEmpresa;
    @Column(name = "det_usuario")
    private String detUsuario;
    @Column(name = "usr_empresa")
    private String usrEmpresa;
    @Column(name = "usr_codigo")
    private String usrCodigo;
    @Column(name = "usr_fecha_inserta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInserta;
    @OneToMany(mappedBy = "invBodega")
    private List<InvConsumos> invConsumosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invBodega")
    private List<InvVentasDetalle> invVentasDetalleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invBodega")
    private List<InvConsumosDetalle> invConsumosDetalleList;
    @OneToMany(mappedBy = "invBodega")
    private List<InvTransferencias> invTransferenciasList;
    @OneToMany(mappedBy = "invBodega1")
    private List<InvTransferencias> invTransferenciasList1;
    @OneToMany(mappedBy = "invBodega")
    private List<InvTransferenciasDetalle> invTransferenciasDetalleList;
    @OneToMany(mappedBy = "invBodega1")
    private List<InvTransferenciasDetalle> invTransferenciasDetalleList1;
    @OneToMany(mappedBy = "invBodega")
    private List<InvProductoSaldos> invProductoSaldosList;
    @OneToMany(mappedBy = "invBodega")
    private List<InvCompras> invComprasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invBodega")
    private List<InvComprasDetalle> invComprasDetalleList;

    public InvBodega() {
    }

    public InvBodega(InvBodegaPK invBodegaPK) {
        this.invBodegaPK = invBodegaPK;
    }

    public InvBodega(InvBodegaPK invBodegaPK, String bodNombre, String secEmpresa, String secCodigo) {
        this.invBodegaPK = invBodegaPK;
        this.bodNombre = bodNombre;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
    }

    public InvBodega(String bodEmpresa, String bodCodigo) {
        this.invBodegaPK = new InvBodegaPK(bodEmpresa, bodCodigo);
    }

    public InvBodegaPK getInvBodegaPK() {
        return invBodegaPK;
    }

    public void setInvBodegaPK(InvBodegaPK invBodegaPK) {
        this.invBodegaPK = invBodegaPK;
    }

    public String getBodNombre() {
        return bodNombre;
    }

    public void setBodNombre(String bodNombre) {
        this.bodNombre = bodNombre;
    }

    public Boolean getBodInactiva() {
        return bodInactiva;
    }

    public void setBodInactiva(Boolean bodInactiva) {
        this.bodInactiva = bodInactiva;
    }

    public String getSecEmpresa() {
        return secEmpresa;
    }

    public void setSecEmpresa(String secEmpresa) {
        this.secEmpresa = secEmpresa;
    }

    public String getSecCodigo() {
        return secCodigo;
    }

    public void setSecCodigo(String secCodigo) {
        this.secCodigo = secCodigo;
    }

    public String getDetEmpresa() {
        return detEmpresa;
    }

    public void setDetEmpresa(String detEmpresa) {
        this.detEmpresa = detEmpresa;
    }

    public String getDetUsuario() {
        return detUsuario;
    }

    public void setDetUsuario(String detUsuario) {
        this.detUsuario = detUsuario;
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

    public List<InvConsumos> getInvConsumosList() {
        return invConsumosList;
    }

    public void setInvConsumosList(List<InvConsumos> invConsumosList) {
        this.invConsumosList = invConsumosList;
    }

    public List<InvVentasDetalle> getInvVentasDetalleList() {
        return invVentasDetalleList;
    }

    public void setInvVentasDetalleList(List<InvVentasDetalle> invVentasDetalleList) {
        this.invVentasDetalleList = invVentasDetalleList;
    }

    public List<InvConsumosDetalle> getInvConsumosDetalleList() {
        return invConsumosDetalleList;
    }

    public void setInvConsumosDetalleList(List<InvConsumosDetalle> invConsumosDetalleList) {
        this.invConsumosDetalleList = invConsumosDetalleList;
    }

    public List<InvTransferencias> getInvTransferenciasList() {
        return invTransferenciasList;
    }

    public void setInvTransferenciasList(List<InvTransferencias> invTransferenciasList) {
        this.invTransferenciasList = invTransferenciasList;
    }

    public List<InvTransferencias> getInvTransferenciasList1() {
        return invTransferenciasList1;
    }

    public void setInvTransferenciasList1(List<InvTransferencias> invTransferenciasList1) {
        this.invTransferenciasList1 = invTransferenciasList1;
    }

    public List<InvTransferenciasDetalle> getInvTransferenciasDetalleList() {
        return invTransferenciasDetalleList;
    }

    public void setInvTransferenciasDetalleList(List<InvTransferenciasDetalle> invTransferenciasDetalleList) {
        this.invTransferenciasDetalleList = invTransferenciasDetalleList;
    }

    public List<InvTransferenciasDetalle> getInvTransferenciasDetalleList1() {
        return invTransferenciasDetalleList1;
    }

    public void setInvTransferenciasDetalleList1(List<InvTransferenciasDetalle> invTransferenciasDetalleList1) {
        this.invTransferenciasDetalleList1 = invTransferenciasDetalleList1;
    }

    public List<InvProductoSaldos> getInvProductoSaldosList() {
        return invProductoSaldosList;
    }

    public void setInvProductoSaldosList(List<InvProductoSaldos> invProductoSaldosList) {
        this.invProductoSaldosList = invProductoSaldosList;
    }

    public List<InvCompras> getInvComprasList() {
        return invComprasList;
    }

    public void setInvComprasList(List<InvCompras> invComprasList) {
        this.invComprasList = invComprasList;
    }

    public List<InvComprasDetalle> getInvComprasDetalleList() {
        return invComprasDetalleList;
    }

    public void setInvComprasDetalleList(List<InvComprasDetalle> invComprasDetalleList) {
        this.invComprasDetalleList = invComprasDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invBodegaPK != null ? invBodegaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvBodega)) {
            return false;
        }
        InvBodega other = (InvBodega) object;
        if ((this.invBodegaPK == null && other.invBodegaPK != null) || (this.invBodegaPK != null && !this.invBodegaPK.equals(other.invBodegaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvBodega[ invBodegaPK=" + invBodegaPK + " ]";
    }
    
}
