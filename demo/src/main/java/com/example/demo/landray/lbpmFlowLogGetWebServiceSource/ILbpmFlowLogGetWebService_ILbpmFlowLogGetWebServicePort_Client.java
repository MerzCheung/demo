
package com.example.demo.landray.lbpmFlowLogGetWebServiceSource;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;

/**
 * This class was generated by Apache CXF 2.4.2
 * 2020-08-14T14:52:41.764+08:00
 * Generated source version: 2.4.2
 */
public final class ILbpmFlowLogGetWebService_ILbpmFlowLogGetWebServicePort_Client {

    private static final QName SERVICE_NAME = new QName("http://webservice.server.etl.lbpm.flowstatplug.dbcenter.kmss.landray.com/", "ILbpmFlowLogGetWebServiceService");

    private ILbpmFlowLogGetWebService_ILbpmFlowLogGetWebServicePort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = ILbpmFlowLogGetWebServiceService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        ILbpmFlowLogGetWebServiceService ss = new ILbpmFlowLogGetWebServiceService(wsdlURL, SERVICE_NAME);
        ILbpmFlowLogGetWebService port = ss.getILbpmFlowLogGetWebServicePort();

//        {
//            System.out.println("Invoking getFlowCategoryIsTemplate...");
//            LbpmFlowLogContext _getFlowCategoryIsTemplate_arg0 = new LbpmFlowLogContext();
//            try {
//                LbpmFlowLogResult _getFlowCategoryIsTemplate__return = port.getFlowCategoryIsTemplate(_getFlowCategoryIsTemplate_arg0);
//                System.out.println("getFlowCategoryIsTemplate.result=" + _getFlowCategoryIsTemplate__return);
//
//            } catch (Exception_Exception e) {
//                System.out.println("Expected exception: Exception has occurred.");
//                System.out.println(e.toString());
//            }
//        }
        {
            System.out.println("Invoking getFlowLog...");
            LbpmFlowLogContext _getFlowLog_arg0 = new LbpmFlowLogContext();
            try {
                _getFlowLog_arg0.setCount(1);
                _getFlowLog_arg0.setTimestamp("2020-08-14 00:00:47.000");
                LbpmFlowLogResult _getFlowLog__return = port.getFlowLog(_getFlowLog_arg0);
                System.out.println("getFlowLog.result=" + JSON.toJSON(_getFlowLog__return));

            } catch (Exception_Exception e) {
                System.out.println("Expected exception: Exception has occurred.");
                System.out.println(e.toString());
            }
        }

        System.exit(0);
    }

}
