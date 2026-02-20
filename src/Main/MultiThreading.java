package src.Main;

public class MultiThreading extends Thread{
	@Override
	
	public void run() {
		for(int i = 1; i<=5; i++){
			System.out.println(i);
			int threadNumber = i;
			if(threadNumber == 3) {
				throw new RuntimeException("Thread interrupted at count 3");
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

		}
	}


	public static void main(String[] args) {
		MultiThreading t1 = new MultiThreading();
		MultiThreading t2 = new MultiThreading();
		t1.start();
		t2.start();
	}
}