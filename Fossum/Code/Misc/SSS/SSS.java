public class SSS {

    public static Integer i = new Integer(3);

    public static void clobber(Integer j) {
        j = 42;
    }

    public static void main(String [] args) {
        clobber(i);
        System.out.println(i);
    }

}

