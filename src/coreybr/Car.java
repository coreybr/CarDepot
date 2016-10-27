package coreybr;

/*
 * Representation of a Car record in database
 */
public class Car {
	
	private int id, mpgCity, mpgHighway, cylinders, horsepower, peakHorsepowerRPM, passengers, length, wheelbase, width, weight;
	private String manufacturer, model, type, airbags, drivetrain, origin;
	private double minPrice, maxPrice, engineSize;
	private boolean isManTransAvailable;
	
	/*
	 * Getters & Setters
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMpgCity() {
		return mpgCity;
	}
	public void setMpgCity(int mpgCity) {
		this.mpgCity = mpgCity;
	}
	public int getMpgHighway() {
		return mpgHighway;
	}
	public void setMpgHighway(int mpgHighway) {
		this.mpgHighway = mpgHighway;
	}
	public int getCylinders() {
		return cylinders;
	}
	public void setCylinders(int cylinders) {
		this.cylinders = cylinders;
	}
	public int getHorsepower() {
		return horsepower;
	}
	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}
	public int getPeakHorsepowerRPM() {
		return peakHorsepowerRPM;
	}
	public void setPeakHorsepowerRPM(int peakHorsepowerRPM) {
		this.peakHorsepowerRPM = peakHorsepowerRPM;
	}
	public int getPassengers() {
		return passengers;
	}
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWheelbase() {
		return wheelbase;
	}
	public void setWheelbase(int wheelbase) {
		this.wheelbase = wheelbase;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAirbags() {
		return airbags;
	}
	public void setAirbags(String airbags) {
		this.airbags = airbags;
	}
	public String getDrivetrain() {
		return drivetrain;
	}
	public void setDrivetrain(String drivetrain) {
		this.drivetrain = drivetrain;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public double getEngineSize() {
		return engineSize;
	}
	public void setEngineSize(double engineSize) {
		this.engineSize = engineSize;
	}
	public boolean isManTransAvailable() {
		return isManTransAvailable;
	}
	public void setManTransAvailable(boolean isManTransAvailable) {
		this.isManTransAvailable = isManTransAvailable;
	}
	
	
}
