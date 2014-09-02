package headfirst.proxy.gumball;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

public class GumballMachineTestDrive {

	public static void main(String[] args) {
		GumballMachineRemote gumballMachine = null;
		int count;

		if (args.length < 2) {
			System.out.println("GumballMachine <name> <inventory>");
			System.exit(1);
		}

		try {
			count = Integer.parseInt(args[1]);
			
			gumballMachine = new GumballMachine(args[0], count);
			/*if(System.getSecurityManager() == null) {
	            System.setSecurityManager(new SecurityManager());
	        }*/
			System.setSecurityManager(new RMISecurityManager());
			/*System.setProperty("java.rmi.server.codebase", GumballMachineRemote.class
		            .getProtectionDomain().getCodeSource().getLocation().toString());*/
			//Naming.rebind("rmi://localhost/gumballmachine", gumballMachine);
			Naming.rebind("//" + args[0] + "/gumballmachine", gumballMachine);
			System.out.println("Addition Server is ready.");
		} catch (Exception e) {
			System.out.println("Addition Server Failed.");
			e.printStackTrace();
		}
	}
}