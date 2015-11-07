/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.entity.DAO;

import contabilidad.entity.ConContableMotivoAnulacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fconza
 */
@Local
public interface ConContableMotivoAnulacionFacadeLocal {

    void create(ConContableMotivoAnulacion conContableMotivoAnulacion);

    void edit(ConContableMotivoAnulacion conContableMotivoAnulacion);

    void remove(ConContableMotivoAnulacion conContableMotivoAnulacion);

    ConContableMotivoAnulacion find(Object id);

    List<ConContableMotivoAnulacion> findAll();

    List<ConContableMotivoAnulacion> findRange(int[] range);

    int count();
    
}
