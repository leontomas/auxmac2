package info.androidhive.materialdesign.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Assessment;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page1;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page11;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page12;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page13;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page14;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page15;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page16;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page17;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page18;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page19;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page2;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page20;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page21;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page22;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page23;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page24;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page25;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page26;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page27;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page28;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page29;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page3;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page30;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page31;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page32;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page33;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page34;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page35;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page36;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page37;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page38;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page39;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page4;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page40;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page41;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page42;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page43;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page44;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page45;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page5;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page6;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page7;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page8;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page9;
import info.androidhive.materialdesign.activity.lesson.FreshWaterGenerator.Page10;
/**
 * Created on 2/21/2016.
 */
public class FreshWaterGenerator_ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public FreshWaterGenerator_ViewPagerAdapter(FragmentManager fm,CharSequence mTitles[], int mNumbOfTabsumb) {
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
        } else if (position == 10) {
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
        }else if (position == 17) {
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
        } else if (position == 23) {
            Page24 page24 = new Page24();
            return page24;
        } else if (position == 24) {
            Page25 page25 = new Page25();
            return page25;
        } else if (position == 25) {
            Page26 page26 = new Page26();
            return page26;
        } else if (position == 26) {
            Page27 page27 = new Page27();
            return page27;
        } else if (position == 27) {
            Page28 page28 = new Page28();
            return page28;
        } else if (position == 28) {
            Page29 page29 = new Page29();
            return page29;
        } else if (position == 29) {
            Page30 page30 = new Page30();
            return page30;
        } else if (position == 30) {
            Page31 page31 = new Page31();
            return page31;
        } else if (position == 31) {
            Page32 page32 = new Page32();
            return page32;
        } else if (position == 32) {
            Page33 page33 = new Page33();
            return page33;
        } else if (position == 33) {
            Page34 page34 = new Page34();
            return page34;
        } else if (position == 34) {
            Page35 page35 = new Page35();
            return page35;
        } else if (position == 35) {
            Page36 page36 = new Page36();
            return page36;
        } else if (position == 36) {
            Page37 page37 = new Page37();
            return page37;
        } else if (position == 37) {
            Page38 page38 = new Page38();
            return page38;
        } else if (position == 38) {
            Page39 page39 = new Page39();
            return page39;
        } else if (position == 39) {
            Page40 page40 = new Page40();
            return page40;
        } else if (position == 40) {
            Page41 page41 = new Page41();
            return page41;
        } else if (position == 41) {
            Page42 page42 = new Page42();
            return page42;
        } else if (position == 42) {
            Page43 page43 = new Page43();
            return page43;
        } else if (position == 43) {
            Page44 page44 = new Page44();
            return page44;
        } else if (position == 44) {
            Page45 page45 = new Page45();
            return page45;
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
