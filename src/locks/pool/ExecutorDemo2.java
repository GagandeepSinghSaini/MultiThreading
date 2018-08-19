package locks.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemo2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		MyCallableClass[] pool = {
				new MyCallableClass(2),
				new MyCallableClass(3),
				new MyCallableClass(4),
				new MyCallableClass(5)
		};
		ExecutorService service = Executors.newFixedThreadPool(2);
		Future future = null;
		for(MyCallableClass thread: pool) {
			future = service.submit(thread);
			System.out.println("Value for sum: "+future.get());
		}
		service.shutdown();
	}
	
}

class MyCallableClass implements Callable {
 
	private int num;
	
	MyCallableClass(int num) {
		this.num = num;
	}
	
	@Override
	public Object call() throws Exception {
		int sum = 0;
		System.out.println("Thread: "+Thread.currentThread().getName());
		try {
			for(int count = 1;count <= num;count++) {
				sum += count; 
			}
		}catch(Exception e) {
			System.out.println("Exception: "+e);
		}
		return sum;
	}
	
}