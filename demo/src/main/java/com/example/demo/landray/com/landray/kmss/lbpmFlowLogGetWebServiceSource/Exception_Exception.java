
package com.example.demo.landray.com.landray.kmss.lbpmFlowLogGetWebServiceSource;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.4.2
 * 2020-08-14T14:52:41.775+08:00
 * Generated source version: 2.4.2
 */

@WebFault(name = "Exception", targetNamespace = "http://webservice.server.etl.lbpm.flowstatplug.dbcenter.kmss.landray.com/")
public class Exception_Exception extends java.lang.Exception {
    
    private Exception exception;

    public Exception_Exception() {
        super();
    }
    
    public Exception_Exception(String message) {
        super(message);
    }
    
    public Exception_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public Exception_Exception(String message, Exception exception) {
        super(message);
        this.exception = exception;
    }

    public Exception_Exception(String message, Exception exception, Throwable cause) {
        super(message, cause);
        this.exception = exception;
    }

    public Exception getFaultInfo() {
        return this.exception;
    }
}
