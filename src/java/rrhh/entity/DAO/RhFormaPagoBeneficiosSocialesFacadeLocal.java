/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import rrhh.entity.RhFormaPagoBeneficiosSociales;

/**
 *
 * @author fconza
 */
@Local
public interface RhFormaPagoBeneficiosSocialesFacadeLocal {

    void create(RhFormaPagoBeneficiosSociales rhFormaPagoBeneficiosSociales);

    void edit(RhFormaPagoBeneficiosSociales rhFormaPagoBeneficiosSociales);

    void remove(RhFormaPagoBeneficiosSociales rhFormaPagoBeneficiosSociales);

    RhFormaPagoBeneficiosSociales find(Object id);

    List<RhFormaPagoBeneficiosSociales> findAll();

    List<RhFormaPagoBeneficiosSociales> findRange(int[] range);

    int count();
    
}
