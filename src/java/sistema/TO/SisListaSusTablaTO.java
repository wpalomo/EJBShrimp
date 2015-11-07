/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.TO;

import java.io.Serializable;

/**
 *
 * @author charly
 */
public class SisListaSusTablaTO implements Serializable {
    
    private String susTabla;

    public SisListaSusTablaTO() {
    }

    public SisListaSusTablaTO(String susTabla) {
        this.susTabla = susTabla;
    }
    
    public String getSusTabla() {
        return susTabla;
    }

    public void setSusTabla(String susTabla) {
        this.susTabla = susTabla;
    }
    
    @Override
    public String toString(){
        return (getSusTabla());
    }

    
    
}
