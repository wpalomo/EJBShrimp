/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import rrhh.entity.RhBonoConcepto;

/**
 *
 * @author fconza
 */
@Local
public interface RhBonoConceptoFacadeLocal {

    void create(RhBonoConcepto rhBonoConcepto);

    void edit(RhBonoConcepto rhBonoConcepto);

    void remove(RhBonoConcepto rhBonoConcepto);

    RhBonoConcepto find(Object id);

    List<RhBonoConcepto> findAll();

    List<RhBonoConcepto> findRange(int[] range);

    int count();
    
}
