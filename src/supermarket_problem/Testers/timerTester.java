package supermarket_problem.Testers;

import java.util.Timer;

/**
 * Created by Antony on 12/5/2015.
 */
public class timerTester {

    public static void main(String[] args){

        Timer timer = new Timer();
        timer.schedule(new sayHello(), 0, 5000);


    }

}
