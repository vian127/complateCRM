package com.pop136.core.webservice.client;

import com.pop136.core.webservice.client.axis.*;


public class SMSClient {

    public static void sendSms(String username, String password, String mobile, String content) throws Exception
    {
        SmsServiceUTFSoap_BindingStub binding;
        try {
            binding = (SmsServiceUTFSoap_BindingStub) new SmsServiceUTFLocator().getSmsServiceUTFSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new Exception("Send SMS Error JAX-RPC ServiceException caught: " + jre);
        }
        // Time out after a minute
        binding.setTimeout(60000);
        // Test operation
        int value = -3;
        value = binding.sendSMS(username,password,mobile,content);
    }

    public static void main(String args[]) throws Exception{

        SmsServiceUTFSoap_BindingStub binding;
        try {
            binding = (SmsServiceUTFSoap_BindingStub) new SmsServiceUTFLocator().getSmsServiceUTFSoap();
        }catch (Exception e) {
            throw new Exception("JAX-RPC ServiceException caught: " + e);
        }
        // Time out after a minute
        binding.setTimeout(60000);
        // Test operation
        int value = -3;
        value = binding.sendSMS("iek-7107","Mffg37dhGd34Bfd","13764362715","test122");

    }

}