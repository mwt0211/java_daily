package com.tansun.Config;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/5 14:25
 */
@Configuration
public class XMemcachedConfig {
    @Autowired
    private XMemcachedProperties xMemcachedProperties;
    @Bean
    public MemcachedClient GetMemcachedClient() throws IOException {
        MemcachedClientBuilder memcachedClientBuilder=new XMemcachedClientBuilder(xMemcachedProperties.getHost());
        MemcachedClient memcachedClient = memcachedClientBuilder.build();
        return memcachedClient;
    }
}
