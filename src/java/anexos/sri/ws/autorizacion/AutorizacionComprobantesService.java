
package anexos.sri.ws.autorizacion;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.*;

@WebServiceClient(name = "AutorizacionComprobantesService", targetNamespace = "http://ec.gob.sri.ws.autorizacion", wsdlLocation = "")
public class AutorizacionComprobantesService extends Service {

	private static URL __getWsdlLocation() {
		if (AUTORIZACIONCOMPROBANTESSERVICE_EXCEPTION != null) {
			throw AUTORIZACIONCOMPROBANTESSERVICE_EXCEPTION;
		}
		return AUTORIZACIONCOMPROBANTESSERVICE_WSDL_LOCATION;
	}

	private final static URL AUTORIZACIONCOMPROBANTESSERVICE_WSDL_LOCATION;
	private final static WebServiceException AUTORIZACIONCOMPROBANTESSERVICE_EXCEPTION;

	private final static QName AUTORIZACIONCOMPROBANTESSERVICE_QNAME = new QName(
			"http://ec.gob.sri.ws.autorizacion",
			"AutorizacionComprobantesService");

	static {
		URL url = null;
		WebServiceException e = null;
		try {
			url = new URL(
					"https://cel.sri.gob.ec/comprobantes-electronicos-ws/AutorizacionComprobantes?wsdl");
		} catch (MalformedURLException ex) {
			e = new WebServiceException(ex);
		}
		AUTORIZACIONCOMPROBANTESSERVICE_WSDL_LOCATION = url;
		AUTORIZACIONCOMPROBANTESSERVICE_EXCEPTION = e;
	}

	public AutorizacionComprobantesService() {
		super(__getWsdlLocation(), AUTORIZACIONCOMPROBANTESSERVICE_QNAME);
	}

	public AutorizacionComprobantesService(URL wsdlLocation) {
		super(wsdlLocation, AUTORIZACIONCOMPROBANTESSERVICE_QNAME);
	}

	public AutorizacionComprobantesService(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}
        

//	public AutorizacionComprobantesService(URL wsdlLocation, QName serviceName,
//			WebServiceFeature... features) {
//		super(wsdlLocation, serviceName, features);
//	}
//
//	public AutorizacionComprobantesService(URL wsdlLocation,
//			WebServiceFeature... features) {
//		super(wsdlLocation, AUTORIZACIONCOMPROBANTESSERVICE_QNAME, features);
//	}
//
//	public AutorizacionComprobantesService(WebServiceFeature... features) {
//		super(__getWsdlLocation(), AUTORIZACIONCOMPROBANTESSERVICE_QNAME,
//				features);
//	}

	@WebEndpoint(name = "AutorizacionComprobantesPort")
	public AutorizacionComprobantes getAutorizacionComprobantesPort() {
		return super
				.getPort(new QName("http://ec.gob.sri.ws.autorizacion",
						"AutorizacionComprobantesPort"),
						AutorizacionComprobantes.class);
	}

	@WebEndpoint(name = "AutorizacionComprobantesPort")
	public AutorizacionComprobantes getAutorizacionComprobantesPort(
			WebServiceFeature... features) {
		return super.getPort(new QName("http://ec.gob.sri.ws.autorizacion",
				"AutorizacionComprobantesPort"),
				AutorizacionComprobantes.class, features);
	}

}



/*
 @WebServiceClient(name = "AutorizacionComprobantesService", targetNamespace = "http://ec.gob.sri.ws.autorizacion", wsdlLocation = "/META-INF/wsdl/AutorizacionComprobantes.wsdl")
public class AutorizacionComprobantesService extends Service {

    private static final URL AUTORIZACIONCOMPROBANTESSERVICE_WSDL_LOCATION;
    private static final WebServiceException AUTORIZACIONCOMPROBANTESSERVICE_EXCEPTION;
    private static final QName AUTORIZACIONCOMPROBANTESSERVICE_QNAME;

    public AutorizacionComprobantesService() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public AutorizacionComprobantesService(URL wsdlLocation) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    public AutorizacionComprobantesService(URL wsdlLocation, QName serviceName) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    @WebEndpoint(name = "AutorizacionComprobantesPort")
    public AutorizacionComprobantes getAutorizacionComprobantesPort() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    @WebEndpoint(name = "AutorizacionComprobantesPort")
    public AutorizacionComprobantes getAutorizacionComprobantesPort(WebServiceFeature[] features) {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }

    private static URL __getWsdlLocation() {
        //compiled code
        throw new RuntimeException("Compiled Code");
    }
}
 */