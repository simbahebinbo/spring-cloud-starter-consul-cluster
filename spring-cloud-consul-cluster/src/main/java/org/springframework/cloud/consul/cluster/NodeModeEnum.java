package org.springframework.cloud.consul.cluster;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum NodeModeEnum {
  ALL(0, "all"),
  CLIENT(1, "client"),
  SERVER(2, "server"),
  ;

  private final Integer code;

  private final String value;

  public static NodeModeEnum findByValue(String value) {
    for (NodeModeEnum e : NodeModeEnum.values()) {
      if (e.getValue().equals(value)) {
        return e;
      }
    }
    return null;
  }

  public static NodeModeEnum findByCode(Integer code) {
    for (NodeModeEnum e : NodeModeEnum.values()) {
      if (e.getCode().equals(code)) {
        return e;
      }
    }
    return null;
  }
}
