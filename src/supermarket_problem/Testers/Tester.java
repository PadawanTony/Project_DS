package supermarket_problem.Testers;

import supermarket_problem.Customer;
import supermarket_problem.MyQueue;
import supermarket_problem.MyQueueException;
import supermarket_problem.customerService;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;

/**
 * Created by Antony on 12/5/2015.
 */
public class Tester {

    public static void main(String[] args) throws MyQueueException {

        Timer timer = new Timer();
        Scanner in = new Scanner(System.in);
        ArrayList<Customer> newCustomerList = new ArrayList<>();
        int numberOfCounters;
        ArrayList<MyQueue<Customer>> theList = new ArrayList<>();

        /* Create random amount of new customers */
        for (int i=0; i<5; i++) {
            newCustomerList.add(new Customer());
        }

        System.out.println("How many counters?");
        numberOfCounters = in.nextInt();
        /* Create All the Queues */
        for (int i=0; i<numberOfCounters; i++){
            theList.add(new MyQueue<Customer>());
            for (int y=0; y<(int) (Math.random()*10); y++) {
                theList.get(i).push(new Customer());
            }
        }


        while ( !in.nextLine().equals("k") ) {

         /* Display all queues */
            for (MyQueue q : theList) {
                System.out.println(q.toString());
            }

        /* Find the total numberOfItems per queue */
            ArrayList<Integer> counters = new ArrayList<>();
            for (int i = 0; i < theList.size(); i++) {
                counters.add(theList.get(i).getTotalItems());
            }

            for (Customer c : newCustomerList) {
            /* Find counter with least numberOfItems */
                for (int i = 0; i < theList.size(); i++) {
                    counters.remove(i);
                    counters.add(i, theList.get(i).getTotalItems());
                }
                int min = 0;
                for (int i = 0; i < counters.size(); i++) {
                    if (counters.get(min) > counters.get(i)) min = i;
                }

                // Add customer in the quickest counter
                theList.get(min).push(c);
            }


        /* Display all queues */
            System.out.println();
            System.out.println("/**************************************************/");
            for (MyQueue q : theList) {
                System.out.println(q.toString());
            }
        }


        /* Remove customer from line */
//        for (MyQueue q : theList) {
//            Customer c = (Customer) q.peek();
//            if (q.peek() != null)
//            timer.schedule(new customerService(q), 0, c.getTimeToLeave());
//        }

        for (int i=0; i<theList.size(); i++ ) {
            Customer c = (Customer) theList.get(i).peek();
            System.out.println("before if: " + c.getTimeToLeave());
            if (theList.get(i).peek() != null)
                System.out.println("after entering if: " + c.getTimeToLeave());
                timer.schedule(new customerService(theList.get(i)), 0, c.getTimeToLeave());
                System.out.println("after setting timer: " + + c.getTimeToLeave());
        }

//        /* Display all queues */
//        System.out.println();
//        System.out.println("/**************************************************/");
//        for (int i=0; i<theList.size(); i++) {
//            System.out.println(theList.get(i).toString());
//        }

    }
}