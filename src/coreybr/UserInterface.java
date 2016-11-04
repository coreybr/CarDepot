package coreybr;

import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable {

	private JFrame frame;
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
		
		
		// Create table
		Vector<String> columnNames = new Vector<String>();
		columnNames.addElement("Make");
		columnNames.addElement("Model");
		columnNames.addElement("Type");
		columnNames.addElement("Min price");
		columnNames.addElement("Max price");
		columnNames.addElement("MPG City");
		columnNames.addElement("MPG Hwy");
		columnNames.addElement("Airbags");
		columnNames.addElement("Drivetrain");
		columnNames.addElement("Cylinders");
		columnNames.addElement("Horsepower");
		columnNames.addElement("Man Trans Avail");
		columnNames.addElement("Origin");		

		// Populate table rows
		@SuppressWarnings("rawtypes")
		Vector<Vector> rowData = new Vector<Vector>();
		
		for (Car car : cars) {		
			Vector<String> row = new Vector<String>();
		    row.addElement(car.getManufacturer());
		    row.addElement(car.getModel());
		    row.addElement(car.getType());
		    row.addElement("$" + Double.toString(car.getMinPrice()) + "0");
		    row.addElement("$" + Double.toString(car.getMaxPrice()) + "0");
		    row.addElement(Integer.toString(car.getMpgCity()));
		    row.addElement(Integer.toString(car.getMpgHighway()));
		    row.addElement(car.getAirbags());
		    row.addElement(car.getDrivetrain());
		    row.addElement(Integer.toString(car.getCylinders()));
		    row.addElement(Integer.toString(car.getHorsepower()));
		    if (car.isManTransAvailable()) {
		    	row.addElement("Yes");
			} else {
				row.addElement("No");
			}
		    row.addElement(car.getOrigin());
		    
		    rowData.addElement(row);
		}
		
		JTable table = new JTable(rowData, columnNames);
		
		// Put table into scrollable area
		JScrollPane myJScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		myJScrollPane.getVerticalScrollBar().setUnitIncrement(16); // Increase scroll speed
		
		container.add(myJScrollPane);
	}

}
