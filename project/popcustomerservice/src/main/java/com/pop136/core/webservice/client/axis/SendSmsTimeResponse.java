/**
 * SendSmsTimeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pop136.core.webservice.client.axis;

public class SendSmsTimeResponse  implements java.io.Serializable {
    private int sendSmsTimeResult;

    public SendSmsTimeResponse() {
    }

    public SendSmsTimeResponse(
           int sendSmsTimeResult) {
           this.sendSmsTimeResult = sendSmsTimeResult;
    }


    /**
     * Gets the sendSmsTimeResult value for this SendSmsTimeResponse.
     * 
     * @return sendSmsTimeResult
     */
    public int getSendSmsTimeResult() {
        return sendSmsTimeResult;
    }


    /**
     * Sets the sendSmsTimeResult value for this SendSmsTimeResponse.
     * 
     * @param sendSmsTimeResult
     */
    public void setSendSmsTimeResult(int sendSmsTimeResult) {
        this.sendSmsTimeResult = sendSmsTimeResult;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SendSmsTimeResponse)) return false;
        SendSmsTimeResponse other = (SendSmsTimeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            this.sendSmsTimeResult == other.getSendSmsTimeResult();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getSendSmsTimeResult();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SendSmsTimeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SendSmsTimeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sendSmsTimeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SendSmsTimeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
