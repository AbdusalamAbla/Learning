package bingxing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Abdusalam on 18/10/20.
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;
    public EvenChecker(IntGenerator g,int ident){
     generator=g;
     id=ident;
    }

    @Override
    public void run() {
        while(!generator.isCanceled()){
            int val = 0;
            try {
                val = generator.next();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (val%2!=0){
            System.out.println(val+"no event");
            generator.Cancel();
        }
        }
    }
    public  static void test(IntGenerator gp,int count){
        System.out.println("press control-c to exit");
        ExecutorService service= Executors.newCachedThreadPool();
        for (int i = 0; i <count ; i++) {
            service.execute(new EvenChecker(gp,i));
        }
        service.shutdown();
    }
    public  static void test(IntGenerator gp){
        test(gp,10);
    }
}
