package locks.threadLocal;

public class ThreadLocalDemo4 {

	public static void main(String[] args) {
		ParentThread pt = new ParentThread();
		pt.start();
	}
	
}

class ParentThread extends Thread {
	
	static ThreadLocal tl = new ThreadLocal();
	
	public void run() {
		tl.set("Parent Thread Val");
		ChildThread ct = new ChildThread();
		System.out.println("Parent CLass: "+tl.get());
		ct.start();
	}
}

class ChildThread extends Thread {
	public void run() {
		System.out.println("Child Thread: "+ParentThread.tl.get());
	}
}