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
	private JLabel makeLabel, modelLabel, typeLabel, minPriceLabel, maxPriceLabel, mpgCityLabel, mpgHwyLabel,
			airbagsLabel, drivetrainLabel, cylindersLabel, horsepowerLabel, manTransAvailLabel, originLabel;
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
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximized
		frame.setVisible(true);
	}

	// Define GUI content
	private void createComponents(Container container) {
		// Setup layout
		GridLayout layout = new GridLayout(cars.size() + 2, 13);
		container.setLayout(layout);

		/*
		 * Setup GUI elements
		 */

		// Header
		makeLabel = new JLabel("Make");
		makeLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		container.add(makeLabel);
		modelLabel = new JLabel("Model");
		container.add(modelLabel);
		typeLabel = new JLabel("Type");
		container.add(typeLabel);
		minPriceLabel = new JLabel("Min price");
		container.add(minPriceLabel);
		maxPriceLabel = new JLabel("Max price");
		container.add(maxPriceLabel);
		mpgCityLabel = new JLabel("MPG City");
		container.add(mpgCityLabel);
		mpgHwyLabel = new JLabel("MPG Hwy");
		container.add(mpgHwyLabel);
		airbagsLabel = new JLabel("Airbags");
		container.add(airbagsLabel);
		drivetrainLabel = new JLabel("Drivetrain");
		container.add(drivetrainLabel);
		cylindersLabel = new JLabel("Cylinders");
		container.add(cylindersLabel);
		horsepowerLabel = new JLabel("Horsepower");
		container.add(horsepowerLabel);
		manTransAvailLabel = new JLabel("Man Trans Avail");
		container.add(manTransAvailLabel);
		originLabel = new JLabel("Origin");
		container.add(originLabel);

		// Blank row
		for (int i = 0; i < layout.getColumns(); i++) {
			makeLabel = new JLabel();
			container.add(makeLabel);
		}

		// Show cars
		for (Car car : cars) {
			makeLabel = new JLabel(car.getManufacturer());
			makeLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
			container.add(makeLabel);
			modelLabel = new JLabel(car.getModel());
			container.add(modelLabel);
			typeLabel = new JLabel(car.getType());
			container.add(typeLabel);
			minPriceLabel = new JLabel("$" + Double.toString(car.getMinPrice()) + "0");
			container.add(minPriceLabel);
			maxPriceLabel = new JLabel("$" + Double.toString(car.getMaxPrice()) + "0");
			container.add(maxPriceLabel);
			mpgCityLabel = new JLabel(Integer.toString(car.getMpgCity()));
			container.add(mpgCityLabel);
			mpgHwyLabel = new JLabel(Integer.toString(car.getMpgHighway()));
			container.add(mpgHwyLabel);
			airbagsLabel = new JLabel(car.getAirbags());
			container.add(airbagsLabel);
			drivetrainLabel = new JLabel(car.getDrivetrain());
			container.add(drivetrainLabel);
			cylindersLabel = new JLabel(Integer.toString(car.getCylinders()));
			container.add(cylindersLabel);
			horsepowerLabel = new JLabel(Integer.toString(car.getHorsepower()));
			container.add(horsepowerLabel);
			if (car.isManTransAvailable()) {
				manTransAvailLabel = new JLabel("Yes");
			} else {
				manTransAvailLabel = new JLabel("No");
			}
			container.add(manTransAvailLabel);
			originLabel = new JLabel(car.getOrigin());
			container.add(originLabel);
		}

		/*
		 * End: Setup GUI elements
		 */
	}

}
