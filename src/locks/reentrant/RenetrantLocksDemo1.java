package locks.reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class RenetrantLocksDemo1 {
	
	public static void main(String[] args) {
		ReentrantLock lock1 = new ReentrantLock();
		System.out.println("isFair(): "+lock1.isFair());
		lock1.lock();
		lock1.lock();
		System.out.println("isLocked(): "+lock1.isLocked());
		System.out.println("isHedByCurrentThread(): "+lock1.isHeldByCurrentThread());
		System.out.println("Queue Threads: "+lock1.getQueueLength());
		System.out.println("Hold COunt 1: "+lock1.getHoldCount());
		lock1.unlock();
		System.out.println("Hold COunt 1: "+lock1.getHoldCount());
		lock1.unlock();
		
		
		
	}
	
}
