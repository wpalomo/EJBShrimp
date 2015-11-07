/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validaciones;

/**
 *
 * @author jack
 */
public class ConvertirListaObject {
//    public static Object[] convertirObject(Object[] objeto){
//        Object[] array = (Object[]) objeto;
//        for (int i = 0; i < array.length; i++){
//            for(int j = 0; j < array[i].toString().length(); j ++){
//                if (array[i].toString().trim().charAt(j) == '[')
//                    array[i] = array[i].toString().trim().substring(1);
//                if (array[i].toString().trim().charAt(j) == ']')
//                    array[i] = array[i].toString().trim().substring(0, array[i].toString().trim().length() - 1);
//            }
//        }
//        return array;
//    }
    
    public static Object[] convertirListToArray(java.util.List lista, int elementoDeLista){
        try{
            //GLASSFISH 3
            Object obj = lista.get(elementoDeLista);
            Object[] array = (Object[]) obj;
            return array;
        } catch(ClassCastException cce1) {
            try{
                //GLASSFISH 2
                Object obj = lista.get(elementoDeLista);
                Object[] array = ((java.util.List) obj).toArray();
                return array;
            } catch(ClassCastException cce2) {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException aiobe){
            return null;
        } catch (NullPointerException npe){
            return null;
        }
    }
}
