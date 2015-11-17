/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.entity.DAO;

import banco.entity.BanBanco;
import banco.entity.BanChequeNumeracion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer2
 */
@Local
public interface BanChequeNumeracionFacadeLocal {

    void create(BanChequeNumeracion banBanco);

    void edit(BanChequeNumeracion banBanco);

    void remove(BanChequeNumeracion banBanco);

    BanChequeNumeracion find(Object id);

    List<BanChequeNumeracion> findAll();

    List<BanChequeNumeracion> findRange(int[] range);

    int count();
}
