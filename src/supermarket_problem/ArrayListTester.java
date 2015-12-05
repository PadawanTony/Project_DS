package supermarket_problem;

import java.util.ArrayList;

/**
 * Created by Antony on 12/5/2015.
 */
public class ArrayListTester {

    public static void main(String[] args){

        ArrayList<Integer> list = new ArrayList<>();

        list.add(55);
        list.add(66);
        list.add(77);
        list.add(88);

        System.out.println(list.toString());

        list.add(1, 66666);

        System.out.println(list.toString());
    }
}
