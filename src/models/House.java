package models;

public class House extends Service {
    private String roomStandard;
    private String convenientDescription;
    private int numberOfFloors;

    public House() {
    }

    public House(String id, String nameService, double area​​Use, double rentalCosts, int maxNumberOfPeople, String typeRent, String roomStandard, String convenientDescription, int numberOfFloors) {
        super(id, nameService, area​​Use, rentalCosts, maxNumberOfPeople, typeRent);
        this.roomStandard = roomStandard;
        this.convenientDescription = convenientDescription;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getConvenientDescription() {
        return convenientDescription;
    }

    public void setConvenientDescription(String convenientDescription) {
        this.convenientDescription = convenientDescription;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String showInfo() {
        return "House: " + '\n' +
                "Id: " + super.getId() + '\n' +
                "Name ServiceInterface: " + super.getNameService() + '\n' +
                "Area​​ Use: " + super.getArea​​Use() + '\n' +
                "Rental Costs: " + super.getRentalCosts() + '\n' +
                "Max Number Of People: " + super.getMaxNumberOfPeople() + '\n' +
                "Type Rent: " + super.getTypeRent()+ '\n' +
                "Room Standard: " + roomStandard + '\n' +
                "Convenient Description:  " + convenientDescription + '\n' +
                "Number Of Floors: " + numberOfFloors;
    }
}
