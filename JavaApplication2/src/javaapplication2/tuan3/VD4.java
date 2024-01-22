package javaapplication2.tuan3;
public class VD4 {
    private final Object lc=new Object();
    //phuong thuc duoc dong bo 
    public synchronized void Phuongthuc1()
    {
        
    }
     public synchronized void Phuongthuc2()
     {
         synchronized (lc)
         {
             
         }
     }
     public static void main(String[] args){
         Thread th=new Thread(()->{
             //---
         });
         th.start();//bat dau tien trinh
         try{
             th.join();//cho cho tien trinh khac hoan thanh thi moi thuc hien
         }catch (Exception e){
             
         }
     }
}
