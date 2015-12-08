package supermarket_problem.Testers;

import java.text.NumberFormat;

/**
 * Created by giorgos on 12/7/2015.
 */
public class runTimeTester {

    public static void main(String[] args){
        Runtime runtime = Runtime.getRuntime();

        NumberFormat format = NumberFormat.getInstance();

        StringBuilder sb = new StringBuilder();
        long maxMemory = runtime.maxMemory();
        long allocatedMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();

        sb.append("free memory: " + format.format(freeMemory / 1024) + "<br/>");
        sb.append("allocated memory: " + format.format(allocatedMemory / 1024) + "<br/>");
        sb.append("max memory: " + format.format(maxMemory / 1024) + "<br/>");
        sb.append("total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024) + "<br/>");

        for (int i=1; i<10000; i++){
            int x = i;
            int y = x*x;
            System.out.println(x);
        }

        long maxMemory2 = runtime.maxMemory();
        long allocatedMemory2 = runtime.totalMemory();
        long freeMemory2 = runtime.freeMemory();

        System.out.println("free memory: " + format.format(freeMemory / 1024) + " allocated memory: " + format.format(allocatedMemory / 1024));
        System.out.println("max memory: " + format.format(maxMemory / 1024));
        System.out.println("total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024));
        System.out.println("===========================================================================");
        System.out.println("free memory 2: " + format.format(freeMemory2 / 1024) + " allocated memory 2: " + format.format(allocatedMemory2 / 1024));
        System.out.println("max memory 2: " + format.format(maxMemory2 / 1024));
        System.out.println("total free memory 2: " + format.format((freeMemory2 + (maxMemory2 - allocatedMemory2)) / 1024));

//        System.out.println(sb);
    }

}