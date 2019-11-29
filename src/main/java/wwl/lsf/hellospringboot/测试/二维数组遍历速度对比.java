package wwl.lsf.hellospringboot.测试;

public class 二维数组遍历速度对比 {

  public static void main(String[] args) {

    long l = System.currentTimeMillis();
    Integer[][] arr = new Integer[10000][10000];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = j;
      }
    }
    long l2 = System.currentTimeMillis();
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[j][i] = j;
      }
    }
    long l1 = System.currentTimeMillis();
    System.out.println(l2-l);
    System.out.println(l1-l2);

  }
}
