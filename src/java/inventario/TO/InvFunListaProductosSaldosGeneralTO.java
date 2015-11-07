/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

import java.math.BigDecimal;

/**
 *
 * @author charly
 */
public class InvFunListaProductosSaldosGeneralTO implements java.io.Serializable{
 
    private String lpspCodigoPrincipal;
    private String lpspNombre;
    private String lpspBodega;
    private String lpspSaldo;
    private Boolean lpspIva;

    public InvFunListaProductosSaldosGeneralTO() {
    }
    
    public InvFunListaProductosSaldosGeneralTO(String lpspCodigoPrincipal, String lpspNombre, String lpspBodega, String lpspSaldo, Boolean lpspIva) {
        this.lpspCodigoPrincipal = lpspCodigoPrincipal;
        this.lpspNombre = lpspNombre;
        this.lpspBodega = lpspBodega;
        this.lpspSaldo = lpspSaldo;
        this.lpspIva = lpspIva;
    }
    
    public String getLpspBodega() {
        return lpspBodega;
    }

    public void setLpspBodega(String lpspBodega) {
        this.lpspBodega = lpspBodega;
    }

    public String getLpspCodigoPrincipal() {
        return lpspCodigoPrincipal;
    }

    public void setLpspCodigoPrincipal(String lpspCodigoPrincipal) {
        this.lpspCodigoPrincipal = lpspCodigoPrincipal;
    }

    public Boolean getLpspIva() {
        return lpspIva;
    }

    public void setLpspIva(Boolean lpspIva) {
        this.lpspIva = lpspIva;
    }

    public String getLpspNombre() {
        return lpspNombre;
    }

    public void setLpspNombre(String lpspNombre) {
        this.lpspNombre = lpspNombre;
    }

    public String getLpspSaldo() {
        return lpspSaldo;
    }

    public void setLpspSaldo(String lpspSaldo) {
        this.lpspSaldo = lpspSaldo;
    }

    

          /*
    @Override
    public String toString(){
        return this.empCodigo + " " + this.cliCodigo + " " + this.cliTipoId + " " +
                this.cliId + " " + this.cliNombre + " " + this.cliRazonSocial +
                " " + this.cliProvincia + " " + this.cliCiudad + " " + this.cliZona +
                " " + this.cliDireccion + " " + this.cliTelefono + " " + this.cliCelular +
                this.cliEmail + " " + this.cliPrecio + " " + this.cliDiasCredito +
                " " + this.cliCupoCredito + " " + this.cliObservaciones + " " +
                this.cliInactivo + " " + " " + this.cliSecuencia + " " +
                this.usrInsertaCliente + " " + this.usrFechaInsertaCliente;
    }*/
   

  

}
