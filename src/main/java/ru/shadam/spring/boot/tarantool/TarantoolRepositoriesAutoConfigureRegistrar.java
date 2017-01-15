package ru.shadam.spring.boot.tarantool;

import org.springframework.boot.autoconfigure.data.AbstractRepositoryConfigurationSourceSupport;
import org.springframework.data.repository.config.RepositoryConfigurationExtension;
import ru.shadam.tarantool.repository.configuration.EnableTarantoolRepositories;
import ru.shadam.tarantool.repository.configuration.TarantoolRepositoryConfigurationExtension;

import java.lang.annotation.Annotation;

/**
 * @author sala
 */
public class TarantoolRepositoriesAutoConfigureRegistrar extends AbstractRepositoryConfigurationSourceSupport {
    @Override
    protected Class<? extends Annotation> getAnnotation() {
        return EnableTarantoolRepositories.class;
    }

    @Override
    protected Class<?> getConfiguration() {
        return EnableTarantoolRepositoriesConfiguration.class;
    }

    @Override
    protected RepositoryConfigurationExtension getRepositoryConfigurationExtension() {
        return new TarantoolRepositoryConfigurationExtension();
    }

    @EnableTarantoolRepositories
    private static class EnableTarantoolRepositoriesConfiguration {

    }
}
