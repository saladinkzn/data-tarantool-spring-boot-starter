package ru.shadam.spring.boot.tarantool;

import com.palantir.docker.compose.configuration.DockerComposeFiles;
import com.palantir.docker.compose.connection.DockerMachine;
import com.palantir.docker.compose.execution.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import ru.shadam.docker.DockerComposeBean;

/**
 * @author sala
 */
@SpringBootTest(classes = TarantoolAutoConfigurationTest.TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TarantoolAutoConfigurationTest {
    @Autowired
    private TestEntityRepository testEntityRepository;

    @Test
    public void testContextStarted() {
        Assert.notNull(testEntityRepository);
    }

    @ImportAutoConfiguration({TarantoolAutoConfiguration.class, TarantoolRepositoriesAutoConfiguration.class})
    @TestPropertySource(properties = {
            "ru.shadam.tarantool.username=test",
            "ru.shadam.tarnatool.password=test"
    })
    @Configuration
    public static class TestConfiguration {
        @Bean
        public DockerComposeBean dockerComposeBean() {
            DockerMachine dockerMachine = DockerMachine.localMachine().build();
            
            ImmutableDockerComposeExecutable executable = DockerComposeExecutable.builder()
                    .dockerConfiguration(dockerMachine)
                    .dockerComposeFiles(DockerComposeFiles.from("src/test/resources/docker/docker-compose.yml"))
                    .build();

            DefaultDockerCompose dockerCompose = new DefaultDockerCompose(executable, dockerMachine);

            return new DockerComposeBean(new RetryingDockerCompose(3, dockerCompose));
        }
    }
}
