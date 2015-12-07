package supermarket_problem;

import java.util.ArrayList;

/**
 * Created by Antony on 12/5/2015.
 *
 * This class represent one supermarket queue.
 * It is implemented by using an ArrayList and
 *   it is a generic object :)
 */
public class MyQueue<E>{

    protected int id;
    protected static int counterID = 1;
    protected ArrayList<E> list;

    public MyQueue(){
        list = new ArrayList<>();
        this.id = MyQueue.counterID;
        counterID++;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    /**
     *  Add an object to the end of the list
     *  @param x the object to add
    */
    public void push(E x){
        list.add(x);
    }

    /**
     * Add an object to the specified index
     * and swift following objects to the right
     * @param x the object to add
     * @param index the index in which to add the object
    */
    public void push(E x, int index){
        list.add(index, x);
    }

    /**
     *  Return and remove the first object (the head)
     *  @return the removed (first) object
     */
    public E pop()throws MyQueueException{
        if (list.size()==0){
            throw new MyQueueException("Queue is empty.");
        } else {
            E toReturn = list.get(0);
            list.remove(0);

            return toReturn;
        }
    }

    /**
     *  Return but not remove the first object (the head)
     *  @return the first object
     */
    public E peek()throws MyQueueException{
        if (list.size()==0){
            throw new MyQueueException("Queue is empty.");
        } else {
            E toReturn = list.get(0);

            return toReturn;
        }
    }

    /**
     *  Return but not remove the object in the specified index
     *  @param index of the object we want to retrieve
     *  @return the desired object
     */
    public E peek(int index)throws MyQueueException{
        if (list.size()==0){
            throw new MyQueueException("Queue is empty.");
        } else {
            E toReturn = list.get(index);

            return toReturn;
        }
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        if ( list.size() == 0 )return true;
        else return false;
    }

    public E get(int index){
        return list.get(index);
    }

    /**
     * Retrieve the total items of all the customers in
     *      the queue
     * @return total amount of items of all customers
     */
    public int getTotalItems(){
        int counter = 0;
        for (int i=0; i<list.size(); i++) {
            Customer tempC = (Customer) list.get(i);
            counter += tempC.getNumberOfItems();
        }

        return counter;
    }

    @Override
    public String toString() {
        int counter = 1;
        String toReturn = "\nQueue " + this.getId() + "\n";
        toReturn += "------------\n";
        for (E c : list) {
            toReturn += " " +counter + ")" + c.toString();
            counter++;
        }

        return toReturn;
    }

}
