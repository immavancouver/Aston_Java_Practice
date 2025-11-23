package threads;

public class Livelock {

	static class PoliteWorker {
		boolean active = true;

		void workWith(PoliteWorker other) {
			while (active) {
				if (other.active) {
					System.out.println(Thread.currentThread().getName() + ": lets you go first");
					try { Thread.sleep(50); } catch (InterruptedException e) {}
					continue;
				}
				System.out.println(Thread.currentThread().getName() + ": working");
				active = false;
			}
		}
	}

	public static void main(String[] args) {
		PoliteWorker w1 = new PoliteWorker();
		PoliteWorker w2 = new PoliteWorker();

		new Thread(() -> w1.workWith(w2), "Worker 1").start();
		new Thread(() -> w2.workWith(w1), "Worker 2").start();
	}
}
