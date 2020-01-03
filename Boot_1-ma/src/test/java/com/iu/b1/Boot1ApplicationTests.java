package com.iu.b1;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Boot1ApplicationTests {
	
	@Autowired
	private DataSource dataSource;

	@Test
	void contextLoads() throws Exception {
		assertNotNull(dataSource.getConnection());
	}

}
