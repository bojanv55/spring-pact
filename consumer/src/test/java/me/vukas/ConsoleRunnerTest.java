package me.vukas;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.REMOTE,
    ids = "Some Consumer:Producer API",
    repositoryRoot = "pact://http://10.10.121.199:32817")
public class ConsoleRunnerTest {
  @StubRunnerPort("Producer API")
  int producerPort;

  @Test
  public void shouldReturnSampleDto(){
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response =
        restTemplate.getForEntity("http://localhost:"+producerPort+"/list/bojan", String.class);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
  }
}
