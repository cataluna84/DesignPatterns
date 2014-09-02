package pattern.builder;

//The concrete builder class that assembles the parts 
//of the finished Robot object

public class OldRobotBuilder implements RobotBuilder {

	private Robot productRobot;

	public OldRobotBuilder() {
		this.productRobot = new Robot();
	}

	public void buildRobotHead() {
		productRobot.setRobotHead("Tin Head");
	}

	public void buildRobotTorso() {
		productRobot.setRobotTorso("Tin Torso");
	}

	public void buildRobotArms() {
		productRobot.setRobotArms("Blowtorch Arms");
	}

	public void buildRobotLegs() {
		productRobot.setRobotLegs("Rollar Skates");
	}

	public Robot getRobot() {
		return this.productRobot;
	}
}