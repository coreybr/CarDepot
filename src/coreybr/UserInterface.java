package coreybr;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable {

	private JFrame frame;
	private JLabel makeLabel, modelLabel;
	private ArrayList<Car> cars;

	public UserInterface(ArrayList<Car> cars) {
		this.cars = cars;
	}

	// Initiate GUI
	@Override
	public void run() {
		frame = new JFrame("CarDepot");
		frame.setPreferredSize(new Dimension(1280, 720));

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		createComponents(frame.getContentPane());

		frame.pack();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //maximized
		frame.setVisible(true);
	}

	// Define GUI content
	private void createComponents(Container container) {
		// Setup layout
		GridLayout layout = new GridLayout(cars.size() + 2, 1);
		container.setLayout(layout);

		/*
		 * Setup GUI elements
		 */

		//Header
		makeLabel = new JLabel("Make / Model");
		makeLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		container.add(makeLabel);
		
		//Space
		makeLabel = new JLabel();
		container.add(makeLabel);
		
		//Show cars
		for (Car car : cars) {
			makeLabel = new JLabel(car.getManufacturer() + " " + car.getModel());
			makeLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
			container.add(makeLabel);
		}

		/*
		 * End: Setup GUI elements
		 */
	}

}
