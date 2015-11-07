/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaWeb.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import sistemaWeb.entity.SisPcs;

/**
 *
 * @author developer1
 */
@Local
public interface SisPcsFacadeLocal {

    void create(SisPcs sisPcs);

    void edit(SisPcs sisPcs);

    void remove(SisPcs sisPcs);

    SisPcs find(Object id);

    List<SisPcs> findAll();

    List<SisPcs> findRange(int[] range);

    int count();
    
}
