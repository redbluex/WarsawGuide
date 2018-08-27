package pl.redblue.warszawa.main;

import java.util.List;

public interface MainMVP{
    interface View{
        void setMenu(List<MainMenuModel> list);
    }

    interface Presenter{
        void createMenuList();
    }
}
