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
public class RhListaDetalleBonosTO implements Serializable{
    private String dbCategoria;
    private String dbFecha;
    private String dbId;
    private String dbNombres;
    private String dbConcepto;
    private String dbSector;
    private String dbPiscina;
    private BigDecimal dbValor;
    private Boolean dbDeducible;
    private Boolean dbReverso;
    private String dbContable;
    private Boolean dbAnulado;
    private String dbObservaciones;
 
    public RhListaDetalleBonosTO() {
    }

    public RhListaDetalleBonosTO(String dbCategoria, String dbFecha, String dbId, String dbNombres, String dbConcepto, String dbSector, String dbPiscina, BigDecimal dbValor, Boolean dbDeducible, Boolean dbReverso, String dbContable, Boolean dbAnulado, String dbObservaciones) {
        this.dbCategoria = dbCategoria;
        this.dbFecha = dbFecha;
        this.dbId = dbId;
        this.dbNombres = dbNombres;
        this.dbConcepto = dbConcepto;
        this.dbSector = dbSector;
        this.dbPiscina = dbPiscina;
        this.dbValor = dbValor;
        this.dbDeducible = dbDeducible;
        this.dbReverso = dbReverso;
        this.dbContable = dbContable;
        this.dbAnulado = dbAnulado;
        this.dbObservaciones = dbObservaciones;
    }

   

   

    public Boolean getDbAnulado() {
        return dbAnulado;
    }

    public void setDbAnulado(Boolean dbAnulado) {
        this.dbAnulado = dbAnulado;
    }

    public String getDbCategoria() {
        return dbCategoria;
    }

    public void setDbCategoria(String dbCategoria) {
        this.dbCategoria = dbCategoria;
    }

    public String getDbConcepto() {
        return dbConcepto;
    }

    public void setDbConcepto(String dbConcepto) {
        this.dbConcepto = dbConcepto;
    }

    public String getDbContable() {
        return dbContable;
    }

    public void setDbContable(String dbContable) {
        this.dbContable = dbContable;
    }

    public String getDbFecha() {
        return dbFecha;
    }

    public void setDbFecha(String dbFecha) {
        this.dbFecha = dbFecha;
    }

    public String getDbId() {
        return dbId;
    }

    public void setDbId(String dbId) {
        this.dbId = dbId;
    }

    public String getDbNombres() {
        return dbNombres;
    }

    public void setDbNombres(String dbNombres) {
        this.dbNombres = dbNombres;
    }

    public String getDbObservaciones() {
        return dbObservaciones;
    }

    public void setDbObservaciones(String dbObservaciones) {
        this.dbObservaciones = dbObservaciones;
    }

    public String getDbPiscina() {
        return dbPiscina;
    }

    public void setDbPiscina(String dbPiscina) {
        this.dbPiscina = dbPiscina;
    }

    public Boolean getDbReverso() {
        return dbReverso;
    }

    public void setDbReverso(Boolean dbReverso) {
        this.dbReverso = dbReverso;
    }

    public String getDbSector() {
        return dbSector;
    }

    public void setDbSector(String dbSector) {
        this.dbSector = dbSector;
    }

    public BigDecimal getDbValor() {
        return dbValor;
    }

    public void setDbValor(BigDecimal dbValor) {
        this.dbValor = dbValor;
    }

    public Boolean getDbDeducible() {
        return dbDeducible;
    }

    public void setDbDeducible(Boolean dbDeducible) {
        this.dbDeducible = dbDeducible;
    }

   
    
}
