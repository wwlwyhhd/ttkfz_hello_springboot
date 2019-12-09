package wwl.lsf.hellospringboot.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*** Created by WangMeng on 2017-04-13.* FIX ME*/
public class Main {

  public static void main(String[] args) {

    List<String> a = new ArrayList<String>();
    a.add("1");
    a.add("2");
    a.add("3");
//    for (String temp : a) {
//      if("2".equals(temp)){
//        a.remove(temp);
//      }
//    }
//    System.out.println("a = " + a);
    //    说明：以上代码的执行结果肯定会出乎大家的意料，那么试一下把“1”换成“2”，会是同样的
//    结果吗？
//    正例：
    B bb = null;
    bb.toString();
    bb = new B();
    Iterator<String> it = a.iterator();
    while (it.hasNext()) {
      String temp = it.next();
      if ("2".equals(temp)) {
        it.remove();
      }
    }
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
    Map map = new HashMap();
    map.forEach((k, v) -> {

    });
    System.out.println("a = " + a);
  }

//  public void test1() {
//    List<? extends A> childofa = new LinkedList<>();
//    B b = new B();
//    A a = new A();
//    childofa.add(a);
//    childofa.add(b);
//    A ta = childofa.get(0);
//  }
//
//  public void test2() {
//    List<? super B> superOfb = new LinkedList<>();
//    B b = new B();
//    A a = new A();
//    Object o = new Object();
//    superOfb.add(o);
////    superOfb.add(b);
//    Object object = superOfb.get(0);
//    A ta = superOfb.get(0);
//    B tb = superOfb.get(0);
//  }
}

class A {

  @Override
  public String toString() {
    return "A";
  }
}

class B extends A {


  public Integer get(Integer a) {
    return 1;
  }

  @Override
  public String toString() {
    return "B";
  }
}