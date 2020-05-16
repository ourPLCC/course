public class EO {

    public static boolean even(int i) {
        if (i == 0)
            return true;
        return odd(i-1);
    }

    public static boolean odd(int i) {
        if (i == 0)
            return false;
        return even(i-1);
    }

    public static void main(String [] args) {
        for (int i=0 ; i<=LIMIT ; i++)
             System.out.println(i + " is " + (even(i) ? "even" : "odd"));
    }

    public static final int LIMIT = 10;

}
