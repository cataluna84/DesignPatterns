package pattern.nestedClass;

import java.io.File;
import java.io.FilenameFilter;

public class OuterClass {

	private static String varName = "OuterClass";
	private final int privateFinal=0;
	private int i;
	protected int j;
	int k;
	public int l;

	// OuterClass constructor
	public OuterClass(int i, int j, int k, int l) {
		this.i = i;
		this.j = j;
		this.k = k;
		this.l = l;
	}

	public int getI() {
		return this.i;
	}

	// static nested class, can access OuterClass static variables/methods
	static class StaticNestedClass {
		private int a;
		protected int b;
		int c;
		public int d;

		public int getA() {
			return this.a;
		}
		
		/*public int getI() {
			return i;
		}*/
		public String getVarName() {
			return varName;
		}
	}

	// inner class, non static and can access all the variables/methods of outer class
	class InnerClass {
		private int w;
		protected int x;
		int y;
		public int z;
		private int i;
		
		public int getW() {
			return this.w;
		}

		public void setValues() {
			this.w = i;
			this.x = j;
			this.y = k;
			this.z = l;
		}

		@Override
		public String toString() {
			return "w=" + w + ":x=" + x + ":y=" + y + ":z=" + z + ":OuterClass.i=" + OuterClass.this.i;
		}

		// Can access public vars
		public String getVarName() {
			return varName;
		}
		
		// Can access final vars
		public int getPrivateFinal() {
			return privateFinal;
		}
	}

	// local inner class
	public void print(String initial) {
		int localMethodVar;
		
		// final is stored in heap memory
		final int finalLocalMethodVar=0;
		
		// local inner class inside the method
		class Logger {
			String name;

			public Logger(String name) {
				this.name = name;
			}

			public void log(String str) {
				// Cannot access local method variables
				//System.out.println(localMethodVar);
				
				// In heap memory
				System.out.println("Accessing finalLocalMethodVar: " + finalLocalMethodVar);
				
				// Can also access static variables of the outer class
				System.out.println(varName);
				System.out.println(this.name + ": " + str);
			}
		}

		Logger logger = new Logger(initial);
		logger.log(varName);
		logger.log("" + this.i);
		logger.log("" + this.j);
		logger.log("" + this.k);
		logger.log("" + this.l);
	}

	// anonymous inner class
	public String[] getFilesInDir(String dir, final String ext) {
		File file = new File(dir);
		// anonymous inner class implementing FilenameFilter interface
		String[] filesList = file.list(new FilenameFilter() {

			@Override
			public boolean accept(File file, String name) {
				return name.endsWith(ext);
			}
		});
		return filesList;
	}
}