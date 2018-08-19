package locks.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo1 {

	public static void main(String[] args) {
		MyThreadPool[] pool = {
				new MyThreadPool("Gagan"),
				new MyThreadPool("Sachin"),
				new MyThreadPool("Archit"),
				new MyThreadPool("Prateek")
		};
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		for(MyThreadPool thread: pool) {
			service.submit(thread);
		}
		service.shutdown();
		
	}
	
}


class MyThreadPool implements Runnable {

	private String name;
	
	MyThreadPool(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {		
		System.out.println("Thread Working: "+Thread.currentThread().getName()+", Name: "+name+" starts");
		try {
			Thread.sleep(2000);
		}catch(Exception e) {
			System.out.println("Exception: "+e);
		}
		System.out.println("Thread Working: "+Thread.currentThread().getName()+", Name: "+name+" ends");
	}
	
}