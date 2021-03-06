/**
 * NOTE: This copyright does *not* cover user programs that use HQ
 * program services by normal system calls through the application
 * program interfaces provided as part of the Hyperic Plug-in Development
 * Kit or the Hyperic Client Development Kit - this is merely considered
 * normal use of the program, and does *not* fall under the heading of
 *  "derived work".
 *
 *  Copyright (C) [2009-2011], VMware, Inc.
 *  This file is part of HQ.
 *
 *  HQ is free software; you can redistribute it and/or modify
 *  it under the terms version 2 of the GNU General Public License as
 *  published by the Free Software Foundation. This program is distributed
 *  in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 *  even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 *  PARTICULAR PURPOSE. See the GNU General Public License for more
 *  details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 *  USA.
 *
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.12.07 at 01:58:59 PM CST 
//


package org.hyperic.hq.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AlertCondition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AlertCondition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="logLevel" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="logMatches" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="recoverId" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="recover" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="metricChange" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="baselineMetric" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="baselineComparator" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="baselinePercentage" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="baselineType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="thresholdMetric" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="thresholdComparator" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="thresholdValue" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="configMatch" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="controlAction" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="controlStatus" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="required" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AlertCondition")
public class AlertCondition {

    @XmlAttribute(name = "property")
    protected String property;
    @XmlAttribute(name = "logLevel")
    protected String logLevel;
    @XmlAttribute(name = "logMatches")
    protected String logMatches;
    @XmlAttribute(name = "recoverId")
    protected Integer recoverId;
    @XmlAttribute(name = "recover")
    protected String recover;
    @XmlAttribute(name = "metricChange")
    protected String metricChange;
    @XmlAttribute(name = "baselineMetric")
    protected String baselineMetric;
    @XmlAttribute(name = "baselineComparator")
    protected String baselineComparator;
    @XmlAttribute(name = "baselinePercentage")
    protected Double baselinePercentage;
    @XmlAttribute(name = "baselineType")
    protected String baselineType;
    @XmlAttribute(name = "thresholdMetric")
    protected String thresholdMetric;
    @XmlAttribute(name = "thresholdComparator")
    protected String thresholdComparator;
    @XmlAttribute(name = "thresholdValue")
    protected Double thresholdValue;
    @XmlAttribute(name = "configMatch")
    protected String configMatch;
    @XmlAttribute(name = "controlAction")
    protected String controlAction;
    @XmlAttribute(name = "controlStatus")
    protected String controlStatus;
    @XmlAttribute(name = "type", required = true)
    protected int type;
    @XmlAttribute(name = "required", required = true)
    protected boolean required;

    /**
     * Gets the value of the property property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperty() {
        return property;
    }

    /**
     * Sets the value of the property property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperty(String value) {
        this.property = value;
    }

    /**
     * Gets the value of the logLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogLevel() {
        return logLevel;
    }

    /**
     * Sets the value of the logLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogLevel(String value) {
        this.logLevel = value;
    }

    /**
     * Gets the value of the logMatches property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogMatches() {
        return logMatches;
    }

    /**
     * Sets the value of the logMatches property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogMatches(String value) {
        this.logMatches = value;
    }

    /**
     * Gets the value of the recoverId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRecoverId() {
        return recoverId;
    }

    /**
     * Sets the value of the recoverId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRecoverId(Integer value) {
        this.recoverId = value;
    }

    /**
     * Gets the value of the recover property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecover() {
        return recover;
    }

    /**
     * Sets the value of the recover property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecover(String value) {
        this.recover = value;
    }

    /**
     * Gets the value of the metricChange property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetricChange() {
        return metricChange;
    }

    /**
     * Sets the value of the metricChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetricChange(String value) {
        this.metricChange = value;
    }

    /**
     * Gets the value of the baselineMetric property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaselineMetric() {
        return baselineMetric;
    }

    /**
     * Sets the value of the baselineMetric property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaselineMetric(String value) {
        this.baselineMetric = value;
    }

    /**
     * Gets the value of the baselineComparator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaselineComparator() {
        return baselineComparator;
    }

    /**
     * Sets the value of the baselineComparator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaselineComparator(String value) {
        this.baselineComparator = value;
    }

    /**
     * Gets the value of the baselinePercentage property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBaselinePercentage() {
        return baselinePercentage;
    }

    /**
     * Sets the value of the baselinePercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBaselinePercentage(Double value) {
        this.baselinePercentage = value;
    }

    /**
     * Gets the value of the baselineType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaselineType() {
        return baselineType;
    }

    /**
     * Sets the value of the baselineType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaselineType(String value) {
        this.baselineType = value;
    }

    /**
     * Gets the value of the thresholdMetric property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThresholdMetric() {
        return thresholdMetric;
    }

    /**
     * Sets the value of the thresholdMetric property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThresholdMetric(String value) {
        this.thresholdMetric = value;
    }

    /**
     * Gets the value of the thresholdComparator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThresholdComparator() {
        return thresholdComparator;
    }

    /**
     * Sets the value of the thresholdComparator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThresholdComparator(String value) {
        this.thresholdComparator = value;
    }

    /**
     * Gets the value of the thresholdValue property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getThresholdValue() {
        return thresholdValue;
    }

    /**
     * Sets the value of the thresholdValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setThresholdValue(Double value) {
        this.thresholdValue = value;
    }

    /**
     * Gets the value of the configMatch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfigMatch() {
        return configMatch;
    }

    /**
     * Sets the value of the configMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfigMatch(String value) {
        this.configMatch = value;
    }

    /**
     * Gets the value of the controlAction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getControlAction() {
        return controlAction;
    }

    /**
     * Sets the value of the controlAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setControlAction(String value) {
        this.controlAction = value;
    }

    /**
     * Gets the value of the controlStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getControlStatus() {
        return controlStatus;
    }

    /**
     * Sets the value of the controlStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setControlStatus(String value) {
        this.controlStatus = value;
    }

    /**
     * Gets the value of the type property.
     * 
     */
    public int getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     */
    public void setType(int value) {
        this.type = value;
    }

    /**
     * Gets the value of the required property.
     * 
     */
    public boolean isRequired() {
        return required;
    }

    /**
     * Sets the value of the required property.
     * 
     */
    public void setRequired(boolean value) {
        this.required = value;
    }

}
