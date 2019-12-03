package models;

public class Room extends Service {
    private String freeService;

    public Room() {
    }

    public Room(String id, String nameService, double area​​Use, double rentalCosts, int maxNumberOfPeople, String typeRent, String freeService) {
        super(id, nameService, area​​Use, rentalCosts, maxNumberOfPeople, typeRent);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String showInfo() {
        return "Room:" + '\n' +
                "Id: " + super.getId() + '\n' +
                "Name ServiceInterface: " + super.getNameService() + '\n' +
                "Area ​​Use: " + super.getArea​​Use() + '\n' +
                "Rental Costs: " + super.getRentalCosts() + '\n' +
                "Max Number Of People: " + super.getMaxNumberOfPeople() + '\n' +
                "Type Rent: " + super.getTypeRent() + '\n' +
                "Free ServiceInterface: " + freeService;
    }
}
