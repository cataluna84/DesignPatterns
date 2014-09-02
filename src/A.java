public class A implements Cloneable {

	int i;
	Integer integer;
	B b;

	public A() {
		i = 4000;
		integer = new Integer(20000);
		b = new B(4500);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "i: " + i + "   integer: " + integer + ", ADDRESS: " + System.identityHashCode(integer)
				+ "   B's z VALUE: " + b.z + ",  ADDRESS: " + System.identityHashCode(b);
	}
}

class B {
	int z;

	public B(int zzz) {
		z = zzz;
	}

}