package coreybr;

import java.util.ArrayList;

/*
 * Main class
 */
public class CarDepot {

	public static void main(String[] args) {
		Database db = new Database();
		ArrayList<Car> cars = db.loadCars();
		// Load first car in UI
		UserInterface ui = new UserInterface(cars);
		ui.run();
	}

}
