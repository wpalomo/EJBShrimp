/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.TO;

/**
 *
 * @author jack
 */
public class InvEstadoCCCVT implements java.io.Serializable{
    private Boolean estPendiente;
    private Boolean estAnulado;
    private Boolean estBloqueado;
    private Boolean estGenerado;

    public InvEstadoCCCVT() {
    }

    public InvEstadoCCCVT(Boolean estPendiente, Boolean estAnulado, Boolean estBloqueado, Boolean estGenerado) {
        this.estPendiente = estPendiente;
        this.estAnulado = estAnulado;
        this.estBloqueado = estBloqueado;
        this.estGenerado = estGenerado;
    }

    public Boolean getEstAnulado() {
        return estAnulado;
    }

    public void setEstAnulado(Boolean estAnulado) {
        this.estAnulado = estAnulado;
    }

    public Boolean getEstBloqueado() {
        return estBloqueado;
    }

    public void setEstBloqueado(Boolean estBloqueado) {
        this.estBloqueado = estBloqueado;
    }

    public Boolean getEstGenerado() {
        return estGenerado;
    }

    public void setEstGenerado(Boolean estGenerado) {
        this.estGenerado = estGenerado;
    }

    public Boolean getEstPendiente() {
        return estPendiente;
    }

    public void setEstPendiente(Boolean estPendiente) {
        this.estPendiente = estPendiente;
    }
    
    @Override
    public String toString(){
        return this.estPendiente + " " + this.estAnulado;
    }
}
