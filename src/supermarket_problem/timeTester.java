package supermarket_problem;

/**
 * Created by Antony on 12/6/2015.
 */
public class timeTester {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(start);
        long end = start + 5000;
        System.out.println(end);

        while (true) {
            if (System.currentTimeMillis() == end) {
                System.out.println("hi");
                break;
            }
        }
        System.out.println("Took : " + ((end - start) / 1000));
    }
}
