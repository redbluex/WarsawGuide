package pl.redblue.warszawa.communication;

public class Airport {
    private String nameAirport;
    private String adress;
    private String description;
    private String transport;
    private String transportPrice;

    public Airport(String nameAirport, String adress, String description, String transport, String transportPrice) {
        this.nameAirport = nameAirport;
        this.adress = adress;
        this.description = description;
        this.transport = transport;
        this.transportPrice = transportPrice;
    }

    public String getNameAirport() {
        return nameAirport;
    }

    public void setNameAirport(String nameAirport) {
        this.nameAirport = nameAirport;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getTransportPrice() {
        return transportPrice;
    }

    public void setTransportPrice(String transportPrice) {
        this.transportPrice = transportPrice;
    }
}
