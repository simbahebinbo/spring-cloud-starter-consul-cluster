package org.springframework.cloud.consul.cluster;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class NodeModeEnumTest {

  @Test
  public void testFindByValue() {
    Assertions.assertEquals(NodeModeEnum.ALL, NodeModeEnum.findByValue("all"));
    Assertions.assertEquals(NodeModeEnum.CLIENT, NodeModeEnum.findByValue("client"));
    Assertions.assertEquals(NodeModeEnum.SERVER, NodeModeEnum.findByValue("server"));
  }

  @Test
  public void testFindByCode() {
    Assertions.assertEquals(NodeModeEnum.ALL, NodeModeEnum.findByCode(0));
    Assertions.assertEquals(NodeModeEnum.CLIENT, NodeModeEnum.findByCode(1));
    Assertions.assertEquals(NodeModeEnum.SERVER, NodeModeEnum.findByCode(2));
  }
}
