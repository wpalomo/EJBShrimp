/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author developer1
 */
@Entity
@Table(name = "prd_sobrevivencia", schema = "produccion")
@NamedQueries({
    @NamedQuery(name = "PrdSobrevivencia.findAll", query = "SELECT p FROM PrdSobrevivencia p"),
    @NamedQuery(name = "PrdSobrevivencia.findBySobCodigo", query = "SELECT p FROM PrdSobrevivencia p WHERE p.sobCodigo = :sobCodigo"),
    @NamedQuery(name = "PrdSobrevivencia.findBySobDiasDesde", query = "SELECT p FROM PrdSobrevivencia p WHERE p.sobDiasDesde = :sobDiasDesde"),
    @NamedQuery(name = "PrdSobrevivencia.findBySobDiasHasta", query = "SELECT p FROM PrdSobrevivencia p WHERE p.sobDiasHasta = :sobDiasHasta"),
    @NamedQuery(name = "PrdSobrevivencia.findBySobSobrevivencia", query = "SELECT p FROM PrdSobrevivencia p WHERE p.sobSobrevivencia = :sobSobrevivencia"),
    @NamedQuery(name = "PrdSobrevivencia.findBySobAlimentacion", query = "SELECT p FROM PrdSobrevivencia p WHERE p.sobAlimentacion = :sobAlimentacion"),
    @NamedQuery(name = "PrdSobrevivencia.findByUsrEmpresa", query = "SELECT p FROM PrdSobrevivencia p WHERE p.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "PrdSobrevivencia.findByUsrCodigo", query = "SELECT p FROM PrdSobrevivencia p WHERE p.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "PrdSobrevivencia.findByUsrFechaInserta", query = "SELECT p FROM PrdSobrevivencia p WHERE p.usrFechaInserta = :usrFechaInserta")})
public class PrdSobrevivencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sob_codigo")
    private Integer sobCodigo;
    @Basic(optional = false)
    @Column(name = "sob_dias_desde")
    private int sobDiasDesde;
    @Basic(optional = false)
    @Column(name = "sob_dias_hasta")
    private int sobDiasHasta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "sob_sobrevivencia")
    private BigDecimal sobSobrevivencia;
    @Basic(optional = false)
    @Column(name = "sob_alimentacion")
    private BigDecimal sobAlimentacion;
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
        @JoinColumn(name = "sec_empresa", referencedColumnName = "sec_empresa"),
        @JoinColumn(name = "sec_codigo", referencedColumnName = "sec_codigo")})
    @ManyToOne(optional = false)
    private PrdSector prdSector;

    public PrdSobrevivencia() {
    }

    public PrdSobrevivencia(Integer sobCodigo) {
        this.sobCodigo = sobCodigo;
    }

    public PrdSobrevivencia(Integer sobCodigo, int sobDiasDesde, int sobDiasHasta, BigDecimal sobSobrevivencia, BigDecimal sobAlimentacion, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.sobCodigo = sobCodigo;
        this.sobDiasDesde = sobDiasDesde;
        this.sobDiasHasta = sobDiasHasta;
        this.sobSobrevivencia = sobSobrevivencia;
        this.sobAlimentacion = sobAlimentacion;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public Integer getSobCodigo() {
        return sobCodigo;
    }

    public void setSobCodigo(Integer sobCodigo) {
        this.sobCodigo = sobCodigo;
    }

    public int getSobDiasDesde() {
        return sobDiasDesde;
    }

    public void setSobDiasDesde(int sobDiasDesde) {
        this.sobDiasDesde = sobDiasDesde;
    }

    public int getSobDiasHasta() {
        return sobDiasHasta;
    }

    public void setSobDiasHasta(int sobDiasHasta) {
        this.sobDiasHasta = sobDiasHasta;
    }

    public BigDecimal getSobSobrevivencia() {
        return sobSobrevivencia;
    }

    public void setSobSobrevivencia(BigDecimal sobSobrevivencia) {
        this.sobSobrevivencia = sobSobrevivencia;
    }

    public BigDecimal getSobAlimentacion() {
        return sobAlimentacion;
    }

    public void setSobAlimentacion(BigDecimal sobAlimentacion) {
        this.sobAlimentacion = sobAlimentacion;
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

    public PrdSector getPrdSector() {
        return prdSector;
    }

    public void setPrdSector(PrdSector prdSector) {
        this.prdSector = prdSector;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sobCodigo != null ? sobCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrdSobrevivencia)) {
            return false;
        }
        PrdSobrevivencia other = (PrdSobrevivencia) object;
        if ((this.sobCodigo == null && other.sobCodigo != null) || (this.sobCodigo != null && !this.sobCodigo.equals(other.sobCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produccion.entity.PrdSobrevivencia[ sobCodigo=" + sobCodigo + " ]";
    }
    
}
