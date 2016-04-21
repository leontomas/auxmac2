package info.androidhive.materialdesign.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import info.androidhive.materialdesign.activity.lesson.AuxEngine.Assessment;
import info.androidhive.materialdesign.activity.lesson.AuxEngine.Page1;
import info.androidhive.materialdesign.activity.lesson.AuxEngine.Page2;
import info.androidhive.materialdesign.activity.lesson.AuxEngine.Page3;
import info.androidhive.materialdesign.activity.lesson.AuxEngine.Page4;
import info.androidhive.materialdesign.activity.lesson.AuxEngine.Page5;
import info.androidhive.materialdesign.activity.lesson.AuxEngine.Page6;
import info.androidhive.materialdesign.activity.lesson.AuxEngine.Page7;
import info.androidhive.materialdesign.activity.lesson.AuxEngine.Page8;
import info.androidhive.materialdesign.activity.lesson.AuxEngine.Page10;
/**
 * Created on 2/21/2016.
 */
public class AuxEngine_ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public AuxEngine_ViewPagerAdapter(FragmentManager fm,CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if(position == 0) {
            Page1 page1 = new Page1();
            return page1;
        } else if (position == 1) {
            Page2 page2 = new Page2();
            return page2;
        } else if (position == 2) {
            Page3 page3 = new Page3();
            return page3;
        } else if (position == 3) {
            Page4 page4 = new Page4();
            return page4;
        } else if (position == 4) {
            Page5 page5 = new Page5();
            return page5;
        } else if (position == 5) {
            Page6 page6 = new Page6();
            return page6;
        } else if (position == 6) {
            Page7 page7 = new Page7();
            return page7;
        }else if (position == 7) {
            Page8 page8 = new Page8();
            return page8;
        } else if (position == 8) {
            Page10 page10 = new Page10();
            return page10;
        } else {
            Assessment assessment = new Assessment();
            return assessment;
        }
    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}
