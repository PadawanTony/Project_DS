package supermarket_problem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Antony on 12/5/2015.
 *
 * This class was created for fun. It is
 *      outside the scope of the project and
 *      it is neither optimized nor tested.
 *
 * In this program you add the customers by pressing
 *      any key (except for 'k'). When you are done
 *      adding customers, press 'k' and the program
 *      will start removing them taking as many seconds
 *      for each one as many items they have.
 */
public class RunWithTime_Extrra {

    public static void main(String[] args) throws MyQueueException {

        Scanner in = new Scanner(System.in);
        ArrayList<Customer> newCustomerList = new ArrayList<>();
        int numberOfCounters;
        ArrayList<MyQueue<Customer>> theList = new ArrayList<>();

        /* Create random amount of new customers */
        for (int i = 0; i < 5; i++) {
            newCustomerList.add(new Customer());
        }

        System.out.println("How many counters?");
        numberOfCounters = in.nextInt();
        /* Create All the Queues */
        for (int i = 0; i < numberOfCounters; i++) {
            theList.add(new MyQueue<Customer>());
            for (int y = 0; y < (int) (Math.random() * 10); y++) {
                theList.get(i).push(new Customer());
            }
        }


        while (!in.nextLine().equals("k")) {

//         /* Display all queues */
//            for (MyQueue q : theList) {
//                System.out.println(q.toString());
//            }

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


        ArrayList<Long> timesToPop = new ArrayList<>();
        /* Remove customer from line */
        for (MyQueue q : theList) {
            if (!q.isEmpty()) {
                Customer c = (Customer) q.peek();
                long timeToPop = System.currentTimeMillis() + (c.getNumberOfItems() * 1000);
                timesToPop.add(timeToPop);
            } else {
                timesToPop.add((long) 0);
            }
        }

        int counter = 1;
        long timeToPop;
        int x = timesToPop.size();
        while (counter != 0) {
            for (MyQueue q : theList) {
                if (!q.isEmpty()) {
                    for (int i = 0; i < x; i++) { // for every queue
                        if (System.currentTimeMillis() == timesToPop.get(i) ) {
                            System.out.println("\n\nNEXT POP FROM QUEUE " + (i + 1) );
//                            System.out.println(timesToPop.get(i) + " " + timesToPop.toString());
                            theList.get(i).pop();
                            timesToPop.remove(i);
                             /* Display all queues */
                            System.out.println();
                            System.out.println("/**************************************************/");
                            for (int u = 0; u < theList.size(); u++) {
                                System.out.println(theList.get(u).toString());
                            }
                            if (!theList.get(i).isEmpty()) {
                                Customer c = (Customer) theList.get(i).peek();
                                timeToPop = System.currentTimeMillis() + (c.getNumberOfItems() * 1000);
                                timesToPop.add(i, timeToPop);
                            } else {
                                timesToPop.add(i, (long) 0);
                            }
                        }
                    }
                }
            }

            counter = 0;
            for (MyQueue q : theList) {
                counter += q.size();
            }

        }




        /* Display all queues */
        System.out.println();
        System.out.println("/**************************************************/");
        for (int i = 0; i < theList.size(); i++) {
            System.out.println(theList.get(i).toString());
        }

    }
}