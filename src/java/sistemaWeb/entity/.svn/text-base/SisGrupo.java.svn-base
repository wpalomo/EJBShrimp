/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaWeb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "sis_grupo", schema = "sistemaweb")
@NamedQueries({
    @NamedQuery(name = "SisGrupo.findAll", query = "SELECT s FROM SisGrupo s"),
    @NamedQuery(name = "SisGrupo.findByGruEmpresa", query = "SELECT s FROM SisGrupo s WHERE s.sisGrupoPK.gruEmpresa = :gruEmpresa"),
    @NamedQuery(name = "SisGrupo.findByGruCodigo", query = "SELECT s FROM SisGrupo s WHERE s.sisGrupoPK.gruCodigo = :gruCodigo"),
    @NamedQuery(name = "SisGrupo.findByGruNombre", query = "SELECT s FROM SisGrupo s WHERE s.gruNombre = :gruNombre"),
    @NamedQuery(name = "SisGrupo.findByGruCrear", query = "SELECT s FROM SisGrupo s WHERE s.gruCrear = :gruCrear"),
    @NamedQuery(name = "SisGrupo.findByGruModificar", query = "SELECT s FROM SisGrupo s WHERE s.gruModificar = :gruModificar"),
    @NamedQuery(name = "SisGrupo.findByGruEliminar", query = "SELECT s FROM SisGrupo s WHERE s.gruEliminar = :gruEliminar"),
    @NamedQuery(name = "SisGrupo.findByGruConfigurar", query = "SELECT s FROM SisGrupo s WHERE s.gruConfigurar = :gruConfigurar"),
    @NamedQuery(name = "SisGrupo.findByGruImprimir", query = "SELECT s FROM SisGrupo s WHERE s.gruImprimir = :gruImprimir"),
    @NamedQuery(name = "SisGrupo.findByGruExportar", query = "SELECT s FROM SisGrupo s WHERE s.gruExportar = :gruExportar"),
    @NamedQuery(name = "SisGrupo.findByGruDesmayorizarCompras", query = "SELECT s FROM SisGrupo s WHERE s.gruDesmayorizarCompras = :gruDesmayorizarCompras"),
    @NamedQuery(name = "SisGrupo.findByGruDesmayorizarVentas", query = "SELECT s FROM SisGrupo s WHERE s.gruDesmayorizarVentas = :gruDesmayorizarVentas"),
    @NamedQuery(name = "SisGrupo.findByGruDesmayorizarConsumos", query = "SELECT s FROM SisGrupo s WHERE s.gruDesmayorizarConsumos = :gruDesmayorizarConsumos"),
    @NamedQuery(name = "SisGrupo.findByGruDesmayorizarTransferencias", query = "SELECT s FROM SisGrupo s WHERE s.gruDesmayorizarTransferencias = :gruDesmayorizarTransferencias"),
    @NamedQuery(name = "SisGrupo.findByGruDesmayorizarContables", query = "SELECT s FROM SisGrupo s WHERE s.gruDesmayorizarContables = :gruDesmayorizarContables"),
    @NamedQuery(name = "SisGrupo.findByGruAnularCompras", query = "SELECT s FROM SisGrupo s WHERE s.gruAnularCompras = :gruAnularCompras"),
    @NamedQuery(name = "SisGrupo.findByGruAnularVentas", query = "SELECT s FROM SisGrupo s WHERE s.gruAnularVentas = :gruAnularVentas"),
    @NamedQuery(name = "SisGrupo.findByGruAnularConsumos", query = "SELECT s FROM SisGrupo s WHERE s.gruAnularConsumos = :gruAnularConsumos"),
    @NamedQuery(name = "SisGrupo.findByGruAnularTransferencias", query = "SELECT s FROM SisGrupo s WHERE s.gruAnularTransferencias = :gruAnularTransferencias"),
    @NamedQuery(name = "SisGrupo.findByGruAnularContables", query = "SELECT s FROM SisGrupo s WHERE s.gruAnularContables = :gruAnularContables"),
    @NamedQuery(name = "SisGrupo.findByUsrInsertaGrupo", query = "SELECT s FROM SisGrupo s WHERE s.usrInsertaGrupo = :usrInsertaGrupo"),
    @NamedQuery(name = "SisGrupo.findByUsrFechaInsertaGrupo", query = "SELECT s FROM SisGrupo s WHERE s.usrFechaInsertaGrupo = :usrFechaInsertaGrupo")})
public class SisGrupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SisGrupoPK sisGrupoPK;
    @Basic(optional = false)
    @Column(name = "gru_nombre")
    private String gruNombre;
    @Basic(optional = false)
    @Column(name = "gru_crear")
    private boolean gruCrear;
    @Basic(optional = false)
    @Column(name = "gru_modificar")
    private boolean gruModificar;
    @Basic(optional = false)
    @Column(name = "gru_eliminar")
    private boolean gruEliminar;
    @Basic(optional = false)
    @Column(name = "gru_configurar")
    private boolean gruConfigurar;
    @Basic(optional = false)
    @Column(name = "gru_imprimir")
    private boolean gruImprimir;
    @Basic(optional = false)
    @Column(name = "gru_exportar")
    private boolean gruExportar;
    @Basic(optional = false)
    @Column(name = "gru_desmayorizar_compras")
    private boolean gruDesmayorizarCompras;
    @Basic(optional = false)
    @Column(name = "gru_desmayorizar_ventas")
    private boolean gruDesmayorizarVentas;
    @Basic(optional = false)
    @Column(name = "gru_desmayorizar_consumos")
    private boolean gruDesmayorizarConsumos;
    @Basic(optional = false)
    @Column(name = "gru_desmayorizar_transferencias")
    private boolean gruDesmayorizarTransferencias;
    @Basic(optional = false)
    @Column(name = "gru_desmayorizar_contables")
    private boolean gruDesmayorizarContables;
    @Basic(optional = false)
    @Column(name = "gru_anular_compras")
    private boolean gruAnularCompras;
    @Basic(optional = false)
    @Column(name = "gru_anular_ventas")
    private boolean gruAnularVentas;
    @Basic(optional = false)
    @Column(name = "gru_anular_consumos")
    private boolean gruAnularConsumos;
    @Basic(optional = false)
    @Column(name = "gru_anular_transferencias")
    private boolean gruAnularTransferencias;
    @Basic(optional = false)
    @Column(name = "gru_anular_contables")
    private boolean gruAnularContables;
    @Column(name = "usr_inserta_grupo")
    private String usrInsertaGrupo;
    @Column(name = "usr_fecha_inserta_grupo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInsertaGrupo;
    @JoinColumn(name = "emp_codigo", referencedColumnName = "emp_codigo")
    @ManyToOne(optional = false)
    private SisEmpresa empCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sisGrupo")
    private List<SisUsuarioDetalle> sisUsuarioDetalleList;

    public SisGrupo() {
    }

    public SisGrupo(SisGrupoPK sisGrupoPK) {
        this.sisGrupoPK = sisGrupoPK;
    }

    public SisGrupo(SisGrupoPK sisGrupoPK, String gruNombre, boolean gruCrear, boolean gruModificar, boolean gruEliminar, boolean gruConfigurar, boolean gruImprimir, boolean gruExportar, boolean gruDesmayorizarCompras, boolean gruDesmayorizarVentas, boolean gruDesmayorizarConsumos, boolean gruDesmayorizarTransferencias, boolean gruDesmayorizarContables, boolean gruAnularCompras, boolean gruAnularVentas, boolean gruAnularConsumos, boolean gruAnularTransferencias, boolean gruAnularContables) {
        this.sisGrupoPK = sisGrupoPK;
        this.gruNombre = gruNombre;
        this.gruCrear = gruCrear;
        this.gruModificar = gruModificar;
        this.gruEliminar = gruEliminar;
        this.gruConfigurar = gruConfigurar;
        this.gruImprimir = gruImprimir;
        this.gruExportar = gruExportar;
        this.gruDesmayorizarCompras = gruDesmayorizarCompras;
        this.gruDesmayorizarVentas = gruDesmayorizarVentas;
        this.gruDesmayorizarConsumos = gruDesmayorizarConsumos;
        this.gruDesmayorizarTransferencias = gruDesmayorizarTransferencias;
        this.gruDesmayorizarContables = gruDesmayorizarContables;
        this.gruAnularCompras = gruAnularCompras;
        this.gruAnularVentas = gruAnularVentas;
        this.gruAnularConsumos = gruAnularConsumos;
        this.gruAnularTransferencias = gruAnularTransferencias;
        this.gruAnularContables = gruAnularContables;
    }

    public SisGrupo(String gruEmpresa, String gruCodigo) {
        this.sisGrupoPK = new SisGrupoPK(gruEmpresa, gruCodigo);
    }

    public SisGrupoPK getSisGrupoPK() {
        return sisGrupoPK;
    }

    public void setSisGrupoPK(SisGrupoPK sisGrupoPK) {
        this.sisGrupoPK = sisGrupoPK;
    }

    public String getGruNombre() {
        return gruNombre;
    }

    public void setGruNombre(String gruNombre) {
        this.gruNombre = gruNombre;
    }

    public boolean getGruCrear() {
        return gruCrear;
    }

    public void setGruCrear(boolean gruCrear) {
        this.gruCrear = gruCrear;
    }

    public boolean getGruModificar() {
        return gruModificar;
    }

    public void setGruModificar(boolean gruModificar) {
        this.gruModificar = gruModificar;
    }

    public boolean getGruEliminar() {
        return gruEliminar;
    }

    public void setGruEliminar(boolean gruEliminar) {
        this.gruEliminar = gruEliminar;
    }

    public boolean getGruConfigurar() {
        return gruConfigurar;
    }

    public void setGruConfigurar(boolean gruConfigurar) {
        this.gruConfigurar = gruConfigurar;
    }

    public boolean getGruImprimir() {
        return gruImprimir;
    }

    public void setGruImprimir(boolean gruImprimir) {
        this.gruImprimir = gruImprimir;
    }

    public boolean getGruExportar() {
        return gruExportar;
    }

    public void setGruExportar(boolean gruExportar) {
        this.gruExportar = gruExportar;
    }

    public boolean getGruDesmayorizarCompras() {
        return gruDesmayorizarCompras;
    }

    public void setGruDesmayorizarCompras(boolean gruDesmayorizarCompras) {
        this.gruDesmayorizarCompras = gruDesmayorizarCompras;
    }

    public boolean getGruDesmayorizarVentas() {
        return gruDesmayorizarVentas;
    }

    public void setGruDesmayorizarVentas(boolean gruDesmayorizarVentas) {
        this.gruDesmayorizarVentas = gruDesmayorizarVentas;
    }

    public boolean getGruDesmayorizarConsumos() {
        return gruDesmayorizarConsumos;
    }

    public void setGruDesmayorizarConsumos(boolean gruDesmayorizarConsumos) {
        this.gruDesmayorizarConsumos = gruDesmayorizarConsumos;
    }

    public boolean getGruDesmayorizarTransferencias() {
        return gruDesmayorizarTransferencias;
    }

    public void setGruDesmayorizarTransferencias(boolean gruDesmayorizarTransferencias) {
        this.gruDesmayorizarTransferencias = gruDesmayorizarTransferencias;
    }

    public boolean getGruDesmayorizarContables() {
        return gruDesmayorizarContables;
    }

    public void setGruDesmayorizarContables(boolean gruDesmayorizarContables) {
        this.gruDesmayorizarContables = gruDesmayorizarContables;
    }

    public boolean getGruAnularCompras() {
        return gruAnularCompras;
    }

    public void setGruAnularCompras(boolean gruAnularCompras) {
        this.gruAnularCompras = gruAnularCompras;
    }

    public boolean getGruAnularVentas() {
        return gruAnularVentas;
    }

    public void setGruAnularVentas(boolean gruAnularVentas) {
        this.gruAnularVentas = gruAnularVentas;
    }

    public boolean getGruAnularConsumos() {
        return gruAnularConsumos;
    }

    public void setGruAnularConsumos(boolean gruAnularConsumos) {
        this.gruAnularConsumos = gruAnularConsumos;
    }

    public boolean getGruAnularTransferencias() {
        return gruAnularTransferencias;
    }

    public void setGruAnularTransferencias(boolean gruAnularTransferencias) {
        this.gruAnularTransferencias = gruAnularTransferencias;
    }

    public boolean getGruAnularContables() {
        return gruAnularContables;
    }

    public void setGruAnularContables(boolean gruAnularContables) {
        this.gruAnularContables = gruAnularContables;
    }

    public String getUsrInsertaGrupo() {
        return usrInsertaGrupo;
    }

    public void setUsrInsertaGrupo(String usrInsertaGrupo) {
        this.usrInsertaGrupo = usrInsertaGrupo;
    }

    public Date getUsrFechaInsertaGrupo() {
        return usrFechaInsertaGrupo;
    }

    public void setUsrFechaInsertaGrupo(Date usrFechaInsertaGrupo) {
        this.usrFechaInsertaGrupo = usrFechaInsertaGrupo;
    }

    public SisEmpresa getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(SisEmpresa empCodigo) {
        this.empCodigo = empCodigo;
    }

    public List<SisUsuarioDetalle> getSisUsuarioDetalleList() {
        return sisUsuarioDetalleList;
    }

    public void setSisUsuarioDetalleList(List<SisUsuarioDetalle> sisUsuarioDetalleList) {
        this.sisUsuarioDetalleList = sisUsuarioDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sisGrupoPK != null ? sisGrupoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SisGrupo)) {
            return false;
        }
        SisGrupo other = (SisGrupo) object;
        if ((this.sisGrupoPK == null && other.sisGrupoPK != null) || (this.sisGrupoPK != null && !this.sisGrupoPK.equals(other.sisGrupoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemaWeb.entity.SisGrupo[ sisGrupoPK=" + sisGrupoPK + " ]";
    }
    
}
