//package org.springframework.cloud.consul.cluster;
//
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.annotation.DirtiesContext.ClassMode;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//
//@Slf4j
//@ExtendWith(SpringExtension.class)
//@ActiveProfiles({"cluster-consul-nodes-correct"})
//@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
//@SpringBootTest(
//    classes = {ClusterConsulConfiguration.class},
//    webEnvironment = SpringBootTest.WebEnvironment.NONE
//)
//@EnableConfigurationProperties
//public class ClusterConsulConfigurationCorrectTest {
//
//  @Autowired
//  private ClusterConsulConfiguration config;
//
//  @Test
//  @Disabled
//  public void testGetNodeMode() {
//    Assertions.assertEquals(NodeModeEnum.ALL, config.getNodeMode());
//  }
//
//  @Test
//  @Disabled
//  public void testGetClusterNodes() {
//    Assertions.assertEquals(2, config.getClusterNodes().size());
//  }
//}
//
