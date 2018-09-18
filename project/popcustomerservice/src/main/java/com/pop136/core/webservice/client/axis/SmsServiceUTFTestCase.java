/**
 * SmsServiceUTFTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pop136.core.webservice.client.axis;

public class SmsServiceUTFTestCase
{

}
/*
        extends junit.framework.TestCase {
    public SmsServiceUTFTestCase(String name) {
        super(name);
    }

    public void testSmsServiceUTFSoapWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new com.pop136.webservice.client.SmsServiceUTFLocator().getSmsServiceUTFSoapAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new com.pop136.webservice.client.SmsServiceUTFLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1SmsServiceUTFSoapGetBalance() throws Exception {
        com.pop136.webservice.client.SmsServiceUTFSoap_BindingStub binding;
        try {
            binding = (com.pop136.webservice.client.SmsServiceUTFSoap_BindingStub)
                          new com.pop136.webservice.client.SmsServiceUTFLocator().getSmsServiceUTFSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.getBalance(new String(), new String());
        // TBD - validate results
    }

    public void test2SmsServiceUTFSoapRecvSms() throws Exception {
        com.pop136.webservice.client.SmsServiceUTFSoap_BindingStub binding;
        try {
            binding = (com.pop136.webservice.client.SmsServiceUTFSoap_BindingStub)
                          new com.pop136.webservice.client.SmsServiceUTFLocator().getSmsServiceUTFSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        String value = null;
        value = binding.recvSms(new String(), new String());
        // TBD - validate results
    }

    public void test3SmsServiceUTFSoapRecvSmsEx() throws Exception {
        com.pop136.webservice.client.SmsServiceUTFSoap_BindingStub binding;
        try {
            binding = (com.pop136.webservice.client.SmsServiceUTFSoap_BindingStub)
                          new com.pop136.webservice.client.SmsServiceUTFLocator().getSmsServiceUTFSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        com.pop136.webservice.client.RecvSmsExResponseRecvSmsExResult value = null;
        value = binding.recvSmsEx(new String(), new String());
        // TBD - validate results
    }

    public void test4SmsServiceUTFSoapSendSMS() throws Exception {
        com.pop136.webservice.client.SmsServiceUTFSoap_BindingStub binding;
        try {
            binding = (com.pop136.webservice.client.SmsServiceUTFSoap_BindingStub)
                          new com.pop136.webservice.client.SmsServiceUTFLocator().getSmsServiceUTFSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.sendSMS("iek-7107","Mffg37dhGd34Bfd","13601911603","test22");
        // TBD - validate results
    }

    public void test5SmsServiceUTFSoapSendSmsTime() throws Exception {
        com.pop136.webservice.client.SmsServiceUTFSoap_BindingStub binding;
        try {
            binding = (com.pop136.webservice.client.SmsServiceUTFSoap_BindingStub)
                          new com.pop136.webservice.client.SmsServiceUTFLocator().getSmsServiceUTFSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.sendSmsTime(new String(), new String(), new String(), new String(), new String());
        // TBD - validate results
    }

    public void test6SmsServiceUTFSoapSendSmsEXTRequest() throws Exception {
        com.pop136.webservice.client.SmsServiceUTFSoap_BindingStub binding;
        try {
            binding = (com.pop136.webservice.client.SmsServiceUTFSoap_BindingStub)
                          new com.pop136.webservice.client.SmsServiceUTFLocator().getSmsServiceUTFSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.sendSmsEXTRequest(new String(), new String(), new String(), new String(), new String(), new String());
        // TBD - validate results
    }

    public void test7SmsServiceUTFSoapSendSmsRe() throws Exception {
        com.pop136.webservice.client.SmsServiceUTFSoap_BindingStub binding;
        try {
            binding = (com.pop136.webservice.client.SmsServiceUTFSoap_BindingStub)
                          new com.pop136.webservice.client.SmsServiceUTFLocator().getSmsServiceUTFSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.sendSmsRe(new String(), new String(), new String(), new String(), new String(), new String(), new String());
        // TBD - validate results
    }

    public void test8SmsServiceUTFSoapSendSmsReEx() throws Exception {
        com.pop136.webservice.client.SmsServiceUTFSoap_BindingStub binding;
        try {
            binding = (com.pop136.webservice.client.SmsServiceUTFSoap_BindingStub)
                          new com.pop136.webservice.client.SmsServiceUTFLocator().getSmsServiceUTFSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.sendSmsReEx(new String(), new String(), new String(), new String(), new String(), new String(), new String());
        // TBD - validate results
    }

    public void testSmsServiceUTFSoap12WSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new com.pop136.webservice.client.SmsServiceUTFLocator().getSmsServiceUTFSoap12Address() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new com.pop136.webservice.client.SmsServiceUTFLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test9SmsServiceUTFSoap12GetBalance() throws Exception {
        com.pop136.webservice.client.SmsServiceUTFSoap12Stub binding;
        try {
            binding = (com.pop136.webservice.client.SmsServiceUTFSoap12Stub)
                          new com.pop136.webservice.client.SmsServiceUTFLocator().getSmsServiceUTFSoap12();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.getBalance(new String(), new String());
        // TBD - validate results
    }

    public void test10SmsServiceUTFSoap12RecvSms() throws Exception {
        com.pop136.webservice.client.SmsServiceUTFSoap12Stub binding;
        try {
            binding = (com.pop136.webservice.client.SmsServiceUTFSoap12Stub)
                          new com.pop136.webservice.client.SmsServiceUTFLocator().getSmsServiceUTFSoap12();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        String value = null;
        value = binding.recvSms(new String(), new String());
        // TBD - validate results
    }

    public void test11SmsServiceUTFSoap12RecvSmsEx() throws Exception {
        com.pop136.webservice.client.SmsServiceUTFSoap12Stub binding;
        try {
            binding = (com.pop136.webservice.client.SmsServiceUTFSoap12Stub)
                          new com.pop136.webservice.client.SmsServiceUTFLocator().getSmsServiceUTFSoap12();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        com.pop136.webservice.client.RecvSmsExResponseRecvSmsExResult value = null;
        value = binding.recvSmsEx(new String(), new String());
        // TBD - validate results
    }

    public void test12SmsServiceUTFSoap12SendSMS() throws Exception {
        com.pop136.webservice.client.SmsServiceUTFSoap12Stub binding;
        try {
            binding = (com.pop136.webservice.client.SmsServiceUTFSoap12Stub)
                          new com.pop136.webservice.client.SmsServiceUTFLocator().getSmsServiceUTFSoap12();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.sendSMS(new String(), new String(), new String(), new String());
        // TBD - validate results
    }

    public void test13SmsServiceUTFSoap12SendSmsTime() throws Exception {
        com.pop136.webservice.client.SmsServiceUTFSoap12Stub binding;
        try {
            binding = (com.pop136.webservice.client.SmsServiceUTFSoap12Stub)
                          new com.pop136.webservice.client.SmsServiceUTFLocator().getSmsServiceUTFSoap12();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.sendSmsTime(new String(), new String(), new String(), new String(), new String());
        // TBD - validate results
    }

    public void test14SmsServiceUTFSoap12SendSmsEXTRequest() throws Exception {
        com.pop136.webservice.client.SmsServiceUTFSoap12Stub binding;
        try {
            binding = (com.pop136.webservice.client.SmsServiceUTFSoap12Stub)
                          new com.pop136.webservice.client.SmsServiceUTFLocator().getSmsServiceUTFSoap12();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.sendSmsEXTRequest(new String(), new String(), new String(), new String(), new String(), new String());
        // TBD - validate results
    }

    public void test15SmsServiceUTFSoap12SendSmsRe() throws Exception {
        com.pop136.webservice.client.SmsServiceUTFSoap12Stub binding;
        try {
            binding = (com.pop136.webservice.client.SmsServiceUTFSoap12Stub)
                          new com.pop136.webservice.client.SmsServiceUTFLocator().getSmsServiceUTFSoap12();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.sendSmsRe(new String(), new String(), new String(), new String(), new String(), new String(), new String());
        // TBD - validate results
    }

    public void test16SmsServiceUTFSoap12SendSmsReEx() throws Exception {
        com.pop136.webservice.client.SmsServiceUTFSoap12Stub binding;
        try {
            binding = (com.pop136.webservice.client.SmsServiceUTFSoap12Stub)
                          new com.pop136.webservice.client.SmsServiceUTFLocator().getSmsServiceUTFSoap12();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.sendSmsReEx(new String(), new String(), new String(), new String(), new String(), new String(), new String());
        // TBD - validate results
    }

}
*/
