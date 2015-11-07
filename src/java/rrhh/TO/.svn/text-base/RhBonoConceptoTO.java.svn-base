/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rrhh.TO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author misael
 */
public class RhBonoConceptoTO implements Serializable{
    private String empCodigo;
    private Integer bcSecuencia;
    private String bcDetalle;
    private BigDecimal bcValor;
    private Boolean bcValorFijo;
    private Boolean bcInactivo;
    private String usrInsertaBonoConcepto;
    private String usrFechaInsertaBonoConcepto;

    public RhBonoConceptoTO() {
    }

    public RhBonoConceptoTO(String empCodigo, Integer bcSecuencia, String bcDetalle, BigDecimal bcValor, Boolean bcValorFijo, Boolean bcInactivo, String usrInsertaBonoConcepto, String usrFechaInsertaBonoConcepto) {
        this.empCodigo = empCodigo;
        this.bcSecuencia = bcSecuencia;
        this.bcDetalle = bcDetalle;
        this.bcValor = bcValor;
        this.bcValorFijo = bcValorFijo;
        this.bcInactivo = bcInactivo;
        this.usrInsertaBonoConcepto = usrInsertaBonoConcepto;
        this.usrFechaInsertaBonoConcepto = usrFechaInsertaBonoConcepto;
    }

    public String getBcDetalle() {
        return bcDetalle;
    }

    public void setBcDetalle(String bcDetalle) {
        this.bcDetalle = bcDetalle;
    }

    public Boolean getBcInactivo() {
        return bcInactivo;
    }

    public void setBcInactivo(Boolean bcInactivo) {
        this.bcInactivo = bcInactivo;
    }

    public Integer getBcSecuencia() {
        return bcSecuencia;
    }

    public void setBcSecuencia(Integer bcSecuencia) {
        this.bcSecuencia = bcSecuencia;
    }

    public BigDecimal getBcValor() {
        return bcValor;
    }

    public void setBcValor(BigDecimal bcValor) {
        this.bcValor = bcValor;
    }

    public Boolean getBcValorFijo() {
        return bcValorFijo;
    }

    public void setBcValorFijo(Boolean bcValorFijo) {
        this.bcValorFijo = bcValorFijo;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    public String getUsrFechaInsertaBonoConcepto() {
        return usrFechaInsertaBonoConcepto;
    }

    public void setUsrFechaInsertaBonoConcepto(String usrFechaInsertaBonoConcepto) {
        this.usrFechaInsertaBonoConcepto = usrFechaInsertaBonoConcepto;
    }

    public String getUsrInsertaBonoConcepto() {
        return usrInsertaBonoConcepto;
    }

    public void setUsrInsertaBonoConcepto(String usrInsertaBonoConcepto) {
        this.usrInsertaBonoConcepto = usrInsertaBonoConcepto;
    }

    public String getInformacion(){
        return "Secuencia: "+bcSecuencia+
                "\nDetalle: "+bcDetalle+
                "\nValor: "+bcValor+
                "\nValor Fijo: "+bcValorFijo+
                "\nInactivo: "+bcInactivo+
                "\nUsuario Inserta: "+usrInsertaBonoConcepto+
                "\nFecha Inserta: "+usrFechaInsertaBonoConcepto;
    }

}
