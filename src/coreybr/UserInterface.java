package coreybr;

import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

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
	@SuppressWarnings("rawtypes")
	private void createComponents(Container container) {

		// Create table column names
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
		Vector<Vector> rowData = new Vector<Vector>();

		for (Car car : cars) {
			Vector<Comparable> row = new Vector<Comparable>();
			row.addElement(car.getManufacturer());
			row.addElement(car.getModel());
			row.addElement(car.getType());
			row.addElement(car.getMinPrice());
			row.addElement(car.getMaxPrice());
			row.addElement(car.getMpgCity());
			row.addElement(car.getMpgHighway());
			row.addElement(car.getAirbags());
			row.addElement(car.getDrivetrain());
			row.addElement(car.getCylinders());
			row.addElement(car.getHorsepower());
			row.addElement(car.isManTransAvailable());
			row.addElement(car.getOrigin());
			rowData.addElement(row);
		}
		// Create table model
		DefaultTableModel tableModel = new DefaultTableModel(rowData, columnNames) {

			@Override
			public Class<?> getColumnClass(int col) {

				Class retVal = Object.class;

				if (getRowCount() > 0)
					retVal = getValueAt(0, col).getClass();

				return retVal;
			}

			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};

		// Create table
		JTable table = new JTable(tableModel);
		table.setAutoCreateRowSorter(true);

		// Put table into scroll pane
		JScrollPane myJScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		myJScrollPane.getVerticalScrollBar().setUnitIncrement(16); // Increase scroll speed

		// Add scroll pane to container
		container.add(myJScrollPane);
	}

}
