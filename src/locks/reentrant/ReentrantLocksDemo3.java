package locks.reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocksDemo3 {

	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1("First Thread");
		MyThread1 t2 = new MyThread1("Second Thread");
		
		t1.start();
		t2.start();
	}
	
}

class MyThread1 extends Thread {
	
	private String name;
	private static ReentrantLock lock = new ReentrantLock();
	
	public MyThread1(String name) {
		this.name = name;
	}
	
	public void run() {
		if(lock.tryLock()) {
			System.out.println("Got the lock by: "+name);
		}else {
			System.out.println("OOPS! Unable to get the lock: "+name);
		}
	}
	
}
