 class DownloadImage{
   synchronized  void downloadImage(String name, int size){
        for(int i=0;i<size;i++){
            System.out.println("downloading image "+name+i+".jpg");
        }

    }

}

class mythread extends Thread{
    DownloadImage dref;
    mythread(DownloadImage dref){
        this.dref=dref;
    }
    @Override
    public void run(){
        dref.downloadImage("dog", 10);
    }
}
class yourthread extends Thread{
    DownloadImage dref;
    yourthread(DownloadImage dref){
        this.dref=dref;
    }
    @Override
    public void run(){
        dref.downloadImage("cat", 10);
    }
}




public class ThreadExample{


    public static void main(String[] args) {
        System.out.println("applciation started");
        for(int i=0;i<100000;i++){
            System.out.println("download image dog"+i+".jpg");
        }
        DownloadImage dref=new DownloadImage();
        mythread t1=new mythread(dref);
        yourthread t2=new yourthread(dref);
        t1.start();
        // try{
        //     t1.join();
        // }
        // catch(Exception ee){ee.printStackTrace();}
        t2.start();
        System.out.println("application stopped");
    }
}
