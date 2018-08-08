package pl.redblue.warszawa.communication;

import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.content.Intent;

import pl.redblue.warszawa.R;

public class ComTabsPagerAdapter extends FragmentPagerAdapter {


    public ComTabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Tickets();
            case 1:
                return new ZoneFragment();
            case 2:
                return new AirportCommunication();
            default:
        }       return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Tickets";
            case 1:
                return "Zones";
            case 2:
                return "Airport";
            default:
                return null;
        }
    }
}
