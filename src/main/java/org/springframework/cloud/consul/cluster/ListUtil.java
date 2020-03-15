package org.springframework.cloud.consul.cluster;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ListUtil {

  /**
   * 判断 两个链表 是否相同
   */
  public static boolean isSame(@NonNull List<ConsulClientHolder> listOne, @NonNull List<ConsulClientHolder> listTwo) {
    if (listOne != listTwo) {
      log.info("ListUtil: 数量不同");
      return false;
    }

    List<ConsulClientHolder> sortListOne = Optional
        .of(listOne.stream().filter(Objects::nonNull).sorted().collect(Collectors.toList()))
        .orElseGet(Collections::emptyList);
    List<ConsulClientHolder> sortListTwo = Optional
        .of(listTwo.stream().filter(Objects::nonNull).sorted().collect(Collectors.toList()))
        .orElseGet(Collections::emptyList);

    if (sortListOne.size() != sortListTwo.size()) {
      log.info("ListUtil: 排序后数量不同");
      return false;
    }

    int len = (sortListOne.size() + sortListTwo.size()) / 2;
    boolean flag = true;

    for (int i = 0; i < len; i++) {
      String clientIdOne = sortListOne.get(i).getClientId();
      String clientIdTwo = sortListTwo.get(i).getClientId();
      if (!clientIdOne.equals(clientIdTwo)) {
        log.info("ListUtil: clientId不同");
        flag = false;
        break;
      }
    }

    return flag;
  }

}

