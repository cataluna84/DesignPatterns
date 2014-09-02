package pattern.nestedClass;

import java.util.Arrays;
//nested classes can be used in import for easy instantiation
import pattern.nestedClass.OuterClass.InnerClass;
import pattern.nestedClass.OuterClass.StaticNestedClass;

public class NestedClassTest {

	public static void main(String[] args) {
		OuterClass outer = new OuterClass(1, 2, 3, 4);

		// static nested classes example
		StaticNestedClass staticNestedClass = new StaticNestedClass();
		StaticNestedClass staticNestedClass1 = new StaticNestedClass();

		System.out.println("CanonicalName of StaticNestedClass: "
				+ staticNestedClass.getClass().getCanonicalName());
		System.out.println("Enclosing Class Name of StaticNestedClass: "
				+ staticNestedClass.getClass().getEnclosingClass());
		System.out.println("Class Name of StaticNestedClass: "
				+ staticNestedClass.getClass().getName());
		System.out.println(staticNestedClass.getVarName());
		staticNestedClass.d = 10;
		System.out.println(staticNestedClass.d);
		System.out.println(staticNestedClass1.d);

		// inner class example
		InnerClass innerClass = outer.new InnerClass();
		System.out.println(innerClass.getVarName());
		System.out.println(innerClass);
		innerClass.setValues();
		System.out.println(innerClass);

		// calling method using local inner class
		outer.print("Outer");

		// calling method using anonymous inner class
		System.out.println(Arrays.toString(outer.getFilesInDir(
				"src/pattern/nestedClass", ".java")));

		System.out.println(Arrays.toString(outer.getFilesInDir(
				"bin/pattern/nestedClass", ".class")));
	}
}