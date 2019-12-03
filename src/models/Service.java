package models;

public abstract class Service {
    private String id;
    private String nameService;
    private double area​​Use;
    private double rentalCosts;
    private int maxNumberOfPeople;
    private String typeRent;

    public Service() {
    }

    public Service(String id, String nameService, double area​​Use, double rentalCosts, int maxNumberOfPeople, String typeRent) {
        this.id = id;
        this.nameService = nameService;
        this.area​​Use = area​​Use;
        this.rentalCosts = rentalCosts;
        this.maxNumberOfPeople = maxNumberOfPeople;
        this.typeRent = typeRent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getArea​​Use() {
        return area​​Use;
    }

    public void setArea​​Use(double area​​Use) {
        this.area​​Use = area​​Use;
    }

    public double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaxNumberOfPeople() {
        return maxNumberOfPeople;
    }

    public void setMaxNumberOfPeople(int maxNumberOfPeople) {
        this.maxNumberOfPeople = maxNumberOfPeople;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }

    public String showInfo() {
        return "ServiceInterface{" +
                "id='" + id + '\'' +
                ", nameService='" + nameService + '\'' +
                ", area​​Use=" + area​​Use +
                ", rentalCosts=" + rentalCosts +
                ", maxNumberOfPeople=" + maxNumberOfPeople +
                ", typeRent='" + typeRent + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return "Service{" +
                "id='" + id + '\'' +
                ", nameService='" + nameService + '\'' +
                ", area​​Use=" + area​​Use +
                ", rentalCosts=" + rentalCosts +
                ", maxNumberOfPeople=" + maxNumberOfPeople +
                ", typeRent='" + typeRent + '\'' +
                '}';
    }
}
