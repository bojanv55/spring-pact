package me.vukas;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@Testcontainers
public class DemoTest {

    @Container
    public static GenericContainer pact =
            new GenericContainer<>("pactfoundation/pact-broker")
                    .withExposedPorts(9292)
                    .withEnv("PACT_BROKER_DATABASE_ADAPTER", "sqlite")
                    .withEnv("PACT_BROKER_DATABASE_NAME", "pact_broker.sqlite")
            .withEnv("PACT_BROKER_DISABLE_SSL_VERIFICATION", "true")
            .withEnv("PACT_BROKER_WEBHOOK_SCHEME_WHITELIST", "http")
            .withReuse(true);

    @BeforeAll
    public static void setUp(){
        //pact.start();
        //port with this shit
        System.out.println(pact.getFirstMappedPort());
    }

    @Test
    public void demoTest(){
        assertThat(true).isTrue();
        assertThat(pact.getExposedPorts()).contains(9292);
    }

}
