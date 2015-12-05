package backpack_problem;

import java.util.*;

public class recursive {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        ArrayList<Integer> weights = new ArrayList<>();
        ArrayList<Integer> pack = new ArrayList<>();

        System.out.println("Give me the capacity of the bag: ");
        int bagCapacity = in.nextInt();

        System.out.println("Now you will give me all the weights that you want me to check.");
        int x;
        do {
            System.out.println("Give me a weight: ");
            System.out.println("(Click '0' to stop)");
            x = in.nextInt();
            if (x!=0) weights.add(x);
        } while (x!=0);

        ArrayList<Integer> result = backpack(bagCapacity, 0, pack, weights);
        System.out.println("Your backpack: " + result.toString());
        }

        public static int getTotalWeight(ArrayList<Integer> pack){
            int counter = 0;
            for ( Integer item : pack) {
                counter += item;
            }

           return counter;
        }

        public static ArrayList<Integer> backpack(int bagCapacity, int index, ArrayList<Integer> pack, ArrayList<Integer> weights) {

            if ( (getTotalWeight(pack) == bagCapacity) || (index==weights.size()) ) {
                //This is not needed!
            } else {
                if ( (getTotalWeight(pack) + weights.get(index)) > 20) {
                    backpack(bagCapacity, index + 1, pack, weights);
                } else {
                    pack.add(weights.get(index));
                    backpack(bagCapacity, index + 1, pack, weights);
                }
            }

            return pack;
        }

    }


