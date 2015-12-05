package supermarket_problem;

/**
 * Created by Antony on 12/5/2015.
 */
public class Customer implements Comparable{

    public int id;
    public static int counterID = 1;
    public int numberOfItems;

    public Customer(){
        this.id = this.counterID;
        this.counterID++;
        this.numberOfItems = (int) (Math.random()*10);
    }

    public int getId() {
        return id;
    }

    public static int getCounterID() {
        return counterID;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void setCounterID(int counterID) {
        Customer.counterID = counterID;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", numberOfItems=" + numberOfItems +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

}