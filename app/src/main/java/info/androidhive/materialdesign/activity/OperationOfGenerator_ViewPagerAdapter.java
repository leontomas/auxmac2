package info.androidhive.materialdesign.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.Assessment;
import info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.Page1;
import info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.Page11;
import info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.Page12;
import info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.Page13;
import info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.Page14;
import info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.Page15;
import info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.Page16;
import info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.Page17;
import info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.Page18;
import info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.Page19;
import info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.Page2;
import info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.Page20;
import info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.Page21;
import info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.Page22;
import info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.Page23;
import info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.Page3;
import info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.Page4;
import info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.Page5;
import info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.Page6;
import info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.Page7;
import info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.Page8;
import info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.Page9;
import info.androidhive.materialdesign.activity.lesson.OperationOfGenerator.Page10;
/**
 * Created on 2/21/2016.
 */
public class OperationOfGenerator_ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public OperationOfGenerator_ViewPagerAdapter(FragmentManager fm,CharSequence mTitles[], int mNumbOfTabsumb) {
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
        } else if (position == 7) {
            Page8 page8 = new Page8();
            return page8;
        } else if (position == 8) {
            Page9 page9 = new Page9();
            return page9;
        } else if (position == 9) {
            Page10 page10 = new Page10();
            return page10;
        }else if (position == 10) {
            Page11 page11 = new Page11();
            return page11;
        } else if (position == 11) {
            Page12 page12 = new Page12();
            return page12;
        } else if (position == 12) {
            Page13 page13 = new Page13();
            return page13;
        } else if (position == 13) {
            Page14 page14 = new Page14();
            return page14;
        } else if (position == 14) {
            Page15 page15 = new Page15();
            return page15;
        } else if (position == 15) {
            Page16 page16 = new Page16();
            return page16;
        } else if (position == 16) {
            Page17 page17 = new Page17();
            return page17;
        } else if (position == 17) {
            Page18 page18 = new Page18();
            return page18;
        } else if (position == 18) {
            Page19 page19 = new Page19();
            return page19;
        } else if (position == 19) {
            Page20 page20 = new Page20();
            return page20;
        } else if (position == 20) {
            Page21 page21 = new Page21();
            return page21;
        } else if (position == 21) {
            Page22 page22 = new Page22();
            return page22;
        } else if (position == 22) {
            Page23 page23 = new Page23();
            return page23;
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
