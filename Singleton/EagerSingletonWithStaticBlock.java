/*
 * This is Eager initialization singleton class.
 * The instance is created at the time of class loading itself.
 * This provides an option for exception handling.
 * The drawback is the even though client doesn't want an instance an instance will be created while class loading it self.
 */
class EagerInitializationWithStaticBlock {

	private static EagerInitializationWithStaticBlock instance;

	static {
		try {
			instance = new EagerInitializationWithStaticBlock();
		} catch (Exception e) {
			throw new RuntimeException("Error occured while creating singleton instance");
		}
	}

	// private constructor so that client can't call this
	private EagerInitializationWithStaticBlock() {

	}

	public static EagerInitializationWithStaticBlock getInstance() {
		return instance;
	}
}

public class EagerSingletonWithStaticBlock {

	public static void main(String args[]) {
		EagerInitializationWithStaticBlock instance1 = EagerInitializationWithStaticBlock.getInstance();
		EagerInitializationWithStaticBlock instance2 = EagerInitializationWithStaticBlock.getInstance();
		System.out.println(instance1.hashCode() == instance2.hashCode());
	}
}
