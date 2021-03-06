
package com.example.demo.landray.lbpmFlowLogGetWebServiceSource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getFlowLog complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getFlowLog">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://webservice.server.etl.lbpm.flowstatplug.dbcenter.kmss.landray.com/}lbpmFlowLogContext" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFlowLog", propOrder = {
    "arg0"
})
public class GetFlowLog {

    protected LbpmFlowLogContext arg0;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link LbpmFlowLogContext }
     *     
     */
    public LbpmFlowLogContext getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link LbpmFlowLogContext }
     *     
     */
    public void setArg0(LbpmFlowLogContext value) {
        this.arg0 = value;
    }

}
