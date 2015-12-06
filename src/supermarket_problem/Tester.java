package supermarket_problem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Antony on 12/5/2015.
 */
public class Tester {

    static Scanner in = new Scanner(System.in);
    static ArrayList<Customer> newCustomerList = new ArrayList<>();
    static int numberOfCounters;
    static ArrayList<MyQueue<Customer>> theList = new ArrayList<>();
    static ArrayList<Integer> counters;

    public static void main(String[] args) throws MyQueueException {

        System.out.println("How many counters?");
        numberOfCounters = in.nextInt();
        /* Create All the Queues */
        for (int i = 0; i < numberOfCounters; i++) {
            theList.add(new MyQueue<Customer>());
            int z = (int) (Math.random() * 10);
            System.out.println("z " + z);
            for (int y = 0; y < z; y++) {
                theList.get(i).push(new Customer());
            }
        }

        addNewCustomers();

        /* Display all queues */
        System.out.println();
        System.out.println("/**************************************************/");
        for (MyQueue q : theList) {
            System.out.println(q.toString());
        }

        while (!in.next().equals("q")) {

            for (int i = 0; i < theList.size(); i++) {
                if (!theList.get(i).isEmpty()) {
                    int newItems = theList.get(i).peek().getNumberOfItems() - 6;
                    if (newItems == 0) {
                        theList.get(i).pop();
                        System.out.println("Inside if");
                    } else if (newItems > 0) {
                        theList.get(i).peek().setNumberOfItems(newItems);
                        System.out.println("Inside else if");
                    } else {
                        while (newItems < 0) {
                            theList.get(i).pop();
                            if (!theList.get(i).isEmpty()) {
                                theList.get(i).peek().setNumberOfItems(theList.get(i).peek().getNumberOfItems() - Math.abs(newItems));
                                newItems = theList.get(i).peek().getNumberOfItems();
                                if (newItems == 0) theList.get(i).pop();
                                System.out.println("Inside else");
                            } else {
                                newItems = 0;
                            }
                        }
                        System.out.println("Inside else but not while");
                    }
                } else { // if queue is empty

                }


            }// end for
            /*** DEBUG ***/
             /* Display all queues */
            System.out.println();
            System.out.println("/*********REMOVE*****************************************/");
            for (MyQueue q : theList) {
                System.out.println(q.toString());
            }

            addNewCustomers();

             /* Display all queues */
            System.out.println();
            System.out.println("/*********ADDED*****************************************/");
            for (MyQueue q : theList) {
                System.out.println(q.toString());
            }

        } //end while


    }

    public static void addNewCustomers() {

        /* Create random amount of new customers */
        newCustomerList.clear();
        System.out.println(newCustomerList.toString());

        int x = (int) Math.abs((Math.random()*10)-4);
        for (int i = 0; i < x; i++) {
            newCustomerList.add(new Customer());
        }

        System.out.println(newCustomerList.toString() + " " + x);

        /* Find the total numberOfItems per queue */
        counters = new ArrayList<>();
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
    }
}