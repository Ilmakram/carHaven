public class Car {
    private int id;
    private String model;
    private String plateNumber;
    private double rentPerDay;
    private boolean isAvailable;

    public Car(int id, String model, String plateNumber, double rentPerDay, boolean isAvailable) {
        this.id = id;
        this.model = model;
        this.plateNumber = plateNumber;
        this.rentPerDay = rentPerDay;
        this.isAvailable = isAvailable;
    }

    public void rentOut() { this.isAvailable = false; }
    public void returnCar() { this.isAvailable = true; }

    // Getters & Setters
    public int getId() { return id; }
    public String getModel() { return model; }
    public String getPlateNumber() { return plateNumber; }
    public double getRentPerDay() { return rentPerDay; }
    public boolean isAvailable() { return isAvailable; }
}
