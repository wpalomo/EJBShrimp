/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity.DAO;

import anexos.entity.AnxTipoidentificacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fconza
 */
@Local
public interface AnxTipoidentificacionFacadeLocal {

    void create(AnxTipoidentificacion anxTipoidentificacion);

    void edit(AnxTipoidentificacion anxTipoidentificacion);

    void remove(AnxTipoidentificacion anxTipoidentificacion);

    AnxTipoidentificacion find(Object id);

    List<AnxTipoidentificacion> findAll();

    List<AnxTipoidentificacion> findRange(int[] range);

    int count();
    
}
