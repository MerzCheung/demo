
package com.example.demo.landray.lbpmFlowLogGetWebServiceSource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getFlowCategoryIsTemplateResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getFlowCategoryIsTemplateResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://webservice.server.etl.lbpm.flowstatplug.dbcenter.kmss.landray.com/}lbpmFlowLogResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFlowCategoryIsTemplateResponse", propOrder = {
    "_return"
})
public class GetFlowCategoryIsTemplateResponse {

    @XmlElement(name = "return")
    protected LbpmFlowLogResult _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link LbpmFlowLogResult }
     *     
     */
    public LbpmFlowLogResult getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link LbpmFlowLogResult }
     *     
     */
    public void setReturn(LbpmFlowLogResult value) {
        this._return = value;
    }

}
