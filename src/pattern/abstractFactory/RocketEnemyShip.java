package pattern.abstractFactory;

public class RocketEnemyShip extends EnemyShip {

	EnemyShipFactory shipFactory;
	
	public RocketEnemyShip(EnemyShipFactory shipFactory) {
		this.shipFactory = shipFactory;
	}
	
	@Override
	public void makeShip() {
		System.out.println("Making enemy ship " + getName());
		weapon = shipFactory.addESGun();
		engine = shipFactory.addESEngine();
	}

}