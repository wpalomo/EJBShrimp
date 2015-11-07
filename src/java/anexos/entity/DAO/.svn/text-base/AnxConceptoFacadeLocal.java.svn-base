/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anexos.entity.DAO;

import anexos.entity.AnxConcepto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fconza
 */
@Local
public interface AnxConceptoFacadeLocal {

    void create(AnxConcepto anxConcepto);

    void edit(AnxConcepto anxConcepto);

    void remove(AnxConcepto anxConcepto);

    AnxConcepto find(Object id);

    List<AnxConcepto> findAll();

    List<AnxConcepto> findRange(int[] range);

    int count();
    
}
