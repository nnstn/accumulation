package com.pursuit.encryption.base;

import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.util.Map;

import org.junit.Test;

public class EncryptionTest {
	@Test
	public void testProvider(){
		for (Provider provider:Security.getProviders()) {
			System.out.println(provider);
			for (Map.Entry<Object, Object> entry :provider.entrySet()) {
				System.out.println("\t"+entry.getKey()+"::"+entry.getValue());
			}
		}
	}
	@Test
	public void testMessageDigest(){
		MessageDigest digest ;       
	}
	@Test
	public void testBase64(){
		//new BASE64Deco
		
	}
	
}
