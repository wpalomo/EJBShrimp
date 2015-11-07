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
@Table(name = "sis_usuario_detalle", schema = "sistemaweb")
@NamedQueries({
    @NamedQuery(name = "SisUsuarioDetalle.findAll", query = "SELECT s FROM SisUsuarioDetalle s"),
    @NamedQuery(name = "SisUsuarioDetalle.findByDetEmpresa", query = "SELECT s FROM SisUsuarioDetalle s WHERE s.sisUsuarioDetallePK.detEmpresa = :detEmpresa"),
    @NamedQuery(name = "SisUsuarioDetalle.findByDetUsuario", query = "SELECT s FROM SisUsuarioDetalle s WHERE s.sisUsuarioDetallePK.detUsuario = :detUsuario"),
    @NamedQuery(name = "SisUsuarioDetalle.findByDetEquipo", query = "SELECT s FROM SisUsuarioDetalle s WHERE s.detEquipo = :detEquipo"),
    @NamedQuery(name = "SisUsuarioDetalle.findByDetActivo", query = "SELECT s FROM SisUsuarioDetalle s WHERE s.detActivo = :detActivo"),
    @NamedQuery(name = "SisUsuarioDetalle.findByUsrFechaInsertaUsuario", query = "SELECT s FROM SisUsuarioDetalle s WHERE s.usrFechaInsertaUsuario = :usrFechaInsertaUsuario")})
public class SisUsuarioDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SisUsuarioDetallePK sisUsuarioDetallePK;
    @Basic(optional = false)
    @Column(name = "det_equipo")
    private String detEquipo;
    @Basic(optional = false)
    @Column(name = "det_activo")
    private boolean detActivo;
    @Basic(optional = false)
    @Column(name = "usr_fecha_inserta_usuario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrFechaInsertaUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sisUsuarioDetalle")
    private List<SisSuceso> sisSucesoList;
    @JoinColumn(name = "usr_codigo", referencedColumnName = "usr_codigo")
    @ManyToOne(optional = false)
    private SisUsuario usrCodigo;
    @JoinColumns({
        @JoinColumn(name = "gru_empresa", referencedColumnName = "gru_empresa"),
        @JoinColumn(name = "gru_codigo", referencedColumnName = "gru_codigo")})
    @ManyToOne(optional = false)
    private SisGrupo sisGrupo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sisUsuarioDetalle")
    private List<SisError> sisErrorList;

    public SisUsuarioDetalle() {
    }

    public SisUsuarioDetalle(SisUsuarioDetallePK sisUsuarioDetallePK) {
        this.sisUsuarioDetallePK = sisUsuarioDetallePK;
    }

    public SisUsuarioDetalle(SisUsuarioDetallePK sisUsuarioDetallePK, String detEquipo, boolean detActivo, Date usrFechaInsertaUsuario) {
        this.sisUsuarioDetallePK = sisUsuarioDetallePK;
        this.detEquipo = detEquipo;
        this.detActivo = detActivo;
        this.usrFechaInsertaUsuario = usrFechaInsertaUsuario;
    }

    public SisUsuarioDetalle(String detEmpresa, String detUsuario) {
        this.sisUsuarioDetallePK = new SisUsuarioDetallePK(detEmpresa, detUsuario);
    }

    public SisUsuarioDetallePK getSisUsuarioDetallePK() {
        return sisUsuarioDetallePK;
    }

    public void setSisUsuarioDetallePK(SisUsuarioDetallePK sisUsuarioDetallePK) {
        this.sisUsuarioDetallePK = sisUsuarioDetallePK;
    }

    public String getDetEquipo() {
        return detEquipo;
    }

    public void setDetEquipo(String detEquipo) {
        this.detEquipo = detEquipo;
    }

    public boolean getDetActivo() {
        return detActivo;
    }

    public void setDetActivo(boolean detActivo) {
        this.detActivo = detActivo;
    }

    public Date getUsrFechaInsertaUsuario() {
        return usrFechaInsertaUsuario;
    }

    public void setUsrFechaInsertaUsuario(Date usrFechaInsertaUsuario) {
        this.usrFechaInsertaUsuario = usrFechaInsertaUsuario;
    }

    public List<SisSuceso> getSisSucesoList() {
        return sisSucesoList;
    }

    public void setSisSucesoList(List<SisSuceso> sisSucesoList) {
        this.sisSucesoList = sisSucesoList;
    }

    public SisUsuario getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(SisUsuario usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public SisGrupo getSisGrupo() {
        return sisGrupo;
    }

    public void setSisGrupo(SisGrupo sisGrupo) {
        this.sisGrupo = sisGrupo;
    }

    public List<SisError> getSisErrorList() {
        return sisErrorList;
    }

    public void setSisErrorList(List<SisError> sisErrorList) {
        this.sisErrorList = sisErrorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sisUsuarioDetallePK != null ? sisUsuarioDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SisUsuarioDetalle)) {
            return false;
        }
        SisUsuarioDetalle other = (SisUsuarioDetalle) object;
        if ((this.sisUsuarioDetallePK == null && other.sisUsuarioDetallePK != null) || (this.sisUsuarioDetallePK != null && !this.sisUsuarioDetallePK.equals(other.sisUsuarioDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemaWeb.entity.SisUsuarioDetalle[ sisUsuarioDetallePK=" + sisUsuarioDetallePK + " ]";
    }
    
}
