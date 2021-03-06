package com.example.demo.landray.lbpmFlowLogGetWebServiceSource;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.4.2
 * 2020-08-14T14:52:41.786+08:00
 * Generated source version: 2.4.2
 * 
 */
@WebServiceClient(name = "ILbpmFlowLogGetWebServiceService", 
                  wsdlLocation = "http://172.16.3.28:8080/sys/webservice/lbpmFlowLogGetWebService?wsdl",
                  targetNamespace = "http://webservice.server.etl.lbpm.flowstatplug.dbcenter.kmss.landray.com/") 
public class ILbpmFlowLogGetWebServiceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://webservice.server.etl.lbpm.flowstatplug.dbcenter.kmss.landray.com/", "ILbpmFlowLogGetWebServiceService");
    public final static QName ILbpmFlowLogGetWebServicePort = new QName("http://webservice.server.etl.lbpm.flowstatplug.dbcenter.kmss.landray.com/", "ILbpmFlowLogGetWebServicePort");
    static {
        URL url = null;
        try {
            url = new URL("http://172.16.3.28:8080/sys/webservice/lbpmFlowLogGetWebService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ILbpmFlowLogGetWebServiceService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://172.16.3.28:8080/sys/webservice/lbpmFlowLogGetWebService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ILbpmFlowLogGetWebServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ILbpmFlowLogGetWebServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ILbpmFlowLogGetWebServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ILbpmFlowLogGetWebServiceService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ILbpmFlowLogGetWebServiceService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ILbpmFlowLogGetWebServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns ILbpmFlowLogGetWebService
     */
    @WebEndpoint(name = "ILbpmFlowLogGetWebServicePort")
    public ILbpmFlowLogGetWebService getILbpmFlowLogGetWebServicePort() {
        return super.getPort(ILbpmFlowLogGetWebServicePort, ILbpmFlowLogGetWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ILbpmFlowLogGetWebService
     */
    @WebEndpoint(name = "ILbpmFlowLogGetWebServicePort")
    public ILbpmFlowLogGetWebService getILbpmFlowLogGetWebServicePort(WebServiceFeature... features) {
        return super.getPort(ILbpmFlowLogGetWebServicePort, ILbpmFlowLogGetWebService.class, features);
    }

}
