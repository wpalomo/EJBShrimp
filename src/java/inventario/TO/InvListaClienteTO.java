/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

/**
 *
 * @author jack
 */
public class InvListaClienteTO implements java.io.Serializable {
    private String codCliente;
    private String idCliente;
    private String idNombreApellido;
    private String direccion;

    public InvListaClienteTO() {
    }

    public InvListaClienteTO(String codCliente, String idCliente, String idNombreApellido, String direccion) {
        this.codCliente = codCliente;
        this.idCliente = idCliente;
        this.idNombreApellido = idNombreApellido;
        this.direccion = direccion;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdNombreApellido() {
        return idNombreApellido;
    }

    public void setIdNombreApellido(String idNombreApellido) {
        this.idNombreApellido = idNombreApellido;
    }
}
