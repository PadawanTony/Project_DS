package supermarket_problem;

/**
 * Created by Antony on 12/5/2015.
 */
public class MyQueueTester {

    public static void main(String[] args) {
        MyQueue<Customer> q1 = new MyQueue<>();
        Customer c1 = new Customer();

        q1.push(c1);

        System.out.println(q1.toString());
    }
}
