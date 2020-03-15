package org.springframework.cloud.consul.cluster;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BadConsulAgentException extends RuntimeException {

  public BadConsulAgentException(String message) {
    super(message);
  }
}
