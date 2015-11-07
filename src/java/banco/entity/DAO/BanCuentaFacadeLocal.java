/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.entity.DAO;

import banco.entity.BanCuenta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author developer2
 */
@Local
public interface BanCuentaFacadeLocal {

    void create(BanCuenta banCuenta);

    void edit(BanCuenta banCuenta);

    void remove(BanCuenta banCuenta);

    BanCuenta find(Object id);

    List<BanCuenta> findAll();

    List<BanCuenta> findRange(int[] range);

    int count();
    
}
