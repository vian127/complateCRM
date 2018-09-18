/**
 * SendSmsReExResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pop136.core.webservice.client.axis;

public class SendSmsReExResponse  implements java.io.Serializable {
    private int sendSmsReExResult;

    public SendSmsReExResponse() {
    }

    public SendSmsReExResponse(
           int sendSmsReExResult) {
           this.sendSmsReExResult = sendSmsReExResult;
    }


    /**
     * Gets the sendSmsReExResult value for this SendSmsReExResponse.
     * 
     * @return sendSmsReExResult
     */
    public int getSendSmsReExResult() {
        return sendSmsReExResult;
    }


    /**
     * Sets the sendSmsReExResult value for this SendSmsReExResponse.
     * 
     * @param sendSmsReExResult
     */
    public void setSendSmsReExResult(int sendSmsReExResult) {
        this.sendSmsReExResult = sendSmsReExResult;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SendSmsReExResponse)) return false;
        SendSmsReExResponse other = (SendSmsReExResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            this.sendSmsReExResult == other.getSendSmsReExResult();
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
        _hashCode += getSendSmsReExResult();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SendSmsReExResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SendSmsReExResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sendSmsReExResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SendSmsReExResult"));
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
