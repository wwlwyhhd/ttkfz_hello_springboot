package wwl.lsf.hellospringboot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Hell implements helloService {

  private String name;
  @Override
  public void add() {

    System.out.println(this);
    int i = 0 / 0;
  }
}
