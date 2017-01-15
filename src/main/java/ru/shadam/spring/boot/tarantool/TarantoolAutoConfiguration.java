package ru.shadam.spring.boot.tarantool;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tarantool.*;
import ru.shadam.tarantool.core.SimpleSocketChannelProvider;

import java.util.List;

/**
 * @author sala
 */
@Configuration
@ConditionalOnClass({TarantoolClientImpl.class})
@EnableConfigurationProperties(TarantoolProperties.class)
public class TarantoolAutoConfiguration {

    @Configuration
    protected static class TarantoolConfiguration {
        private final TarantoolProperties tarantoolProperties;

        public TarantoolConfiguration(TarantoolProperties tarantoolProperties) {
            this.tarantoolProperties = tarantoolProperties;
        }

        @Bean
        @ConditionalOnMissingBean(name = "tarantoolSyncOps")
        public TarantoolClientOps<Integer, Object, Object, List> tarantoolSyncOps(
            TarantoolClient tarantoolClient
        ) {
            return tarantoolClient.syncOps();
        }

        @Bean(destroyMethod = "close")
        @ConditionalOnMissingBean(name = "tarantoolClient")
        public TarantoolClient tarantoolClient(
            SocketChannelProvider socketChannelProvider,
            TarantoolClientConfig config
        ) {
            return new TarantoolClientImpl(socketChannelProvider, config);
        }

        @Bean
        @ConditionalOnMissingBean(name = "tarantoolClientConfig")
        public TarantoolClientConfig tarantoolClientConfig() {
            final TarantoolClientConfig config = new TarantoolClientConfig();
            config.username = tarantoolProperties.getUsername();
            config.password = tarantoolProperties.getPassword();
            return config;
        }

        @Bean
        @ConditionalOnMissingBean(name = "socketChannelProvider")
        public SocketChannelProvider socketChannelProvider() {
            return new SimpleSocketChannelProvider(tarantoolProperties.getHost(), tarantoolProperties.getPort());
        }
    }
}
