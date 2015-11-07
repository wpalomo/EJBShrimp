/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity.DAO;

import anexos.entity.AnxTipocomprobante;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fconza
 */
@Local
public interface AnxTipocomprobanteFacadeLocal {

    void create(AnxTipocomprobante anxTipocomprobante);

    void edit(AnxTipocomprobante anxTipocomprobante);

    void remove(AnxTipocomprobante anxTipocomprobante);

    AnxTipocomprobante find(Object id);

    List<AnxTipocomprobante> findAll();

    List<AnxTipocomprobante> findRange(int[] range);

    int count();
    
}
