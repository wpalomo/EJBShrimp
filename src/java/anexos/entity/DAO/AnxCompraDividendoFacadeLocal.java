/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity.DAO;

import anexos.entity.AnxCompraDividendo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fconza
 */
@Local
public interface AnxCompraDividendoFacadeLocal {

    void create(AnxCompraDividendo anxCompraDividendo);

    void edit(AnxCompraDividendo anxCompraDividendo);

    void remove(AnxCompraDividendo anxCompraDividendo);

    AnxCompraDividendo find(Object id);

    List<AnxCompraDividendo> findAll();

    List<AnxCompraDividendo> findRange(int[] range);

    int count();
    
}
