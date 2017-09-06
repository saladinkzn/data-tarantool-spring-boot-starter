package ru.shadam.docker;

import com.palantir.docker.compose.execution.DockerCompose;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author sala
 */
public class DockerComposeBean implements InitializingBean, DisposableBean {
    private DockerCompose dockerCompose;

    public DockerComposeBean(DockerCompose dockerCompose) {
        this.dockerCompose = dockerCompose;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        dockerCompose.up();
    }

    @Override
    public void destroy() throws Exception {
        dockerCompose.down();
    }
}
