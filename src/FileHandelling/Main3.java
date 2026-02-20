package src.FileHandelling;

class Task{
	public synchronized void countDown() throws InterruptedException{
		for(int i = 0; i<= 5; i++) {
			System.out.println("Count " + i);
			Thread.sleep(1000);
		}
	}
}

public class Main3 {
	public static void main(String[] args) {
		Task t1 = new Task();
		Thread th1 = new Thread(() -> {
			try {
				t1.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		th1.start();
	}
}
