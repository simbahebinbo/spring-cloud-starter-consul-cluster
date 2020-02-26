package org.springframework.cloud.consul.cluster;

import com.ecwid.consul.v1.ConsulClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.commons.util.InetUtils.HostInfo;
import org.springframework.cloud.commons.util.UtilAutoConfiguration;
import org.springframework.cloud.consul.ConditionalOnConsulEnabled;
import org.springframework.cloud.consul.ConsulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 默认的ConsulClient启动配置,
 *
 * 用于覆盖@Import(ConsulAutoConfiguration.class)注册的ConsulClient
 */

@Slf4j
@Configuration
@ConditionalOnConsulEnabled
@EnableConfigurationProperties
@Import(UtilAutoConfiguration.class)
public class ClusterConsulBootstrapConfiguration {

  @Autowired
  private InetUtils inetUtils;

  @Autowired
  private ClusterConsulConfiguration clusterConsulConfiguration;

  @Bean
  @ConditionalOnMissingBean
  public ConsulProperties consulProperties() {
    ClusterConsulProperties consulProperties = new ClusterConsulProperties();
    HostInfo hostInfo = inetUtils.findFirstNonLoopbackHostInfo();
    consulProperties.setClusterClientKey(hostInfo.getIpAddress());
    consulProperties.setNodeMode(clusterConsulConfiguration.getNodeMode());
    return consulProperties;
  }

  @Bean
  @ConditionalOnMissingBean
  public ConsulClient consulClient(ConsulProperties consulProperties) {
    ConsulClient consulClient = createClusterConsulClient(
        (ClusterConsulProperties) consulProperties);

    log.info("Default ConsulClient created : {}, with config properties : {}",
        consulClient, consulProperties);
    return consulClient;
  }

  protected ConsulClient createClusterConsulClient(
      ClusterConsulProperties consulProperties) {
    return new ClusterConsulClient(consulProperties);
  }
}
