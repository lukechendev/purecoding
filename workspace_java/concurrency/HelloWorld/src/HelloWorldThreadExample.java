public class HelloWorldThreadExample {
    private static String result = "";

    private static void hello() {
        delay(500);
        result = result.concat("Hello");
    }

    private static void world() {
        delay(600); // race condition, if no delay here, it will be WorldHello
        result = result.concat(" World");
    }

    private static void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread helloThread = new Thread(()->hello());
        Thread worldThread = new Thread(()->world());

        // Starting the thread
        helloThread.start();
        worldThread.start();

        helloThread.join();
        worldThread.join();
//        delay(2000); // you can also delay instead of join

        System.out.println("Result is : " + result);
    }
}
