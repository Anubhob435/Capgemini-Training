package src.Threads;

public class Main {
	static final Object lock = new Object();
	public static void main(String [] args) throws Exception{
		Thread worker = new Thread(
			() -> {
				try {
					System.out.println("Worker : Started");
					Thread.sleep(2000);
					synchronized (lock){
						System.out.println("Worker: going t waiting");
						lock.wait();
					}
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		);
		worker.start();
	}
}
