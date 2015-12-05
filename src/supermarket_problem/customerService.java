package supermarket_problem;

import java.util.TimerTask;

/**
 * Created by Antony on 12/6/2015.
 */
public class customerService extends TimerTask {

    MyQueue q;

    public customerService(MyQueue q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            q.pop();
            System.out.println(q.toString());
        } catch (MyQueueException e) {
            e.getMessage();
        }
    }
}
