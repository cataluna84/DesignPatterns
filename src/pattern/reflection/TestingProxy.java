package pattern.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestingProxy {

	public static void main(String[] args) {
		ISum s = new SumFactory().createSum(null, new Integer(2));
		System.out.println("Returns (null+2): " + s.sum());

		s = new SumFactory().createSum(new Integer(3), new Integer(2));
		System.out.println("Returns (3+2): " + s.sum());
	}
}

interface ISum {
	public Integer sum();
}

class Sum implements ISum {
	public Integer value1;
	public Integer value2;

	public Sum(Integer val1, Integer val2) {
		value1 = val1;
		value2 = val2;
	}

	@Override
	public Integer sum() {
		return new Integer(value1.intValue() + value2.intValue());
	}
}

/*
 * This class will try to run the true method sum() in Sum class, if it fails,
 * the NullPointerException must be catched and a zero value must return. The
 * handle must implement the InvocationHandler interface and obviously
 * implements the public Object invoke(Object proxy, Method method, Object[]
 * args) method. This method will be called when the user invoke the method
 * sum() in a Proxy class.
 */
class Handler implements InvocationHandler {
	public Sum trueSum;

	public Handler(Sum sum) {
		this.trueSum = sum;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		try {
			return method.invoke(trueSum, args);
		} catch (Exception e) {
			// e.printStackTrace();
			return new Integer(0);
		}
	}
}

/*
 * As you can see, this class creates a Sum instance with the params to sum()
 * and a handler to intercept the calls in a Proxy class. The var sum is passed
 * into a Handler constructor to be the responsable to right result. The method
 * newProxyInstance creates the Proxy class that will change the application
 * flow, repassing responsibilities to handler. The var interfacesArray is an
 * array of interfaces that have the methods to handler intercept.
 */
class SumFactory {
	public ISum createSum(Integer val1, Integer val2) {
		Sum sum = new Sum(val1, val2);
		Handler handler = new Handler(sum);
		Class[] interfacesArray = new Class[] { ISum.class };

		return (ISum) Proxy.newProxyInstance(Sum.class.getClassLoader(),
				interfacesArray, handler);
	}
}