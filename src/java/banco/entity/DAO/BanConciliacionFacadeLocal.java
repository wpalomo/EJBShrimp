/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.entity.DAO;

import banco.entity.BanConciliacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer2
 */
@Local
public interface BanConciliacionFacadeLocal {

    void create(BanConciliacion banConciliacion);

    void edit(BanConciliacion banConciliacion);

    void remove(BanConciliacion banConciliacion);

    BanConciliacion find(Object id);

    List<BanConciliacion> findAll();

    List<BanConciliacion> findRange(int[] range);

    int count();
    
}
