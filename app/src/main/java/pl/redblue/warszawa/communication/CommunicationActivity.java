package pl.redblue.warszawa.communication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import pl.redblue.warszawa.R;

public class CommunicationActivity extends AppCompatActivity {

    FragmentPagerAdapter adapterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);
        ViewPager viewPager = (ViewPager)findViewById(R.id.vpPager);
        adapterView = new ComTabsPagerAdapter(getSupportFragmentManager());
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        viewPager.setAdapter(adapterView);

    }

}
