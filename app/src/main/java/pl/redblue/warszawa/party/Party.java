package pl.redblue.warszawa.party;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Party implements Serializable {
    private String idParty;
    private String nameParty;
    private String dateParty;
    private String descriptionParty;
    private String adressParty;
    private String uriParty;
    private String prizeParty;
    private String photoParty;

    public Party(String idParty, String nameParty, String dateParty, String descriptionParty, String adressParty, String uriParty, String prizeParty, String photoParty) {
        this.idParty = idParty;
        this.nameParty = nameParty;
        this.dateParty = dateParty;
        this.descriptionParty = descriptionParty;
        this.adressParty = adressParty;
        this.uriParty = uriParty;
        this.prizeParty = prizeParty;
        this.photoParty = photoParty;
    }

    public Party(){
    }

    public String getPhotoParty() {
        return photoParty;
    }

    public void setPhotoParty(String photoParty) {
        this.photoParty = photoParty;
    }

    public String getIdParty() {
        return idParty;
    }

    public void setIdParty(String idParty) {
        this.idParty = idParty;
    }

    public String getNameParty() {
        return nameParty;
    }

    public void setNameParty(String nameParty) {
        this.nameParty = nameParty;
    }

    public String getDateParty() {
        return dateParty;
    }

    public void setDateParty(String dateParty) {
        this.dateParty = dateParty;
    }

    public String getDescriptionParty() {
        return descriptionParty;
    }

    public void setDescriptionParty(String descriptionParty) {
        this.descriptionParty = descriptionParty;
    }

    public String getAdressParty() {
        return adressParty;
    }

    public void setAdressParty(String adressParty) {
        this.adressParty = adressParty;
    }

    public String getUriParty() {
        return uriParty;
    }

    public void setUriParty(String uriParty) {
        this.uriParty = uriParty;
    }

    public String getPrizeParty() {
        return prizeParty;
    }

    public void setPrizeParty(String prizeParty) {
        this.prizeParty = prizeParty;
    }
}
