/*
 * This is Eager initialization singleton design pattern.
 * The instance is created at the time of class loading itself.
 * The drawback in this is even though client doesn't want an instance an instance will be created while class loading itself.
 * Also this doesn't provide any option for exception handling.
 */
class EagerInitializationSingleton {

	private static EagerInitializationSingleton instance = new EagerInitializationSingleton();

	// private constructor so that client can't call this
	private EagerInitializationSingleton() {

	}

	public static EagerInitializationSingleton getInstance() {
		return instance;
	}
}

public class EagerSingleton {

	public static void main(String args[]) {
		EagerInitializationSingleton instance1 = EagerInitializationSingleton.getInstance();
		EagerInitializationSingleton instance2 = EagerInitializationSingleton.getInstance();
		System.out.println(instance1.hashCode() == instance2.hashCode());
	}
}
