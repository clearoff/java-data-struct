public class Test1 {
    private static final int _1MB = 1024 * 1024;

    public static void invoke(Object obj1, Object ... args) {
        System.out.println("This is Object invoke ...");
    }

    public static void invoke(String obj1, Object obj2, Object ... args) {
        System.out.println("This is String invoke ...");
    }

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testAllocation();
        System.out.println("Hello, GC !");
    }
}
