package pl.redblue.warszawa.places;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties
@SuppressWarnings("serial")
public class Place implements Serializable {
    private String idPlace;
    private String name;
    private String adress;
    private String open;
    private String photoLink;
    private String uriPlace;

    public Place(String idPlace, String name, String adress, String open, String photoLink, String uriPlace) {
        this.idPlace = idPlace;
        this.name = name;
        this.adress = adress;
        this.open = open;
        this.photoLink = photoLink;
        this.uriPlace = uriPlace;
    }


    public Place(){}

    public String getUriPlace() {
        return uriPlace;
    }

    public void setUriPlace(String uriPlace) {
        this.uriPlace = uriPlace;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public String getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(String idPlace) {
        this.idPlace = idPlace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }
}
