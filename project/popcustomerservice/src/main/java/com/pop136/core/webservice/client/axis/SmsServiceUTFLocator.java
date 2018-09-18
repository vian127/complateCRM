/**
 * SmsServiceUTFLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pop136.core.webservice.client.axis;

public class SmsServiceUTFLocator extends org.apache.axis.client.Service implements SmsServiceUTF {

    public SmsServiceUTFLocator() {
    }


    public SmsServiceUTFLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SmsServiceUTFLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SmsServiceUTFSoap
    private String SmsServiceUTFSoap_address = "http://www.ldsms.com/SmsServiceUTF.asmx";

    public String getSmsServiceUTFSoapAddress() {
        return SmsServiceUTFSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private String SmsServiceUTFSoapWSDDServiceName = "SmsServiceUTFSoap";

    public String getSmsServiceUTFSoapWSDDServiceName() {
        return SmsServiceUTFSoapWSDDServiceName;
    }

    public void setSmsServiceUTFSoapWSDDServiceName(String name) {
        SmsServiceUTFSoapWSDDServiceName = name;
    }

    public SmsServiceUTFSoap_PortType getSmsServiceUTFSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SmsServiceUTFSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSmsServiceUTFSoap(endpoint);
    }

    public SmsServiceUTFSoap_PortType getSmsServiceUTFSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            SmsServiceUTFSoap_BindingStub _stub = new SmsServiceUTFSoap_BindingStub(portAddress, this);
            _stub.setPortName(getSmsServiceUTFSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSmsServiceUTFSoapEndpointAddress(String address) {
        SmsServiceUTFSoap_address = address;
    }


    // Use to get a proxy class for SmsServiceUTFSoap12
    private String SmsServiceUTFSoap12_address = "http://www.ldsms.com/SmsServiceUTF.asmx";

    public String getSmsServiceUTFSoap12Address() {
        return SmsServiceUTFSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private String SmsServiceUTFSoap12WSDDServiceName = "SmsServiceUTFSoap12";

    public String getSmsServiceUTFSoap12WSDDServiceName() {
        return SmsServiceUTFSoap12WSDDServiceName;
    }

    public void setSmsServiceUTFSoap12WSDDServiceName(String name) {
        SmsServiceUTFSoap12WSDDServiceName = name;
    }

    public SmsServiceUTFSoap_PortType getSmsServiceUTFSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SmsServiceUTFSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSmsServiceUTFSoap12(endpoint);
    }

    public SmsServiceUTFSoap_PortType getSmsServiceUTFSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            SmsServiceUTFSoap12Stub _stub = new SmsServiceUTFSoap12Stub(portAddress, this);
            _stub.setPortName(getSmsServiceUTFSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSmsServiceUTFSoap12EndpointAddress(String address) {
        SmsServiceUTFSoap12_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (SmsServiceUTFSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                SmsServiceUTFSoap_BindingStub _stub = new SmsServiceUTFSoap_BindingStub(new java.net.URL(SmsServiceUTFSoap_address), this);
                _stub.setPortName(getSmsServiceUTFSoapWSDDServiceName());
                return _stub;
            }
            if (SmsServiceUTFSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                SmsServiceUTFSoap12Stub _stub = new SmsServiceUTFSoap12Stub(new java.net.URL(SmsServiceUTFSoap12_address), this);
                _stub.setPortName(getSmsServiceUTFSoap12WSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("SmsServiceUTFSoap".equals(inputPortName)) {
            return getSmsServiceUTFSoap();
        }
        else if ("SmsServiceUTFSoap12".equals(inputPortName)) {
            return getSmsServiceUTFSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "SmsServiceUTF");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "SmsServiceUTFSoap"));
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "SmsServiceUTFSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {

if ("SmsServiceUTFSoap".equals(portName)) {
            setSmsServiceUTFSoapEndpointAddress(address);
        }
        else
if ("SmsServiceUTFSoap12".equals(portName)) {
            setSmsServiceUTFSoap12EndpointAddress(address);
        }
        else
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
