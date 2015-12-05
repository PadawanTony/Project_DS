package supermarket_problem;

/**
 * Created by Antony on 12/5/2015.
 */

    public class MyQueueException extends Exception {

        public MyQueueException(String string, Throwable throwable, boolean b,
                              boolean b1) {
            super("MyQueueException: " + string, throwable, b, b1);
        }

        public MyQueueException(Throwable throwable) {
            super(throwable);
        }

        public MyQueueException(String string, Throwable throwable) {
            super("MyQueueException: " + string, throwable);
        }

        public MyQueueException(String string) {
            super("MyQueueException: " + string);
        }

        public MyQueueException() {
            super();
        }
    }
