package misc;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * http://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html
 */
public class AnomynousClassExpression {

	static int runnableCount;

	class RunnableTesting {
		RunnableTesting() {
			System.out.println(runnable);
		}
		
		final Runnable runnable = new Runnable() {
			public void run() {
				System.out.println("beep" + toString());
				runnableCount++;
			}
		};
	}
	
	public static void main(String[] args) {
		AnomynousClassExpression sample = new AnomynousClassExpression();
		RunnableTesting runnableTesting = sample.new RunnableTesting();
		for(int i=0; i<5; i++) {
			runnableTesting.runnable.run();
			System.out.println(i + " : "+ runnableCount);
		}
	}
}

/*
public class Sample {

	static int runnableCount;

	static class RunnableTesting {
		RunnableTesting() {
			System.out.println(runnable);
		}
		
		static final Runnable runnable = new Runnable() {
			public void run() {
				System.out.println("beep");
				runnableCount++;
			}
		};
	}
	
	public static void main(String[] args) {
		Sample sample = new Sample();
		for(int i=0; i<5; i++) {
			new RunnableTesting();
			System.out.println(i + " : "+ runnableCount);
		}
	}
}
*/