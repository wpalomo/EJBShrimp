/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author paca94
 */
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.imageio.ImageIO;

public class UtilsArchivos {

    private static final Properties p = System.getProperties();
    private static final String sep = p.getProperty("file.separator");
    private static final String rutaRaiz = (p.getProperty("os.name").compareToIgnoreCase("linux") == 0 ? "/opt" : p.getProperty("user.home"))
            + sep + "shrimp" + sep;

    // devuelve la ruta y si no existe la crea
    public static String crearRuta(String ruta) {
        File directorio = new File(ruta);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }
        return ruta;
    }

    // devuelve true si elimina el archivo
    public static boolean eliminarArchivo(String archivo) {
        File directorio = new File(archivo);
        return directorio.delete();
    }

    // devuelve una lista de archivos que contiene
    public static List<String> getlistArchivos(String directorio) {
        File f = new File(directorio);
        List<String> list = new ArrayList<String>();
        for (String archivo : f.list()) {
            if (archivo.endsWith(".xml")) {
                list.add(archivo);
            }
        }
        return list;
    }

    public static String getRutaRaiz() {
        return crearRuta(rutaRaiz);
    }

    public static String getRutaReportes() {
        return crearRuta(getRutaRaiz() + "reportes" + sep);
    }

    public static String getRutaImagen() {
        return crearRuta(getRutaRaiz() + "imagenes" + sep);
    }

    public static String getRutaImagenEmpleado() {
        return crearRuta(getRutaImagen() + "empleados" + sep);
    }

    public static String getRutaImagenProducto() {
        return crearRuta(getRutaImagen() + "productos" + sep);
    }

    // guarda la imagen en una ruta especifica y si el ancho y alto es diferente
    // de cero la redimenciona a la imagen
    public static String guardarImagen(String ruta, byte[] imagen,
            String nombreImagen, int ancho, int alto) {
        String mensaje = "";
        try {
            BufferedImage biImagen = ImageIO.read(new ByteArrayInputStream(imagen));
            if (ancho != 0 && alto != 0) {
                biImagen = redimencionarImagen(biImagen, ancho, alto);
            }
            ImageIO.write(biImagen, "jpg", new File(ruta + sep + nombreImagen
                    + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            mensaje = "Error al crear el archivo";
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            mensaje = "No se permite ese archivo";
        } finally {
            return mensaje;
        }
    }

    // lee la imagen entrante y la devuelve como BufferedImage
    public static BufferedImage leerImagen(InputStream imagen, String ruta) {
        try {
            if (imagen != null) {
                return ImageIO.read(imagen);
            }
            File directorio = new File(ruta);
            if (directorio.exists()) {
                return ImageIO.read(directorio);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    // lee la imagen entrante y la devuelve como BufferedImage
    public static InputStream leerImagen(String ruta) {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            BufferedImage bi = leerImagen(null, ruta);
            if (bi != null) {
                ImageIO.write(bi, "png", os);
            }
            return new ByteArrayInputStream(os.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean moverArchivo(String archivo, String archivoFinal) {
        File a = new File(archivo);
        return a.renameTo(new File(archivoFinal));
    }

    // redimenciona a la imagen
    private static BufferedImage redimencionarImagen(BufferedImage imagen,
            int ancho, int alto) {
        Image img = imagen.getScaledInstance(ancho, alto,
                Image.SCALE_AREA_AVERAGING);
        BufferedImage bufferedImage = new BufferedImage(img.getWidth(null),
                img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        bufferedImage.getGraphics().drawImage(img, 0, 0, null);
        return bufferedImage;
    }
}