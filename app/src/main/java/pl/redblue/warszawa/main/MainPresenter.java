package pl.redblue.warszawa.main;

import java.util.ArrayList;
import java.util.List;

import pl.redblue.warszawa.R;

public class MainPresenter implements MainMVP.Presenter{
    private final MainMVP.View mainMVP;

    public MainPresenter(MainMVP.View mainMVP) {
        this.mainMVP = mainMVP;
    }


    @Override
    public List<MainMenuModel> createMenuList() {
        List<MainMenuModel> data = new ArrayList<>();
        data.add(new MainMenuModel("Transport", R.drawable.transporticon));
        data.add(new MainMenuModel("Attraction", R.drawable.zamek));
        data.add(new MainMenuModel("Restaurant", R.drawable.restaurant));
        data.add(new MainMenuModel("Bar", R.drawable.bar));
        data.add(new MainMenuModel("Party", R.drawable.impreza));
        data.add(new MainMenuModel("Add", R.drawable.plus));
        return data;
    }


}
