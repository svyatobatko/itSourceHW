package itSourceHW.hw13;
import itSourceHW.hw13.HomeWork13;

public class HomeWork13 implements Runnable {
	   public void run() {
		      try {
		         System.out.println("in run() - about to work2()");
		         work2();
		         System.out.println("in run() - back from work2()");
		      } catch (InterruptedException x) {
		         System.out.println("in run() - interrupted in work2()");
		         return;
		      }
		      System.out.println("in run() - doing stuff after nap");
		      System.out.println("in run() - leaving normally");
		   }
		   public void work2() throws InterruptedException {
		      while (true) {
		    	 //System.out.println("thread");
		         if (Thread.currentThread().isInterrupted()) {
		            System.out.println("C isInterrupted()="+ Thread.currentThread().isInterrupted());
		            Thread.sleep(500);
		            System.out.println("D isInterrupted()="+ Thread.currentThread().isInterrupted());
		         }
		      }
		   }
		   public void work() throws InterruptedException {
		      while (true) {
		         for (int i = 0; i < 100000; i++) {
		            int j = i * 2;
		         }
		         System.out.println("A isInterrupted()="+ Thread.currentThread().isInterrupted());
		         if (Thread.interrupted()) {
		            System.out.println("B isInterrupted()="+ Thread.currentThread().isInterrupted());
		            throw new InterruptedException();
		         }
		      }
		   }
		   public static void main(String[] args) throws InterruptedException {
		      HomeWork13 si = new HomeWork13();
		      Thread t = new Thread(si);
		      
		      t.start();
		      
		      for (int i = 0; i < 10; i++) {
			      try {
				         Thread.sleep(500);
				      } catch (InterruptedException x) { }
						
			      System.out.println("in main() - interrupting other thread. Itteration = " + i);
			      t.interrupt();
			      //System.out.println("in main() - leaving");
		      }
		   }
		}
