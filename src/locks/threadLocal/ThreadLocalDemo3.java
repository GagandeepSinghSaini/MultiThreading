package locks.threadLocal;

public class ThreadLocalDemo3 {

	public static void main(String[] args) {
		CustomerThread ct1 = new CustomerThread("gagan");
		CustomerThread ct2 = new CustomerThread("sachin");
		CustomerThread ct3 = new CustomerThread("prateek");
		CustomerThread ct4 = new CustomerThread("archit");
		ct1.start();
		ct2.start();
		ct3.start();
		ct4.start();
	}
	
}

class CustomerThread extends Thread {

	private static int value = 0;
	private static ThreadLocal tl = new ThreadLocal() {
		public Object initialValue() {
			return ++value;
		}
	};
	
	CustomerThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		System.out.println("Thread: "+Thread.currentThread().getName()+" value: "+tl.get());
	}
	
}
