import java.util.concurrent.*;

public class CompletableFutureExample {
    public static void main(String[] args) {
        int a[]={100,200,300,400,500};
        CompletableFuture<Integer> sum=CompletableFuture.supplyAsync(()->sum(a));
        CompletableFuture<Integer> square=sum.thenApplyAsync(result->result*result);
        CompletableFuture<Void> printres=square.thenAcceptAsync(result->System.out.println(result));

        System.out.println("tttttttt");
        
        printres.join();
    }

   static int sum(int a[]){
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum=sum+a[i];
        }
        try{

            Thread.sleep(10000);
        }
        catch(Exception ee){ee.printStackTrace();}
        return sum;
    }

}
