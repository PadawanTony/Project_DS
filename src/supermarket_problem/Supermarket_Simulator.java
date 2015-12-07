package supermarket_problem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Antony on 12/5/2015.
 */
public class Supermarket_Simulator {

    /** Initialize Variables **/
    static Scanner in = new Scanner(System.in);
    static ArrayList<Customer> newCustomerList = new ArrayList<>(); // new customers to be added
    static int numberOfCounters; // number of supermarket itemCounterList
    static ArrayList<MyQueue<Customer>> theList = new ArrayList<>(); // a list with all queues of all itemCounterList
    static ArrayList<Integer> itemCounterList; // total amount of items for each queue - ex: queue_0 has itemCounterList.get(0) amount of items in total to be processed
    static int countAdders=0; // how many times we added new customers to the queues
    static int totalItemsInAllQueues;

    public static void main(String[] args) throws MyQueueException {

        /** Initialize supermarket counters with random amount of customers **/
        System.out.println("How many itemCounterList?");
        numberOfCounters = in.nextInt();
        /* Create All the Queues */
        for (int i = 0; i < numberOfCounters; i++) {
            theList.add(new MyQueue<Customer>());
            int z = (int) (Math.random() * 10);
            System.out.println("Queue " + theList.get(i).getId() + " will have " + z +" customers");
            for (int y = 0; y < z; y++) {
                theList.get(i).push(new Customer());
            }
        }

        /** Display all queues **/
        System.out.println();
        System.out.println("|-------------------    Initialize Queues    -------------------|");
        for (MyQueue q : theList) {
            System.out.println(q.toString());
        }

        addNewCustomers();

        /** Display all queues **/
        System.out.println();
        System.out.println("|-------------------    Updated Queues    ---------------------|");
        for (MyQueue q : theList) {
            System.out.println(q.toString());
        }

        /** Calculate amount of all items in all queues **/
        totalItemsInAllQueues = 0;
        for (MyQueue q : theList) {
            for (int i=0; i<q.size(); i++) {
                Customer c = (Customer) q.peek(i);
                totalItemsInAllQueues += c.getNumberOfItems();
            }
        }
//        System.out.println("totalItems: " + totalItemsInAllQueues);


        while (!in.next().equals("q") && totalItemsInAllQueues!=0) { // Finish program if there are no more customers

            System.out.println("/****************************************************************************************/");

            /**
             *  Remove the customers in the front (if they should be removed)
             *      and update the new ones that come in the front
             */
            for (int i = 0; i < theList.size(); i++) {
                if (!theList.get(i).isEmpty()) {
                    int newItems = theList.get(i).peek().getNumberOfItems() - 6; // The items that 1st customer will have after 1 minute
                    if (newItems == 0) { // If he doesn't have any, remove him
                        System.out.println("Customer with ID " + theList.get(i).peek().getId() + " was removed from queue " + theList.get(i).getId() );
                        theList.get(i).pop();
//                        System.out.println("Inside if");
                    } else if (newItems > 0) { // If he has more than 6 items in the beginning, then reduce hs items by 6
                        theList.get(i).peek().setNumberOfItems(newItems);
//                        System.out.println("Inside else if");
                    } else {
                        while (newItems < 0) { // if he has less than 6 items in the beginning, then remove him and update the items of the 2nd customer (because it took less than 1min to process the 1st customer so we started processing the 2nd)
                            System.out.println("Customer with ID " + theList.get(i).peek().getId() + " was removed from queue " + theList.get(i).getId());
                            theList.get(i).pop();
                            if (!theList.get(i).isEmpty()) { //if there are more customers after the one processed
                                theList.get(i).peek().setNumberOfItems(theList.get(i).peek().getNumberOfItems() - Math.abs(newItems)); // update number of remaining items
                                newItems = theList.get(i).peek().getNumberOfItems();
                                if (newItems == 0) {
                                    System.out.println("Customer with ID " + theList.get(i).peek().getId() + " was removed from queue " + theList.get(i).getId());
                                    theList.get(i).pop();
                                }
//                                System.out.println("Inside else");
                            } else { // if there are no customers after the one processed
                                newItems = 0;
                            }
                        }
//                        System.out.println("Inside else but not while");
                    }
                }

            }// end for

//            /*** DEBUG ***/
//             /* Display all queues */
//            System.out.println();
//            System.out.println("/**** REMOVED FRONTLINERS ****/");
//            for (MyQueue q : theList) {
//                System.out.println(q.toString());
//            }

            /** If we have had more than 10 influxes of new customers **/
            if (countAdders < 10) addNewCustomers();

//             /** Display all queues **/
//            System.out.println();
//            System.out.println("/**** ADDED NEW CUSTOMERS ****/");
//            for (MyQueue q : theList) {
//                System.out.println(q.toString());
//            }

             /** Display all queues **/
            System.out.println();
            System.out.println("|------------------    UPDATED QUEUES    -------------------|");
            for (MyQueue q : theList) {
                System.out.println(q.toString());
            }

            /** Calculate new amount of all items in all queues **/
            totalItemsInAllQueues = 0;
            for (MyQueue q : theList) {
                for (int i=0; i<q.size(); i++) {
                    Customer c = (Customer) q.peek(i);
                    totalItemsInAllQueues += c.getNumberOfItems();
                }
            }
            System.out.println("totalItems: " + totalItemsInAllQueues);

        } //end while
    }

    /**
     * This method adds a new random amount of customers (from 0 to 5)
     *      to the queues. Each time the new customer decides to join
     *      the quickest queue (the queue with the list amount of items
     *      to be processed.
     */
    public static void addNewCustomers() {

        /** Clear the list of previous values **/
        newCustomerList.clear();
//        System.out.println("\n\n\n  newCustomerList after CLEAR: " + newCustomerList.toString());

        /** Create new random amount of customers (from 0 to 5) **/
        int x = (int) (Math.random()*6);   // OR  int x = (int) Math.abs((Math.random()*10)-4);
        for (int i = 0; i < x; i++) {
            newCustomerList.add(new Customer());
        }

        System.out.println("\n(New Customers to be added: " + newCustomerList.toString() + ", total: " + x + ")");

        /** Find the total numberOfItems per queue **/
        itemCounterList = new ArrayList<>();
        for (int i = 0; i < theList.size(); i++) {
            itemCounterList.add(theList.get(i).getTotalItems());
        }

        for (Customer c : newCustomerList) {
            /** Find counter with least numberOfItems **/
            for (int i = 0; i < theList.size(); i++) {
                itemCounterList.remove(i);
                itemCounterList.add(i, theList.get(i).getTotalItems());
            }
            int min = 0;
            for (int i = 0; i < itemCounterList.size(); i++) {
                if (itemCounterList.get(min) > itemCounterList.get(i)) min = i;
            }

            /** Add customer in the quickest counter **/
            theList.get(min).push(c);
            try {
                System.out.println("Customer with id " + theList.get(min).peek(theList.get(min).size()-1).getId() + " added to queue " + theList.get(min).getId() );
            } catch (MyQueueException e) {
                e.getMessage();
            }
        }

        /** Increase the total amount of influxes of new customers so far **/
        countAdders++;
    }

}