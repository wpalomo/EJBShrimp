/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import rrhh.entity.RhFormaPago;

/**
 *
 * @author fconza
 */
@Local
public interface RhFormaPagoFacadeLocal {

    void create(RhFormaPago rhFormaPago);

    void edit(RhFormaPago rhFormaPago);

    void remove(RhFormaPago rhFormaPago);

    RhFormaPago find(Object id);

    List<RhFormaPago> findAll();

    List<RhFormaPago> findRange(int[] range);

    int count();
    
}
