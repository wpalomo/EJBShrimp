/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.TO;

import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class ConFunContablesVerificacionesTO implements java.io.Serializable {
    private String vcPeriodo;
    private String vcTipo;
    private String vcNumero;
    private String vcFecha;
    private Boolean vcPendiente;
    private Boolean vcBloqueado;
    private Boolean vcAnulado;
    private java.math.BigDecimal vcDebitos;
    private java.math.BigDecimal vcCreditos;
    private String vcObservaciones;

    public ConFunContablesVerificacionesTO() {
    }

    public ConFunContablesVerificacionesTO(String vcPeriodo, String vcTipo, String vcNumero, String vcFecha, Boolean vcPendiente, Boolean vcBloqueado, Boolean vcAnulado, BigDecimal vcDebitos, BigDecimal vcCreditos, String vcObservaciones) {
        this.vcPeriodo = vcPeriodo;
        this.vcTipo = vcTipo;
        this.vcNumero = vcNumero;
        this.vcFecha = vcFecha;
        this.vcPendiente = vcPendiente;
        this.vcBloqueado = vcBloqueado;
        this.vcAnulado = vcAnulado;
        this.vcDebitos = vcDebitos;
        this.vcCreditos = vcCreditos;
        this.vcObservaciones = vcObservaciones;
    }

    public Boolean getVcAnulado() {
        return vcAnulado;
    }

    public void setVcAnulado(Boolean vcAnulado) {
        this.vcAnulado = vcAnulado;
    }

    public Boolean getVcBloqueado() {
        return vcBloqueado;
    }

    public void setVcBloqueado(Boolean vcBloqueado) {
        this.vcBloqueado = vcBloqueado;
    }

    public BigDecimal getVcCreditos() {
        return vcCreditos;
    }

    public void setVcCreditos(BigDecimal vcCreditos) {
        this.vcCreditos = vcCreditos;
    }

    public BigDecimal getVcDebitos() {
        return vcDebitos;
    }

    public void setVcDebitos(BigDecimal vcDebitos) {
        this.vcDebitos = vcDebitos;
    }

    public String getVcFecha() {
        return vcFecha;
    }

    public void setVcFecha(String vcFecha) {
        this.vcFecha = vcFecha;
    }

    public String getVcNumero() {
        return vcNumero;
    }

    public void setVcNumero(String vcNumero) {
        this.vcNumero = vcNumero;
    }

    public String getVcObservaciones() {
        return vcObservaciones;
    }

    public void setVcObservaciones(String vcObservaciones) {
        this.vcObservaciones = vcObservaciones;
    }

    public Boolean getVcPendiente() {
        return vcPendiente;
    }

    public void setVcPendiente(Boolean vcPendiente) {
        this.vcPendiente = vcPendiente;
    }

    public String getVcPeriodo() {
        return vcPeriodo;
    }

    public void setVcPeriodo(String vcPeriodo) {
        this.vcPeriodo = vcPeriodo;
    }

    public String getVcTipo() {
        return vcTipo;
    }

    public void setVcTipo(String vcTipo) {
        this.vcTipo = vcTipo;
    }
}
