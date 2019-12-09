package wwl.lsf.hellospringboot.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class subList玩玩 {

  public static void main(String[] args) {
    List a = new ArrayList<>();
    a.add("1");
    a.add("2");
    a.add("1");
    a.add("1");
    a.add("1");
//    a.remove()

    System.out.println(Objects.equals(null,null));

    List<String> list = new ArrayList<String>(2);
    list.add("guan");
    list.add("bao");
    String[] array = new String[list.size()];
    String[] strings = list.toArray(array);
    Object[] objects = list.toArray();
  }
}