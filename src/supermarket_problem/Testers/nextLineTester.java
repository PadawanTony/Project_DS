package supermarket_problem.Testers;

import java.util.Scanner;

/**
 * Created by Antony on 12/8/2015.
 */
public class nextLineTester {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        System.out.println(in.nextInt());
        System.out.println(in.nextLine()); //does not print "\n" !!!!
        System.out.println("asdf");

    }
}
