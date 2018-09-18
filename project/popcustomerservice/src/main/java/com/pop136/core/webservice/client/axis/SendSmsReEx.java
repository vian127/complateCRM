/**
 * SendSmsReEx.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pop136.core.webservice.client.axis;

public class SendSmsReEx  implements java.io.Serializable {
    private String username;

    private String password;

    private String mobile;

    private String smsID;

    private String smscontent;

    private String sendtime;

    private String sa;

    public SendSmsReEx() {
    }

    public SendSmsReEx(
           String username,
           String password,
           String mobile,
           String smsID,
           String smscontent,
           String sendtime,
           String sa) {
           this.username = username;
           this.password = password;
           this.mobile = mobile;
           this.smsID = smsID;
           this.smscontent = smscontent;
           this.sendtime = sendtime;
           this.sa = sa;
    }


    /**
     * Gets the username value for this SendSmsReEx.
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }


    /**
     * Sets the username value for this SendSmsReEx.
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }


    /**
     * Gets the password value for this SendSmsReEx.
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this SendSmsReEx.
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * Gets the mobile value for this SendSmsReEx.
     *
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }


    /**
     * Sets the mobile value for this SendSmsReEx.
     *
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    /**
     * Gets the smsID value for this SendSmsReEx.
     *
     * @return smsID
     */
    public String getSmsID() {
        return smsID;
    }


    /**
     * Sets the smsID value for this SendSmsReEx.
     *
     * @param smsID
     */
    public void setSmsID(String smsID) {
        this.smsID = smsID;
    }


    /**
     * Gets the smscontent value for this SendSmsReEx.
     *
     * @return smscontent
     */
    public String getSmscontent() {
        return smscontent;
    }


    /**
     * Sets the smscontent value for this SendSmsReEx.
     *
     * @param smscontent
     */
    public void setSmscontent(String smscontent) {
        this.smscontent = smscontent;
    }


    /**
     * Gets the sendtime value for this SendSmsReEx.
     *
     * @return sendtime
     */
    public String getSendtime() {
        return sendtime;
    }


    /**
     * Sets the sendtime value for this SendSmsReEx.
     *
     * @param sendtime
     */
    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }


    /**
     * Gets the sa value for this SendSmsReEx.
     *
     * @return sa
     */
    public String getSa() {
        return sa;
    }


    /**
     * Sets the sa value for this SendSmsReEx.
     *
     * @param sa
     */
    public void setSa(String sa) {
        this.sa = sa;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SendSmsReEx)) return false;
        SendSmsReEx other = (SendSmsReEx) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.username==null && other.getUsername()==null) ||
             (this.username!=null &&
              this.username.equals(other.getUsername()))) &&
            ((this.password==null && other.getPassword()==null) ||
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.mobile==null && other.getMobile()==null) ||
             (this.mobile!=null &&
              this.mobile.equals(other.getMobile()))) &&
            ((this.smsID==null && other.getSmsID()==null) ||
             (this.smsID!=null &&
              this.smsID.equals(other.getSmsID()))) &&
            ((this.smscontent==null && other.getSmscontent()==null) ||
             (this.smscontent!=null &&
              this.smscontent.equals(other.getSmscontent()))) &&
            ((this.sendtime==null && other.getSendtime()==null) ||
             (this.sendtime!=null &&
              this.sendtime.equals(other.getSendtime()))) &&
            ((this.sa==null && other.getSa()==null) ||
             (this.sa!=null &&
              this.sa.equals(other.getSa())));
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
        if (getUsername() != null) {
            _hashCode += getUsername().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getMobile() != null) {
            _hashCode += getMobile().hashCode();
        }
        if (getSmsID() != null) {
            _hashCode += getSmsID().hashCode();
        }
        if (getSmscontent() != null) {
            _hashCode += getSmscontent().hashCode();
        }
        if (getSendtime() != null) {
            _hashCode += getSendtime().hashCode();
        }
        if (getSa() != null) {
            _hashCode += getSa().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SendSmsReEx.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SendSmsReEx"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("username");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "username"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "mobile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smsID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "smsID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smscontent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "smscontent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sendtime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sendtime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
