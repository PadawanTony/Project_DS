package supermarket_problem;

import java.util.ArrayList;

/**
 * Created by Antony on 12/5/2015.
 */
public class MyQueue<E>{

    ArrayList<E> list;

    public MyQueue(){
        list = new ArrayList<>();
    }

    public void push(E x){
        list.add(x);
    }

    public void push(E x, int index){
        list.add(index, x);
    }

    public E pop()throws MyQueueException{
        if (list.size()==0){
            throw new MyQueueException("Queue is empty.");
        } else {
            E toReturn = list.get(0);
            list.remove(0);

            return toReturn;
        }
    }

//    public E peek()throws MyQueueException{
//        if (list.size()==0){
//            throw new MyQueueException("Queue is empty.");
//        } else {
//            E toReturn = list.get(0);
//
//            return toReturn;
//        }
//    }

    public E peek(){
        if (list.size()==0){
            return null;
        } else {
            E toReturn = list.get(0);
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
        String toReturn = "\nQueue\n";
        toReturn += "------------\n";
        for (E c : list) {
            toReturn += " " +counter + ")" + c.toString();
            counter++;
        }

        return toReturn;
    }

}
