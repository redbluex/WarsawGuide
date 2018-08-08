package pl.redblue.warszawa.communication;

public class SingleTicket {
    private String nameTicket;
    private String descriptionTicket;
    private int imageResources;
    private String price;

    public SingleTicket(String nameTicket, String descriptionTicket, int imageResources, String price) {
        this.nameTicket = nameTicket;
        this.descriptionTicket = descriptionTicket;
        this.imageResources = imageResources;
        this.price = price;
    }

    public String getNameTicket() {
        return nameTicket;
    }

    public void setNameTicket(String nameTicket) {
        this.nameTicket = nameTicket;
    }

    public String getDescriptionTicket() {
        return descriptionTicket;
    }

    public void setDescriptionTicket(String descriptionTicket) {
        this.descriptionTicket = descriptionTicket;
    }

    public int getImageResources() {
        return imageResources;
    }

    public void setImageResources(int imageResources) {
        this.imageResources = imageResources;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
