package pattern.abstractFactory;

public class RocketEnemyShipBuilding extends EnemyShipBuilding {

	@Override
	protected EnemyShip makeEnemyShip(String typeOfShip) {
		EnemyShip theEnemyShip = null;
		
		if(typeOfShip.equals("Rocket")) {
			EnemyShipFactory shipPartsFactory = new RocketEnemyShipFactory();
			theEnemyShip = new RocketEnemyShip(shipPartsFactory);
			theEnemyShip.setName("Rocket Ship");
		}
		return theEnemyShip;
	}

}
