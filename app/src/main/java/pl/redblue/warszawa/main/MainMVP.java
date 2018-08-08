package pl.redblue.warszawa.main;

import java.util.List;

public interface MainMVP{
    interface View{

    }

    interface Presenter{
        List<MainMenuModel> createMenuList();
    }
}
