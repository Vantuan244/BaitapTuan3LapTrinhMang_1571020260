package javaapplication2.tuan3;
public class VD3 {
    private int count=0;
    //phuong thuc 1 dong bo hoa
    public synchronized void increment()
    {
        count ++;
    }
    //phuong thuc 2 dong bo hoa
    public synchronized void decrement()
    {
        count-=2;
    }
    // phuong thuc khong dong bo hoa 
    public int getCount()
    {
        return count;
    }
    public static void main(String[] args ){
        VD3 counter = new VD3();
        //tao cac luong de tang 
        Thread incrementThread= new Thread(()->{
            for(int i=0;i<1000;i++)
            {
                counter.increment();
            }
        });
        //tao cac luong dem giam
        Thread decrementThread= new Thread(()->{
            for(int i=0;i<1000;i++)
            {
                counter.decrement();
            }
        });
        //khoi chay cac luong 
        incrementThread.start();
        decrementThread.start();
        try{
            // cho doi cho den khi cac luong hoan thanh 
            incrementThread.join();
            decrementThread.join();
        } catch (Exception e){
            e.printStackTrace();
        }
        //in ra ket qua cuoi cung cua bien count
        System.out.println("Count cuoi cung :" + counter.getCount());
    }
}
