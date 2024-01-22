package javaapplication2.tuan3;
public class VD6 {
    private final Object monitor=new Object();
    private boolean isDataReady=false;
    //ha san xuat du lieu
    public void productData() throws InterruptedException
    {
        synchronized(monitor)
        {
            //dam bao chi co 1 tien trinh duoc thuc hien
            //neu du lieu da san sang -> tien trinh moi nha khoa
            while(isDataReady){
                monitor.wait();
            }
        
        //lap lai viec san xuat du lieu
        System.out.println("San xuat du lieu...");
        //sau khi san xuat du lieu xong-> du lieu da san sang 
        isDataReady=true;
        //thong bao cho tien trinh dang cho 
        if(isDataReady)
        {
            monitor.notify();
        }
        }
    }    
    //ham su dung du lieu
    public void useData() throws InterruptedException
    {
        synchronized(monitor)
        {
            //dam bao rang chi co 1 tien trinh duoc thuc hien
            //neu du lieu da san sang thi tien trinh useData se thuc hien
            while (!isDataReady){
                monitor.wait();
            }
             //neu da san sang thi su dung du lieu
            System.out.println("Su dung du lieu...");
            //sau khi su dung xong thi danh dau
            isDataReady=false;
            //thong bao cho tien trinh dang co 
            monitor.notify();
        }
        
    }
    //main
    public static void main(String[] args) {
        VD6 ex=new VD6();
        //tao tien trinh san xuat
        Thread thSanXuat = new Thread(()->{
            try {
                while (true){
                    ex.productData();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        });
        //tao tien trinh su dung
         Thread thSuDung = new Thread(()->{
            try{
                while(true){
                    ex.useData();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        });
         //start
         thSanXuat.start();
         thSuDung.start();
    }
}
