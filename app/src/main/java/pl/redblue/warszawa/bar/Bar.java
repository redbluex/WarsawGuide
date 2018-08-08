package pl.redblue.warszawa.bar;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Bar implements Serializable {
    private String idBar;
    private String nameBar;
    private String adressBar;
    //Menu INC
    private double thumbsUp;
    private double thumbsDown;

    public Bar(){}

    public Bar(String idBar, String nameBar, String adressBar, double thumbsUp, double thumbsDown) {
        this.idBar = idBar;
        this.nameBar = nameBar;
        this.adressBar = adressBar;
        this.thumbsUp = thumbsUp;
        this.thumbsDown = thumbsDown;
    }

    public String getIdBar() {
        return idBar;
    }

    public void setIdBar(String idBar) {
        this.idBar = idBar;
    }

    public String getNameBar() {
        return nameBar;
    }

    public void setNameBar(String nameBar) {
        this.nameBar = nameBar;
    }

    public String getAdressBar() {
        return adressBar;
    }

    public void setAdressBar(String adressBar) {
        this.adressBar = adressBar;
    }

    public double getThumbsUp() {
        return thumbsUp;
    }

    public void setThumbsUp(double thumbsUp) {
        this.thumbsUp = thumbsUp;
    }

    public double getThumbsDown() {
        return thumbsDown;
    }

    public void setThumbsDown(double thumbsDown) {
        this.thumbsDown = thumbsDown;
    }
}
