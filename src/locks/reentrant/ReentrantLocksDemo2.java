package locks.reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocksDemo2 {

	public static void main(String[] args) {
		MyThread t1 = new MyThread(new Display(), "Gagan");
		MyThread t2 = new MyThread(new Display(), "Sachin");
		
		t1.start();
		t2.start();
		
	}
	
}

class Display {
	
	private static ReentrantLock l1 = new ReentrantLock();  // same lock across different objects
	
	public void show(String name) {
		l1.lock();
		for(int i=1;i<5;i++) {
			System.out.println("Hello "+name);
			try {
				Thread.sleep(2000);
			}catch(Exception e) {
				System.out.println("Exception: name: "+name+", "+e);
			}
			System.out.println("Bye "+name);
		}
		l1.unlock();
	}
}

class MyThread extends Thread {
	
	private Display d;
	private String name;
	
	public MyThread(Display d, String name) {
		super();
		this.d = d;
		this.name = name;
	}

	public void run() {
		d.show(name);
	}
}
