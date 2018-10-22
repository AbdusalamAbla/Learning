package bingxing;

/**
 * Created by Abdusalam on 18/10/20.
 */
public abstract class IntGenerator {
private volatile boolean canceled=false;
public abstract int next() throws InterruptedException;
public void  Cancel(){this.canceled=true;}
public boolean isCanceled(){
    return canceled;
}
}
