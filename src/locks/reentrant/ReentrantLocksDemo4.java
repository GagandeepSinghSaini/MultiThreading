package locks.reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocksDemo4 {

	public static void main(String[] args) {
		MyThread4 t1 = new MyThread4("Gagan");
		MyThread4 t2 = new MyThread4("Sachin");
		
		t1.start();
		t2.start();
	}

}


class MyThread4 extends Thread {
	private String name;
	private static ReentrantLock l1 = new ReentrantLock();
	
	
	public MyThread4(String name) {
		this.name = name;
	}
	
	public void run() {
		do {
			try {
				if(l1.tryLock(1000, TimeUnit.MILLISECONDS)) {
					System.out.println("Got the lock by: "+name);
					Thread.sleep(3000);
					System.out.println("Release The lock by: "+name);
					l1.unlock();
					break;
				}else {
					System.out.println("OOPS! unable to get the connection by: "+name);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(true);
	}
	
}