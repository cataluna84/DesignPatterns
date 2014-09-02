package pattern.abstractFactory;

public class EnemyShipTesting {

	static EnemyShipBuilding makeUFOs;
	
	public static void main(String[] args) {

		// EnemyShipBuilding handles orders for new EnemyShips
		// You send it a code using the orderTheShip method &
		// it sends the order to the right factory for creation
		makeUFOs = new UFOGruntEnemyShipBuilding();

		EnemyShip theGrunt = makeUFOs.orderTheShip("UFO");
		System.out.println(theGrunt + "\n");
		
		makeUFOs = new UFOBossEnemyShipBuilding();
		EnemyShip theBoss = makeUFOs.orderTheShip("UFO BOSS");
		System.out.println(theBoss + "\n");

		makeUFOs = new RocketEnemyShipBuilding();
		EnemyShip theRocket = makeUFOs.orderTheShip("Rocket");
		System.out.println(theRocket + "\n");
	}
}