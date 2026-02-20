package src.Main;

class Logic extends Thread {

	int ThreadNumber;

	Logic(int ThreadNumber) {
		this.ThreadNumber = ThreadNumber;
	}

	@Override
	public void run() {
		try {
			for (int i = 1; i <= 5; i++) {
				System.out.println(i + " The Thread Number is : " + ThreadNumber);

				if (ThreadNumber == 3) {
					throw new RuntimeException("Thread 3 encountered an error!");
				}

				Thread.sleep(1000);
			}
		} catch (RuntimeException e) {
			System.out.println("RuntimeException in Thread " + ThreadNumber + ": " + e.getMessage());
		} catch (InterruptedException e) {
			System.out.println("Thread " + ThreadNumber + " was interrupted.");
			Thread.currentThread().interrupt();
		}
	}
}



