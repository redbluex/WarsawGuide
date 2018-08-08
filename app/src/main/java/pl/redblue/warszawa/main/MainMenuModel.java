package pl.redblue.warszawa.main;

public class MainMenuModel {
    private String Name;
    private int photo;

    public MainMenuModel(String name, int photo) {
        Name = name;
        this.photo = photo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
