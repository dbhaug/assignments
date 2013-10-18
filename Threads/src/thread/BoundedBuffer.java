package thread;

public class BoundedBuffer {
	int buffer[];
	int nextIn, nextOut, count;

	public BoundedBuffer(int size) {
		buffer = new int[size];
	}
	
	public static void main(String[] args){
		int bufferSize=4;
		BoundedBuffer b=new BoundedBuffer(bufferSize);
		Producer p=b.new Producer();
		Consumer c=b.new Consumer();
		Thread t0=new Thread(p);
		Thread t1=new Thread(c);
		t0.start();
		t1.start();
		
	}

	public synchronized void append(int q) {
		while (count == buffer.length) {
			try {
				wait();
			} catch (Exception e) {
			}

		}
		buffer[nextIn] = q;
		nextIn = (nextIn + 1) % buffer.length;
		count++;
		notifyAll();
	}

	public synchronized int take() {
		while (count == 0) {
			try {
				wait();
			} catch (Exception e) {
			}

		}
		int ret = buffer[nextOut];
		nextOut = (nextOut + 1) % buffer.length;
		count--;
		notifyAll();
		return ret;
	}

	class Producer implements Runnable {

		@Override
		public void run() {
			System.out.println("entering producer");
			int x;
			while (true) {
				x = produce();
				append(x);
			}

		}

		private int produce() {
			System.out.println("producing");
			return (int) (Math.random() * 100);
		}

	}

	class Consumer implements Runnable {

		@Override
		public void run() {
			System.out.println("entering consumer");
			int x;
			while (true) {
				x = take();
				consume(x);
			}

		}

		private void consume(int x) {
			System.out.println("consuming");
			x = 0;
		}

	}

}
