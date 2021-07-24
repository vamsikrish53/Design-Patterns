/*
 * This is Thread safe singleton class.
 * The instance is created only when calling getInstance() method.
 * This work fines only in multiple threaded environment.
 * The drawback is the cost associated with synchronized. It reduces performance.
 * To avoid this extra overhead every time, double checked locking principle is used.
 * In this approach, the synchronized block is used inside the if condition with an additional check to ensure that only one instance of a singleton class is created.
 */
class ThreadSafeSingleton {

	private static ThreadSafeSingleton instance;

	// private constructor so that client can't call this
	private ThreadSafeSingleton() {

	}

	// Normal thread safe single. It has performance issues because of synchronized
	public static synchronized ThreadSafeSingleton getInstance() {
		if (instance == null) {
			instance = new ThreadSafeSingleton();
		}
		return instance;
	}

	// Double checked locked principle to avoid performance issues with synchronized
	public static synchronized ThreadSafeSingleton getInstanceWithDoubleChecking() {
		if (instance == null) {
			synchronized (ThreadSafeSingleton.class) {
				if (instance == null) {
					instance = new ThreadSafeSingleton();
				}
			}
		}
		return instance;
	}
}

public class ThreadSafeSingletonDesign {

	public static void main(String args[]) {
		ThreadSafeSingleton instance1 = ThreadSafeSingleton.getInstance();
		ThreadSafeSingleton instance2 = ThreadSafeSingleton.getInstance();
		System.out.println(instance1.hashCode() == instance2.hashCode());

		ThreadSafeSingleton instance3 = ThreadSafeSingleton.getInstanceWithDoubleChecking();
		ThreadSafeSingleton instance4 = ThreadSafeSingleton.getInstanceWithDoubleChecking();
		System.out.println(instance3.hashCode() == instance4.hashCode());
	}
}
