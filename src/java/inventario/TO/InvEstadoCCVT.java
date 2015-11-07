/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.TO;

/**
 *
 * @author jack
 */
public class InvEstadoCCVT implements java.io.Serializable{
    private Boolean estPendiente;
    private Boolean estAnulado;

    public InvEstadoCCVT() {
    }

    public InvEstadoCCVT(Boolean estPendiente, Boolean estAnulado) {
        this.estPendiente = estPendiente;
        this.estAnulado = estAnulado;
    }

    public Boolean getEstAnulado() {
        return estAnulado;
    }

    public void setEstAnulado(Boolean estAnulado) {
        this.estAnulado = estAnulado;
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
