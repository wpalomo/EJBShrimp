package anexos.sri.comprobantes.util.xml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Java2XML {

    public static void objetoTOxml(Class clase, String ruta, Object obj) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clase);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(obj, new File(ruta));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
