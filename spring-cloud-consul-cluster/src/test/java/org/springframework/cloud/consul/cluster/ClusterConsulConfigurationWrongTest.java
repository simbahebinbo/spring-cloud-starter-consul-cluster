package org.springframework.cloud.consul.cluster;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@Slf4j
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ClusterConsulConfigurationWrongTest {

  @Test
  public void testEmpty() {
    Assertions.assertThrows(RuntimeException.class, () -> {
      String nodes = "";
      ClusterConsulConfiguration config = new ClusterConsulConfiguration();
      config.setNodes(nodes);
      config.init();
    });
  }

  @Test
  public void testNull() {
    Assertions.assertThrows(RuntimeException.class, () -> {
      String nodes = null;
      ClusterConsulConfiguration config = new ClusterConsulConfiguration();
      config.setNodes(nodes);
      config.init();
    });
  }

  @Test
  public void testNone() {
    Assertions.assertThrows(RuntimeException.class, () -> {
      String nodes = ",";
      ClusterConsulConfiguration config = new ClusterConsulConfiguration();
      config.setNodes(nodes);
      config.init();
    });
  }
}


