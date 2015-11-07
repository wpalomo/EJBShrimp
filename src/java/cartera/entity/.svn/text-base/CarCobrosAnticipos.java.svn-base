/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author developer2
 */
@Entity
@Table(name = "car_cobros_anticipos", schema = "cartera")
@NamedQueries({
    @NamedQuery(name = "CarCobrosAnticipos.findAll", query = "SELECT c FROM CarCobrosAnticipos c"),
    @NamedQuery(name = "CarCobrosAnticipos.findByAntEmpresa", query = "SELECT c FROM CarCobrosAnticipos c WHERE c.carCobrosAnticiposPK.antEmpresa = :antEmpresa"),
    @NamedQuery(name = "CarCobrosAnticipos.findByAntPeriodo", query = "SELECT c FROM CarCobrosAnticipos c WHERE c.carCobrosAnticiposPK.antPeriodo = :antPeriodo"),
    @NamedQuery(name = "CarCobrosAnticipos.findByAntTipo", query = "SELECT c FROM CarCobrosAnticipos c WHERE c.carCobrosAnticiposPK.antTipo = :antTipo"),
    @NamedQuery(name = "CarCobrosAnticipos.findByAntNumero", query = "SELECT c FROM CarCobrosAnticipos c WHERE c.carCobrosAnticiposPK.antNumero = :antNumero"),
    @NamedQuery(name = "CarCobrosAnticipos.findByAntValor", query = "SELECT c FROM CarCobrosAnticipos c WHERE c.antValor = :antValor"),
    @NamedQuery(name = "CarCobrosAnticipos.findByAntCobrado", query = "SELECT c FROM CarCobrosAnticipos c WHERE c.antCobrado = :antCobrado"),
    @NamedQuery(name = "CarCobrosAnticipos.findByAntReversado", query = "SELECT c FROM CarCobrosAnticipos c WHERE c.antReversado = :antReversado"),
    @NamedQuery(name = "CarCobrosAnticipos.findByCliEmpresa", query = "SELECT c FROM CarCobrosAnticipos c WHERE c.cliEmpresa = :cliEmpresa"),
    @NamedQuery(name = "CarCobrosAnticipos.findByCliCodigo", query = "SELECT c FROM CarCobrosAnticipos c WHERE c.cliCodigo = :cliCodigo"),
    @NamedQuery(name = "CarCobrosAnticipos.findBySecEmpresa", query = "SELECT c FROM CarCobrosAnticipos c WHERE c.secEmpresa = :secEmpresa"),
    @NamedQuery(name = "CarCobrosAnticipos.findBySecCodigo", query = "SELECT c FROM CarCobrosAnticipos c WHERE c.secCodigo = :secCodigo"),
    @NamedQuery(name = "CarCobrosAnticipos.findByUsrEmpresa", query = "SELECT c FROM CarCobrosAnticipos c WHERE c.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "CarCobrosAnticipos.findByUsrCodigo", query = "SELECT c FROM CarCobrosAnticipos c WHERE c.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "CarCobrosAnticipos.findByUsrFechaInserta", query = "SELECT c FROM CarCobrosAnticipos c WHERE c.usrFechaInserta = :usrFechaInserta")})
public class CarCobrosAnticipos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CarCobrosAnticiposPK carCobrosAnticiposPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "ant_valor")
    private BigDecimal antValor;
    @Basic(optional = false)
    @Column(name = "ant_cobrado")
    private boolean antCobrado;
    @Basic(optional = false)
    @Column(name = "ant_reversado")
    private boolean antReversado;
    @Basic(optional = false)
    @Column(name = "cli_empresa")
    private String cliEmpresa;
    @Basic(optional = false)
    @Column(name = "cli_codigo")
    private String cliCodigo;
    @Basic(optional = false)
    @Column(name = "sec_empresa")
    private String secEmpresa;
    @Basic(optional = false)
    @Column(name = "sec_codigo")
    private String secCodigo;
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
    @JoinColumn(name = "fp_secuencial", referencedColumnName = "fp_secuencial")
    @ManyToOne(optional = false)
    private CarCobrosForma fpSecuencial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carCobrosAnticipos")
    private List<CarCobrosDetalleAnticipos> carCobrosDetalleAnticiposList;

    public CarCobrosAnticipos() {
    }

    public CarCobrosAnticipos(CarCobrosAnticiposPK carCobrosAnticiposPK) {
        this.carCobrosAnticiposPK = carCobrosAnticiposPK;
    }

    public CarCobrosAnticipos(CarCobrosAnticiposPK carCobrosAnticiposPK, BigDecimal antValor, boolean antCobrado, boolean antReversado, String cliEmpresa, String cliCodigo, String secEmpresa, String secCodigo, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.carCobrosAnticiposPK = carCobrosAnticiposPK;
        this.antValor = antValor;
        this.antCobrado = antCobrado;
        this.antReversado = antReversado;
        this.cliEmpresa = cliEmpresa;
        this.cliCodigo = cliCodigo;
        this.secEmpresa = secEmpresa;
        this.secCodigo = secCodigo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public CarCobrosAnticipos(String antEmpresa, String antPeriodo, String antTipo, String antNumero) {
        this.carCobrosAnticiposPK = new CarCobrosAnticiposPK(antEmpresa, antPeriodo, antTipo, antNumero);
    }

    public CarCobrosAnticiposPK getCarCobrosAnticiposPK() {
        return carCobrosAnticiposPK;
    }

    public void setCarCobrosAnticiposPK(CarCobrosAnticiposPK carCobrosAnticiposPK) {
        this.carCobrosAnticiposPK = carCobrosAnticiposPK;
    }

    public BigDecimal getAntValor() {
        return antValor;
    }

    public void setAntValor(BigDecimal antValor) {
        this.antValor = antValor;
    }

    public boolean getAntCobrado() {
        return antCobrado;
    }

    public void setAntCobrado(boolean antCobrado) {
        this.antCobrado = antCobrado;
    }

    public boolean getAntReversado() {
        return antReversado;
    }

    public void setAntReversado(boolean antReversado) {
        this.antReversado = antReversado;
    }

    public String getCliEmpresa() {
        return cliEmpresa;
    }

    public void setCliEmpresa(String cliEmpresa) {
        this.cliEmpresa = cliEmpresa;
    }

    public String getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(String cliCodigo) {
        this.cliCodigo = cliCodigo;
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

    public CarCobrosForma getFpSecuencial() {
        return fpSecuencial;
    }

    public void setFpSecuencial(CarCobrosForma fpSecuencial) {
        this.fpSecuencial = fpSecuencial;
    }

    public List<CarCobrosDetalleAnticipos> getCarCobrosDetalleAnticiposList() {
        return carCobrosDetalleAnticiposList;
    }

    public void setCarCobrosDetalleAnticiposList(List<CarCobrosDetalleAnticipos> carCobrosDetalleAnticiposList) {
        this.carCobrosDetalleAnticiposList = carCobrosDetalleAnticiposList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carCobrosAnticiposPK != null ? carCobrosAnticiposPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarCobrosAnticipos)) {
            return false;
        }
        CarCobrosAnticipos other = (CarCobrosAnticipos) object;
        if ((this.carCobrosAnticiposPK == null && other.carCobrosAnticiposPK != null) || (this.carCobrosAnticiposPK != null && !this.carCobrosAnticiposPK.equals(other.carCobrosAnticiposPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cartera.entity.CarCobrosAnticipos[ carCobrosAnticiposPK=" + carCobrosAnticiposPK + " ]";
    }
    
}
