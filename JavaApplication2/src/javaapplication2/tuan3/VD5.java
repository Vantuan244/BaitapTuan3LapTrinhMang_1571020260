
package javaapplication2.tuan3;

public class VD5 {
    private final Object monitor = new Object();
    public void waitForSignal() throws InterruptedException
    {
        synchronized(monitor)
        {
            monitor.wait();//tien trinh se treo cho den khi notify
        }
    }
    public void notifySignal()
    {
        synchronized(monitor)
        {
            monitor.notify();
        }
    }
}
