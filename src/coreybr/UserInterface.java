package coreybr;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
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
		// Setup container layout
		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
		
		// Header
		Container headerContainer = new Container();
		GridLayout headerLayout = new GridLayout(1, cars.size());
		headerContainer.setLayout(headerLayout);
		
		makeLabel = new JLabel("Make");
		makeLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		headerContainer.add(makeLabel);
		modelLabel = new JLabel("Model");
		headerContainer.add(modelLabel);
		typeLabel = new JLabel("Type");
		headerContainer.add(typeLabel);
		minPriceLabel = new JLabel("Min price");
		headerContainer.add(minPriceLabel);
		maxPriceLabel = new JLabel("Max price");
		headerContainer.add(maxPriceLabel);
		mpgCityLabel = new JLabel("MPG City");
		headerContainer.add(mpgCityLabel);
		mpgHwyLabel = new JLabel("MPG Hwy");
		headerContainer.add(mpgHwyLabel);
		airbagsLabel = new JLabel("Airbags");
		headerContainer.add(airbagsLabel);
		drivetrainLabel = new JLabel("Drivetrain");
		headerContainer.add(drivetrainLabel);
		cylindersLabel = new JLabel("Cylinders");
		headerContainer.add(cylindersLabel);
		horsepowerLabel = new JLabel("Horsepower");
		headerContainer.add(horsepowerLabel);
		manTransAvailLabel = new JLabel("Man Trans Avail");
		headerContainer.add(manTransAvailLabel);
		originLabel = new JLabel("Origin");
		headerContainer.add(originLabel);
		container.add(headerContainer);

		// Setup bodyContainer layout
		Container bodyContainer = new Container();
		GridLayout bodyLayout = new GridLayout(cars.size(), 13);
		bodyContainer.setLayout(bodyLayout);
		
		// Put container into scrollable area
		JScrollPane myJScrollPane = new JScrollPane(bodyContainer, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// Show cars
		for (Car car : cars) {
			makeLabel = new JLabel(car.getManufacturer());
			makeLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
			bodyContainer.add(makeLabel);
			modelLabel = new JLabel(car.getModel());
			bodyContainer.add(modelLabel);
			typeLabel = new JLabel(car.getType());
			bodyContainer.add(typeLabel);
			minPriceLabel = new JLabel("$" + Double.toString(car.getMinPrice()) + "0");
			bodyContainer.add(minPriceLabel);
			maxPriceLabel = new JLabel("$" + Double.toString(car.getMaxPrice()) + "0");
			bodyContainer.add(maxPriceLabel);
			mpgCityLabel = new JLabel(Integer.toString(car.getMpgCity()));
			bodyContainer.add(mpgCityLabel);
			mpgHwyLabel = new JLabel(Integer.toString(car.getMpgHighway()));
			bodyContainer.add(mpgHwyLabel);
			airbagsLabel = new JLabel(car.getAirbags());
			bodyContainer.add(airbagsLabel);
			drivetrainLabel = new JLabel(car.getDrivetrain());
			bodyContainer.add(drivetrainLabel);
			cylindersLabel = new JLabel(Integer.toString(car.getCylinders()));
			bodyContainer.add(cylindersLabel);
			horsepowerLabel = new JLabel(Integer.toString(car.getHorsepower()));
			bodyContainer.add(horsepowerLabel);
			if (car.isManTransAvailable()) {
				manTransAvailLabel = new JLabel("Yes");
			} else {
				manTransAvailLabel = new JLabel("No");
			}
			bodyContainer.add(manTransAvailLabel);
			originLabel = new JLabel(car.getOrigin());
			bodyContainer.add(originLabel);
		}
		container.add(myJScrollPane);
	}

}
