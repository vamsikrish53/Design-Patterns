/*
 * This is Lazy initialization singleton class.
 * The instance is created only when calling getInstance() method.
 * This work fines only in single threaded environment.
 * This is not thread safe.
 * The drawback is if initially multiple threads calling getInstance then 
 * there might be chance that different threads will get different instances which breaks singleton pattern.
 */
class LazyInitializationSingleton {

	private static LazyInitializationSingleton instance;

	// private constructor so that client can't call this
	private LazyInitializationSingleton() {

	}

	public static LazyInitializationSingleton getInstance() {
		if (instance == null) {
			instance = new LazyInitializationSingleton();
		}
		return instance;
	}
}

public class LazySingleton {

	public static void main(String args[]) {
		LazyInitializationSingleton instance1 = LazyInitializationSingleton.getInstance();
		LazyInitializationSingleton instance2 = LazyInitializationSingleton.getInstance();
		System.out.println(instance1.hashCode() == instance2.hashCode());
	}
}
