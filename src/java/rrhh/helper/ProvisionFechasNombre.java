/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.helper;



/**
 *
 * @author jack
 */
public class ProvisionFechasNombre {
    private String cedula;
    private String nombre;

    public ProvisionFechasNombre() {
    }

    public ProvisionFechasNombre(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;      
    }

   

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
