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
@Table(name = "inv_consumos", schema = "inventario")
@NamedQueries({
    @NamedQuery(name = "InvConsumos.findAll", query = "SELECT i FROM InvConsumos i"),
    @NamedQuery(name = "InvConsumos.findByConsEmpresa", query = "SELECT i FROM InvConsumos i WHERE i.invConsumosPK.consEmpresa = :consEmpresa"),
    @NamedQuery(name = "InvConsumos.findByConsPeriodo", query = "SELECT i FROM InvConsumos i WHERE i.invConsumosPK.consPeriodo = :consPeriodo"),
    @NamedQuery(name = "InvConsumos.findByConsMotivo", query = "SELECT i FROM InvConsumos i WHERE i.invConsumosPK.consMotivo = :consMotivo"),
    @NamedQuery(name = "InvConsumos.findByConsNumero", query = "SELECT i FROM InvConsumos i WHERE i.invConsumosPK.consNumero = :consNumero"),
    @NamedQuery(name = "InvConsumos.findByConsReferencia", query = "SELECT i FROM InvConsumos i WHERE i.consReferencia = :consReferencia"),
    @NamedQuery(name = "InvConsumos.findByConsFecha", query = "SELECT i FROM InvConsumos i WHERE i.consFecha = :consFecha"),
    @NamedQuery(name = "InvConsumos.findByConsObservaciones", query = "SELECT i FROM InvConsumos i WHERE i.consObservaciones = :consObservaciones"),
    @NamedQuery(name = "InvConsumos.findByConsPendiente", query = "SELECT i FROM InvConsumos i WHERE i.consPendiente = :consPendiente"),
    @NamedQuery(name = "InvConsumos.findByConsRevisado", query = "SELECT i FROM InvConsumos i WHERE i.consRevisado = :consRevisado"),
    @NamedQuery(name = "InvConsumos.findByConsAnulado", query = "SELECT i FROM InvConsumos i WHERE i.consAnulado = :consAnulado"),
    @NamedQuery(name = "InvConsumos.findByConEmpresa", query = "SELECT i FROM InvConsumos i WHERE i.conEmpresa = :conEmpresa"),
    @NamedQuery(name = "InvConsumos.findByConPeriodo", query = "SELECT i FROM InvConsumos i WHERE i.conPeriodo = :conPeriodo"),
    @NamedQuery(name = "InvConsumos.findByConTipo", query = "SELECT i FROM InvConsumos i WHERE i.conTipo = :conTipo"),
    @NamedQuery(name = "InvConsumos.findByConNumero", query = "SELECT i FROM InvConsumos i WHERE i.conNumero = :conNumero"),
    @NamedQuery(name = "InvConsumos.findByUsrEmpresa", query = "SELECT i FROM InvConsumos i WHERE i.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "InvConsumos.findByUsrCodigo", query = "SELECT i FROM InvConsumos i WHERE i.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "InvConsumos.findByUsrFechaInserta", query = "SELECT i FROM InvConsumos i WHERE i.usrFechaInserta = :usrFechaInserta")})
public class InvConsumos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvConsumosPK invConsumosPK;
    @Column(name = "cons_referencia")
    private String consReferencia;
    @Basic(optional = false)
    @Column(name = "cons_fecha")
    @Temporal(TemporalType.DATE)
    private Date consFecha;
    @Column(name = "cons_observaciones")
    private String consObservaciones;
    @Basic(optional = false)
    @Column(name = "cons_pendiente")
    private boolean consPendiente;
    @Basic(optional = false)
    @Column(name = "cons_revisado")
    private boolean consRevisado;
    @Basic(optional = false)
    @Column(name = "cons_anulado")
    private boolean consAnulado;
    @Column(name = "con_empresa")
    private String conEmpresa;
    @Column(name = "con_periodo")
    private String conPeriodo;
    @Column(name = "con_tipo")
    private String conTipo;
    @Column(name = "con_numero")
    private String conNumero;
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
    @JoinColumns({
        @JoinColumn(name = "bod_empresa", referencedColumnName = "bod_empresa"),
        @JoinColumn(name = "bod_codigo", referencedColumnName = "bod_codigo")})
    @ManyToOne
    private InvBodega invBodega;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invConsumos")
    private List<InvConsumosDetalle> invConsumosDetalleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invConsumos")
    private List<InvConsumosMotivoAnulacion> invConsumosMotivoAnulacionList;

    public InvConsumos() {
    }

    public InvConsumos(InvConsumosPK invConsumosPK) {
        this.invConsumosPK = invConsumosPK;
    }

    public InvConsumos(InvConsumosPK invConsumosPK, Date consFecha, boolean consPendiente, boolean consRevisado, boolean consAnulado, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.invConsumosPK = invConsumosPK;
        this.consFecha = consFecha;
        this.consPendiente = consPendiente;
        this.consRevisado = consRevisado;
        this.consAnulado = consAnulado;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public InvConsumos(String consEmpresa, String consPeriodo, String consMotivo, String consNumero) {
        this.invConsumosPK = new InvConsumosPK(consEmpresa, consPeriodo, consMotivo, consNumero);
    }

    public InvConsumosPK getInvConsumosPK() {
        return invConsumosPK;
    }

    public void setInvConsumosPK(InvConsumosPK invConsumosPK) {
        this.invConsumosPK = invConsumosPK;
    }

    public String getConsReferencia() {
        return consReferencia;
    }

    public void setConsReferencia(String consReferencia) {
        this.consReferencia = consReferencia;
    }

    public Date getConsFecha() {
        return consFecha;
    }

    public void setConsFecha(Date consFecha) {
        this.consFecha = consFecha;
    }

    public String getConsObservaciones() {
        return consObservaciones;
    }

    public void setConsObservaciones(String consObservaciones) {
        this.consObservaciones = consObservaciones;
    }

    public boolean getConsPendiente() {
        return consPendiente;
    }

    public void setConsPendiente(boolean consPendiente) {
        this.consPendiente = consPendiente;
    }

    public boolean getConsRevisado() {
        return consRevisado;
    }

    public void setConsRevisado(boolean consRevisado) {
        this.consRevisado = consRevisado;
    }

    public boolean getConsAnulado() {
        return consAnulado;
    }

    public void setConsAnulado(boolean consAnulado) {
        this.consAnulado = consAnulado;
    }

    public String getConEmpresa() {
        return conEmpresa;
    }

    public void setConEmpresa(String conEmpresa) {
        this.conEmpresa = conEmpresa;
    }

    public String getConPeriodo() {
        return conPeriodo;
    }

    public void setConPeriodo(String conPeriodo) {
        this.conPeriodo = conPeriodo;
    }

    public String getConTipo() {
        return conTipo;
    }

    public void setConTipo(String conTipo) {
        this.conTipo = conTipo;
    }

    public String getConNumero() {
        return conNumero;
    }

    public void setConNumero(String conNumero) {
        this.conNumero = conNumero;
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

    public InvBodega getInvBodega() {
        return invBodega;
    }

    public void setInvBodega(InvBodega invBodega) {
        this.invBodega = invBodega;
    }

    public List<InvConsumosDetalle> getInvConsumosDetalleList() {
        return invConsumosDetalleList;
    }

    public void setInvConsumosDetalleList(List<InvConsumosDetalle> invConsumosDetalleList) {
        this.invConsumosDetalleList = invConsumosDetalleList;
    }

    public List<InvConsumosMotivoAnulacion> getInvConsumosMotivoAnulacionList() {
        return invConsumosMotivoAnulacionList;
    }

    public void setInvConsumosMotivoAnulacionList(List<InvConsumosMotivoAnulacion> invConsumosMotivoAnulacionList) {
        this.invConsumosMotivoAnulacionList = invConsumosMotivoAnulacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invConsumosPK != null ? invConsumosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvConsumos)) {
            return false;
        }
        InvConsumos other = (InvConsumos) object;
        if ((this.invConsumosPK == null && other.invConsumosPK != null) || (this.invConsumosPK != null && !this.invConsumosPK.equals(other.invConsumosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventario.entity.InvConsumos[ invConsumosPK=" + invConsumosPK + " ]";
    }
    
}
