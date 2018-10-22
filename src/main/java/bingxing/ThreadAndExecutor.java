package bingxing;

/**
 * Created by Abdusalam on 18/10/13.
 */
public class ThreadAndExecutor {
    public static void main(String[] args) {
//     Runnable task = () -> {
//            String threadName = Thread.currentThread().getName();
//            System.out.println("Hello " + threadName);
//        };
//
//        task.run();
//
//        Thread thread1 = new Thread(task);
//        thread1.start();
//
//        System.out.println("Done!");


//        Runnable runnable = () -> {
//            try {
//                String name = Thread.currentThread().getName();
//                System.out.println("Foo " + name);
//                TimeUnit.SECONDS.sleep(1);
//                System.out.println("Bar " + name);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        };
//           runnable.run();
//        Thread thread2 = new Thread(runnable);
//        thread2.start();


//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        executor.submit(() -> {
//            String threadName = Thread.currentThread().getName();
//            System.out.println("Hello " + threadName);});
//
//        try {
//            System.out.println("attempt to shutdown executor");
//            executor.shutdown();
//            executor.awaitTermination(5, TimeUnit.SECONDS);
//        }
//        catch (InterruptedException e) {
//            System.err.println("tasks interrupted");
//        }
//        finally {
//            if (!executor.isTerminated()) {
//                System.err.println("cancel non-finished tasks");
//            }
//            executor.shutdownNow();
//            System.out.println("shutdown finished");
//        }
//
//
//        Callable<Integer> task = () -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//                return 123;
//            }
//            catch (InterruptedException e) {
//                throw new IllegalStateException("task interrupted", e);
//            }
//        };
//        ExecutorService executor = Executors.newFixedThreadPool(1);
//        Future<Integer> future = executor.submit(task);
//
//        System.out.println("future done? " + future.isDone());
//
//        Integer result = null;
//        try {
//            result = future.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("future done? " + future.isDone());
//        System.out.print("result: " + result);
//        ThreadPoolExecutor test=new ThreadPoolExecutor(2,3,5, TimeUnit.SECONDS,)
    }

}
