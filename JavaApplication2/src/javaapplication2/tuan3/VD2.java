
package javaapplication2.tuan3;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VD2 {
    private int count=0;
    private Lock lc=new ReentrantLock();//tao khoa
    public void demTang()
    {
        lc.lock();//khoa cac tien trinh khac
        try{
            count++;// de thuc hien dem
        } catch (Exception e){
        }
            finally{
            lc.unlock();// mo cac tien trinh khac
        }
    }
}
