package com.iu.b1.robot;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.b1.head.Header;

@SpringBootTest
class ArmTest {

	
	@Autowired
	private Header header;
	
	
	@Test
	void test() {
		assertNotNull(header);
	}

}