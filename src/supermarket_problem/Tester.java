package supermarket_problem;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 * Created by Antony on 12/5/2015.
 */
public class Tester {

    public static void main(String[] args) throws MyQueueException{

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

         /* Display all queues */
        for (MyQueue q : theList) {
            System.out.println(q.toString());
        }

        /* Find the total numberOfItems per queue */
        ArrayList<Integer> counters = new ArrayList<>();
        for (int i=0; i<theList.size(); i++) {
            counters.add(theList.get(i).getTotalItems());
        }

        for (Customer c : newCustomerList) {
            /* Find counter with least numberOfItems */
            for (int i=0; i<theList.size(); i++) {
                counters.remove(i);
                counters.add(i, theList.get(i).getTotalItems());
            }
            int min = 0;
            for (int i=0; i<counters.size(); i++){
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
}