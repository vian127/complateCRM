/**
 * SendSmsReResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pop136.core.webservice.client.axis;

public class SendSmsReResponse  implements java.io.Serializable {
    private int sendSmsReResult;

    public SendSmsReResponse() {
    }

    public SendSmsReResponse(
           int sendSmsReResult) {
           this.sendSmsReResult = sendSmsReResult;
    }


    /**
     * Gets the sendSmsReResult value for this SendSmsReResponse.
     * 
     * @return sendSmsReResult
     */
    public int getSendSmsReResult() {
        return sendSmsReResult;
    }


    /**
     * Sets the sendSmsReResult value for this SendSmsReResponse.
     * 
     * @param sendSmsReResult
     */
    public void setSendSmsReResult(int sendSmsReResult) {
        this.sendSmsReResult = sendSmsReResult;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SendSmsReResponse)) return false;
        SendSmsReResponse other = (SendSmsReResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            this.sendSmsReResult == other.getSendSmsReResult();
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
        _hashCode += getSendSmsReResult();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SendSmsReResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SendSmsReResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sendSmsReResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SendSmsReResult"));
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
