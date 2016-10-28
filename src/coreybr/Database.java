package coreybr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * Manages connection to PostgreSQL database
 */

public class Database {

	public Database() {
	}

	/*
	 * Opens connection to database and loads Car objects
	 */
	public ArrayList<Car> loadCars() {
		Connection c = null;
		Statement stmt = null;
		ArrayList<Car> cars = new ArrayList<Car>();
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
			c.setAutoCommit(false);

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM public.\"Cars\"");
			while (rs.next()) {
				Car car = new Car();
				car.setAirbags(rs.getString("car_airbags"));
				car.setCylinders(rs.getInt("car_engine_size"));
				car.setDrivetrain(rs.getString("car_drivetrain"));
				car.setEngineSize(rs.getFloat("car_engine_size"));
				car.setHorsepower(rs.getInt("car_horsepower"));
				car.setId(rs.getInt("car_id"));
				car.setManTransAvailable(rs.getBoolean("car_man_trans_available"));
				car.setLength(rs.getInt("car_length"));
				car.setManufacturer(rs.getString("car_manufacturer"));
				car.setMinPrice(rs.getDouble("car_min_price"));
				car.setMaxPrice(rs.getDouble("car_max_price"));
				car.setModel(rs.getString("car_model"));
				car.setMpgCity(rs.getInt("car_mpg_city"));
				car.setMpgHighway(rs.getInt("car_mpg_hwy"));
				car.setOrigin(rs.getString("car_origin"));
				car.setPassengers(rs.getInt("car_passengers"));
				car.setPeakHorsepowerRPM(rs.getInt("car_peak_hp_rpm"));
				car.setType(rs.getString("car_type"));
				car.setWeight(rs.getInt("car_weight"));
				car.setWheelbase(rs.getInt("car_wheelbase"));
				car.setWidth(rs.getInt("car_width"));
				
				cars.add(car);
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return cars;
	}

}
