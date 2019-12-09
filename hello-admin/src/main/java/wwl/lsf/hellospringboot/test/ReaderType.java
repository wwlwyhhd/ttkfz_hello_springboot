package wwl.lsf.hellospringboot.test;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor()
@Getter
public enum ReaderType {
  //客户
  CUSTOMER("anonymous", "name"),
  //员工
  EMPLOYEE("employee", "name"),
  //匿名用户
  ANONYMOUS("anonymous", "name");
  @Getter
  private String value;
  @Getter
  private String name;

}