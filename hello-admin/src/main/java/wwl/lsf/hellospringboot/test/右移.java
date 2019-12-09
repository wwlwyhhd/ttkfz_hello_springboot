package wwl.lsf.hellospringboot.test;

public class 右移 {

  public static void main(String[] args) {

    int a = 100;

    long l = System.currentTimeMillis();

    for (int i = 0; i < 1000000000; i++) {
//      a <<= 1;// 向高位移动一位，相当于乘以 2 的1次方
//      a >>= 1; // 向低位移动一位，相当于 除以 2的 1次方

      a *= 2;// 向高位移动一位，相当于乘以 2 的1次方
      a /= 2; // 向低位移动一位，相当于 除以 2的 1次方
    }
    System.out.println(a *= 2);
    System.out.println(a /= 2);
    System.out.println(System.currentTimeMillis() - l);

  }

}
