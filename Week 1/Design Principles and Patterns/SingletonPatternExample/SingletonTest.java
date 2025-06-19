public class SingletonTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Log 1");
        logger2.log("Log 2");

        if (logger1 == logger2) {
            System.out.println("Both log1 and log2 refer to same instance.");
        } else {
            System.out.println("Different instances exist. Singleton pattern failed.");
        }
    }
}
