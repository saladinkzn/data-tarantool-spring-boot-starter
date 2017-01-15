package ru.shadam.spring.boot.tarantool;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.shadam.tarantool.repository.configuration.EnableTarantoolRepositories;
import ru.shadam.tarantool.repository.support.TarantoolRepositoryFactoryBean;

/**
 * @author sala
 */
@Configuration
@ConditionalOnClass({EnableTarantoolRepositories.class})
@ConditionalOnProperty(prefix = "ru.shadam.spring.data.tarantool.repositories", name = "enabled", havingValue = "true", matchIfMissing = true)
@ConditionalOnMissingBean(TarantoolRepositoryFactoryBean.class)
@Import(TarantoolRepositoriesAutoConfigureRegistrar.class)
@AutoConfigureAfter(TarantoolAutoConfiguration.class)
public class TarantoolRepositoriesAutoConfiguration {
}
