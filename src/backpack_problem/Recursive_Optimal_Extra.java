package backpack_problem;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Recursive_Optimal_Extra {

    static NumberFormat format = NumberFormat.getInstance();
    static Scanner in = new Scanner(System.in);
    static ArrayList<Integer> weights = new ArrayList<>();
    static ArrayList<Integer> pack = new ArrayList<>();

    public static void main(String[] args) {

        /** Calculate RunTime **/
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        long allocatedMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();


        int bagCapacity;
        do {
            System.out.println("Give me the capacity of the bag: ");
            while (!in.hasNextInt()) {
                System.out.println("That's not a number!");
                in.next(); // this is important! in.next() does not remove the \n!!!
            }
            bagCapacity = Integer.parseInt(in.next());
        } while (bagCapacity <= 0);


        System.out.println("Now you will give me all the weights that you want me to check.");
        int x;
        do {
            System.out.println("Give me a weight: ");
            System.out.println("(Click '0' to stop)");
            while (!in.hasNextInt()){
                System.out.println("That's not a number!");
                in.next();
            }
            x = Integer.parseInt(in.next());
            if (x > 0) weights.add(x);
        } while (x != 0);


        Collections.sort(weights, Collections.reverseOrder());
        pack = backpack(weights, bagCapacity);
        System.out.println("\nThe final optimal result: " + pack + " total weight: " + getTotalWeight(pack) + "\n");

        long maxMemoryFinal = runtime.maxMemory();
        long allocatedMemoryFinal = runtime.totalMemory();
        long freeMemoryFinal = runtime.freeMemory();

        System.out.println("free memory: " + format.format(freeMemory / 1024) + "\nallocated memory: " + format.format(allocatedMemory / 1024));
        System.out.println("max memory: " + format.format(maxMemory / 1024));
        System.out.println("===========================================================================");
        System.out.println("Final free memory: " + format.format(freeMemoryFinal / 1024) + "\nFinal allocated memory: " + format.format(allocatedMemoryFinal / 1024));
        System.out.println("Final max memory: " + format.format(maxMemoryFinal / 1024));
    }

    public static int getTotalWeight(ArrayList<Integer> pack) {
        int counter = 0;
        for (Integer item : pack) {
            counter += item;
        }

        return counter;
    }


    public static ArrayList<Integer> backpack(ArrayList<Integer> weights, int capacity) {

        System.out.println("Calling " + weights + ", " + capacity);//debug

        if (weights.size() == 1) {

            if (weights.get(0) > capacity) {
                weights.set(0, 0);
            }

            System.out.println("==========Result " + weights + ", " + weights.get(0));//debug
            return weights;

        } else {

            ArrayList<Integer> temp_weights = (ArrayList<Integer>) weights.clone();
            temp_weights.remove(0);

            if (weights.get(0) <= capacity) {

                int tempGetFirst = weights.get(0);
                ArrayList<Integer> left = backpack(temp_weights, capacity);
                ArrayList<Integer> took = backpack(temp_weights, capacity - tempGetFirst);
                took.add(tempGetFirst);

                if (took.get(0) == 0){
                    took.remove(0);
                }

                int leftSum = 0;
                int tookSum = 0;

                for (int i : left) {
                    leftSum += i;
                }

                for (int i : took) {
                    tookSum += i;
                }

                if (leftSum > tookSum) {

                    System.out.println("==========Result " + left + ", " + leftSum);//debug
                    return left;

                } else if (tookSum > leftSum){

                    System.out.println("==========Result " + took + ", " + tookSum);//debug
                    return took;

                } else {

                    if (left.size() > took.size()){

                        System.out.println("==========Result " + left + ", " + leftSum);//debug
                        return left;

                    } else {

                        System.out.println("==========Result " + took + ", " + tookSum);//debug
                        return took;

                    }

                }

            } else {

                ArrayList<Integer> left = backpack(temp_weights, capacity);

                int leftSum = 0;
                for (int i : left) {
                    leftSum += i;
                }

                System.out.println("==========Result " + left + ", " + leftSum);//debug
                return left;
            }

        }

    }

}


