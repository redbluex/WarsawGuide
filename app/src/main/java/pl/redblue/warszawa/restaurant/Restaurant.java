package pl.redblue.warszawa.restaurant;

public class Restaurant {
    private String idRestaurant;
    private String nameRestaurant;
    private String photoRestaurant;
    private int likeRatio;
    // Class Menu etc. INC


    public Restaurant(String idRestaurant, String nameRestaurant, String photoRestaurant, int likeRatio) {
        this.idRestaurant = idRestaurant;
        this.nameRestaurant = nameRestaurant;
        this.photoRestaurant = photoRestaurant;
        this.likeRatio = likeRatio;
    }
    public Restaurant(){

    }

    public String getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(String idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getNameRestaurant() {
        return nameRestaurant;
    }

    public void setNameRestaurant(String nameRestaurant) {
        this.nameRestaurant = nameRestaurant;
    }

    public String getPhotoRestaurant() {
        return photoRestaurant;
    }

    public void setPhotoRestaurant(String photoRestaurant) {
        this.photoRestaurant = photoRestaurant;
    }

    public int getLikeRatio() {
        return likeRatio;
    }

    public void setLikeRatio(int likeRatio) {
        this.likeRatio = likeRatio;
    }
}
