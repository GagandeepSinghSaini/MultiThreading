package locks.threadLocal;

public class ThreadLocalDemo2 {

	public static void main(String[] args) {
		ThreadLocal t1 = new ThreadLocal() {
			public Object initialValue() {
				return "--initial value--";
				
			}
		};
		
		System.out.println(t1.get());
		t1.set("gagan");
		System.out.println(t1.get());
		t1.remove();
		System.out.println(t1.get());
	}
	
}
