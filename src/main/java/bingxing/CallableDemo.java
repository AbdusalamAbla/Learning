package bingxing;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by Abdusalam on 18/10/19.
 */
 class TaskWithResult implements Callable<String> {
    private int id;

    TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }


}
public  class  CallableDemo{
    public static void main(String[] args) {
        ExecutorService service= Executors.newCachedThreadPool();
        ArrayList<Future<String>> results=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            results.add(service.submit(new TaskWithResult(i)));
        }
        for (Future<String> hi:results
             ) {
            try {
                if (hi.isDone()){
                    System.out.println(hi.get());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                System.out.println("执行出错");
            }finally {
                service.shutdown();
            }
        }
    }
}
