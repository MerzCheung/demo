
package com.example.demo.landray.com.landray.kmss.lbpmFlowLogGetWebServiceSource;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.landray.kmss.dbcenter.flowstatplug.lbpm.etl.server.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetFlowLog_QNAME = new QName("http://webservice.server.etl.lbpm.flowstatplug.dbcenter.kmss.landray.com/", "getFlowLog");
    private final static QName _Exception_QNAME = new QName("http://webservice.server.etl.lbpm.flowstatplug.dbcenter.kmss.landray.com/", "Exception");
    private final static QName _GetFlowLogResponse_QNAME = new QName("http://webservice.server.etl.lbpm.flowstatplug.dbcenter.kmss.landray.com/", "getFlowLogResponse");
    private final static QName _GetFlowCategoryIsTemplate_QNAME = new QName("http://webservice.server.etl.lbpm.flowstatplug.dbcenter.kmss.landray.com/", "getFlowCategoryIsTemplate");
    private final static QName _GetFlowCategoryIsTemplateResponse_QNAME = new QName("http://webservice.server.etl.lbpm.flowstatplug.dbcenter.kmss.landray.com/", "getFlowCategoryIsTemplateResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.landray.kmss.dbcenter.flowstatplug.lbpm.etl.server.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link java.lang.Exception }
     * 
     */
    public java.lang.Exception createException() {
        return new java.lang.Exception();
    }

    /**
     * Create an instance of {@link GetFlowLog }
     * 
     */
    public GetFlowLog createGetFlowLog() {
        return new GetFlowLog();
    }

    /**
     * Create an instance of {@link GetFlowCategoryIsTemplate }
     * 
     */
    public GetFlowCategoryIsTemplate createGetFlowCategoryIsTemplate() {
        return new GetFlowCategoryIsTemplate();
    }

    /**
     * Create an instance of {@link GetFlowCategoryIsTemplateResponse }
     * 
     */
    public GetFlowCategoryIsTemplateResponse createGetFlowCategoryIsTemplateResponse() {
        return new GetFlowCategoryIsTemplateResponse();
    }

    /**
     * Create an instance of {@link GetFlowLogResponse }
     * 
     */
    public GetFlowLogResponse createGetFlowLogResponse() {
        return new GetFlowLogResponse();
    }

    /**
     * Create an instance of {@link LbpmFlowLogContext }
     * 
     */
    public LbpmFlowLogContext createLbpmFlowLogContext() {
        return new LbpmFlowLogContext();
    }

    /**
     * Create an instance of {@link LbpmFlowLogResult }
     * 
     */
    public LbpmFlowLogResult createLbpmFlowLogResult() {
        return new LbpmFlowLogResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlowLog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.server.etl.lbpm.flowstatplug.dbcenter.kmss.landray.com/", name = "getFlowLog")
    public JAXBElement<GetFlowLog> createGetFlowLog(GetFlowLog value) {
        return new JAXBElement<GetFlowLog>(_GetFlowLog_QNAME, GetFlowLog.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link java.lang.Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.server.etl.lbpm.flowstatplug.dbcenter.kmss.landray.com/", name = "Exception")
    public JAXBElement<java.lang.Exception> createException(java.lang.Exception value) {
        return new JAXBElement<java.lang.Exception>(_Exception_QNAME, java.lang.Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlowLogResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.server.etl.lbpm.flowstatplug.dbcenter.kmss.landray.com/", name = "getFlowLogResponse")
    public JAXBElement<GetFlowLogResponse> createGetFlowLogResponse(GetFlowLogResponse value) {
        return new JAXBElement<GetFlowLogResponse>(_GetFlowLogResponse_QNAME, GetFlowLogResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlowCategoryIsTemplate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.server.etl.lbpm.flowstatplug.dbcenter.kmss.landray.com/", name = "getFlowCategoryIsTemplate")
    public JAXBElement<GetFlowCategoryIsTemplate> createGetFlowCategoryIsTemplate(GetFlowCategoryIsTemplate value) {
        return new JAXBElement<GetFlowCategoryIsTemplate>(_GetFlowCategoryIsTemplate_QNAME, GetFlowCategoryIsTemplate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlowCategoryIsTemplateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.server.etl.lbpm.flowstatplug.dbcenter.kmss.landray.com/", name = "getFlowCategoryIsTemplateResponse")
    public JAXBElement<GetFlowCategoryIsTemplateResponse> createGetFlowCategoryIsTemplateResponse(GetFlowCategoryIsTemplateResponse value) {
        return new JAXBElement<GetFlowCategoryIsTemplateResponse>(_GetFlowCategoryIsTemplateResponse_QNAME, GetFlowCategoryIsTemplateResponse.class, null, value);
    }

}
