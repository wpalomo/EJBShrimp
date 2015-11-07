/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartera.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author developer2
 */
@Entity
@Table(name = "car_cobros", schema = "cartera")
@NamedQueries({
    @NamedQuery(name = "CarCobros.findAll", query = "SELECT c FROM CarCobros c"),
    @NamedQuery(name = "CarCobros.findByCobEmpresa", query = "SELECT c FROM CarCobros c WHERE c.carCobrosPK.cobEmpresa = :cobEmpresa"),
    @NamedQuery(name = "CarCobros.findByCobPeriodo", query = "SELECT c FROM CarCobros c WHERE c.carCobrosPK.cobPeriodo = :cobPeriodo"),
    @NamedQuery(name = "CarCobros.findByCobTipo", query = "SELECT c FROM CarCobros c WHERE c.carCobrosPK.cobTipo = :cobTipo"),
    @NamedQuery(name = "CarCobros.findByCobNumero", query = "SELECT c FROM CarCobros c WHERE c.carCobrosPK.cobNumero = :cobNumero"),
    @NamedQuery(name = "CarCobros.findByCobReversado", query = "SELECT c FROM CarCobros c WHERE c.cobReversado = :cobReversado"),
    @NamedQuery(name = "CarCobros.findByCliEmpresa", query = "SELECT c FROM CarCobros c WHERE c.cliEmpresa = :cliEmpresa"),
    @NamedQuery(name = "CarCobros.findByCliCodigo", query = "SELECT c FROM CarCobros c WHERE c.cliCodigo = :cliCodigo"),
    @NamedQuery(name = "CarCobros.findByUsrEmpresa", query = "SELECT c FROM CarCobros c WHERE c.usrEmpresa = :usrEmpresa"),
    @NamedQuery(name = "CarCobros.findByUsrCodigo", query = "SELECT c FROM CarCobros c WHERE c.usrCodigo = :usrCodigo"),
    @NamedQuery(name = "CarCobros.findByUsrFechaInserta", query = "SELECT c FROM CarCobros c WHERE c.usrFechaInserta = :usrFechaInserta")})
public class CarCobros implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CarCobrosPK carCobrosPK;
    @Column(name = "cob_reversado")
    private Boolean cobReversado;
    @Basic(optional = false)
    @Column(name = "cli_empresa")
    private String cliEmpresa;
    @Basic(optional = false)
    @Column(name = "cli_codigo")
    private String cliCodigo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carCobros")
    private List<CarCobrosDetalleForma> carCobrosDetalleFormaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carCobros")
    private List<CarCobrosDetalleVentas> carCobrosDetalleVentasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carCobros")
    private List<CarCobrosDetalleAnticipos> carCobrosDetalleAnticiposList;

    public CarCobros() {
    }

    public CarCobros(CarCobrosPK carCobrosPK) {
        this.carCobrosPK = carCobrosPK;
    }

    public CarCobros(CarCobrosPK carCobrosPK, String cliEmpresa, String cliCodigo, String usrEmpresa, String usrCodigo, Date usrFechaInserta) {
        this.carCobrosPK = carCobrosPK;
        this.cliEmpresa = cliEmpresa;
        this.cliCodigo = cliCodigo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public CarCobros(String cobEmpresa, String cobPeriodo, String cobTipo, String cobNumero) {
        this.carCobrosPK = new CarCobrosPK(cobEmpresa, cobPeriodo, cobTipo, cobNumero);
    }

    public CarCobrosPK getCarCobrosPK() {
        return carCobrosPK;
    }

    public void setCarCobrosPK(CarCobrosPK carCobrosPK) {
        this.carCobrosPK = carCobrosPK;
    }

    public Boolean getCobReversado() {
        return cobReversado;
    }

    public void setCobReversado(Boolean cobReversado) {
        this.cobReversado = cobReversado;
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

    public List<CarCobrosDetalleForma> getCarCobrosDetalleFormaList() {
        return carCobrosDetalleFormaList;
    }

    public void setCarCobrosDetalleFormaList(List<CarCobrosDetalleForma> carCobrosDetalleFormaList) {
        this.carCobrosDetalleFormaList = carCobrosDetalleFormaList;
    }

    public List<CarCobrosDetalleVentas> getCarCobrosDetalleVentasList() {
        return carCobrosDetalleVentasList;
    }

    public void setCarCobrosDetalleVentasList(List<CarCobrosDetalleVentas> carCobrosDetalleVentasList) {
        this.carCobrosDetalleVentasList = carCobrosDetalleVentasList;
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
        hash += (carCobrosPK != null ? carCobrosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarCobros)) {
            return false;
        }
        CarCobros other = (CarCobros) object;
        if ((this.carCobrosPK == null && other.carCobrosPK != null) || (this.carCobrosPK != null && !this.carCobrosPK.equals(other.carCobrosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cartera.entity.CarCobros[ carCobrosPK=" + carCobrosPK + " ]";
    }
    
}
