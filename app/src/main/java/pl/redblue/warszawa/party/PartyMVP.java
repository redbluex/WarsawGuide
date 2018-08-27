package pl.redblue.warszawa.party;

import java.util.List;

public interface PartyMVP {
    interface View{
        void setAdapterList();
    }
    interface Presenter{
        List<Party> getParties();
        void loadFireBaseDate();
    }
}
