public class A {

   public static void main(String [] args) {
      String [] sa = new String[10];
      sa[0] = "hello";
      sa[1] = "goodbye";
      for (String s : sa)
          System.out.println(s);
   }
}
