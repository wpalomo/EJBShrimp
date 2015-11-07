/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package produccion.entity.DAO;

import java.util.List;
import javax.ejb.Local;
import produccion.entity.PrdSobrevivencia;

/**
 *
 * @author developer1
 */
@Local
public interface PrdSobrevivenciaFacadeLocal {

    void create(PrdSobrevivencia prdSobrevivencia);

    void edit(PrdSobrevivencia prdSobrevivencia);

    void remove(PrdSobrevivencia prdSobrevivencia);

    PrdSobrevivencia find(Object id);

    List<PrdSobrevivencia> findAll();

    List<PrdSobrevivencia> findRange(int[] range);

    int count();
    
}
