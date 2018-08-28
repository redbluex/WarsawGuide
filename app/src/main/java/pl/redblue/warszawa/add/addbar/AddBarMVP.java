package pl.redblue.warszawa.add.addbar;

import pl.redblue.warszawa.bar.Bar;

public interface AddBarMVP  {
    interface View{
        void addElement();
    }
    interface Presenter{
        void addFireBaseElement(Bar bar);
    }
}
