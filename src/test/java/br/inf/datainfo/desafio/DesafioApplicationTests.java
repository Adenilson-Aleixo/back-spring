package br.inf.datainfo.desafio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

@TestPropertySource("classpath:application-test.properties")
public class DesafioApplicationTests {

	@Test
	public void contextLoads() {
	}

}
