package se.ydb.exampleapiservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ExampleApiServiceApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private HelloController controller;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contexLoads() {
		assertThat(controller).isNotNull();
	}

	@Test
	public void greetingShouldReturnDefaultMessage() {
		String actual = this.restTemplate.getForObject("http://localhost:" + port + "/hello", String.class);

		assertThat(actual).contains("Greetings from Ola");
	}
}
