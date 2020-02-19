package com.Service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.DTO.User;

class Testing {
Service s=new Service();
	@Test
	void test() {
		assertEquals(true,s.register("123",new User("123","Master", "Master$1","karuravinder@gmail.com",BigInteger.valueOf(Long.parseLong("9023434967")), "Admin", "Chinna", "Male")));
	assertEquals(true, s.ViewProfile("123"));
	assertEquals(true,s.updateProfile("123"));

	 assertEquals(false,s.forgotpass("123"));
		 assertEquals(false,s.changePass("123"));
		 
	;
	}

}
