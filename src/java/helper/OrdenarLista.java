/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 *
 * @author jack
 */
public class OrdenarLista {
    public static void ordena(java.util.List lista, final String propiedad){
        java.util.Collections.sort(lista, new java.util.Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                Class clase = o1.getClass();
                String getter = "get" + Character.toUpperCase(propiedad.charAt(0)) + propiedad.substring(1);
                try{
                    java.lang.reflect.Method getPropiedad = clase.getMethod(getter);
                    Object propiedad1 = getPropiedad.invoke(o1);
                    Object propiedad2 = getPropiedad.invoke(o2);
                    if(propiedad1 instanceof Comparable && propiedad2 instanceof Comparable){
                        Comparable comp1 = (Comparable)propiedad1;
                        Comparable comp2 = (Comparable)propiedad2;
                        return comp1.compareTo(comp2);
                    } else {
                        if(propiedad1.equals(propiedad2)){
                            return 0;
                        } else {
                            return 1;
                        }
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
                return 0;
            }
        });
    }
}
