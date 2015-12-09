package backpack_problem;

import java.text.NumberFormat;
import java.util.*;

public class Recursive {

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

        System.out.println("Give me the capacity of the bag: ");
        int bagCapacity = in.nextInt();

        System.out.println("Now you will give me all the weights that you want me to check.");
        int x;
        do {
            System.out.println("Give me a weight: ");
            System.out.println("(Click '0' to stop)");
            x = in.nextInt();
            if (x > 0) weights.add(x);
        } while (x != 0);

        ArrayList<Integer> result = backpack(bagCapacity, 0, pack, weights);
        System.out.println("Your backpack: " + result.toString());

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

    public static ArrayList<Integer> backpack(int bagCapacity, int index, ArrayList<Integer> pack, ArrayList<Integer> weights) {

        if ((getTotalWeight(pack) == bagCapacity) || (index == weights.size())) {
            //This is not needed!
        } else {
            if ((getTotalWeight(pack) + weights.get(index)) > bagCapacity) {
                backpack(bagCapacity, index + 1, pack, weights);
            } else {
                pack.add(weights.get(index));
                backpack(bagCapacity, index + 1, pack, weights);
            }
        }

        return pack;
    }

}


