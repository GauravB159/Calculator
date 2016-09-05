package bhaskarbarua.calc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends FragmentActivity {

    private static final int NUM_PAGES = 2;

    private ViewPager viewPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter pagerAdapter;

    EditText editText1,editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate a ViewPager and a PagerAdapter.
        viewPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        editText1 = (EditText) findViewById(R.id.input);
        editText2 = (EditText) findViewById(R.id.answer);
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }




    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0)
                return new MainFragment();
            else if (position == 1)
                return new RightFragment();
            else
                return null;
        }
        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
    public void onClick0(View view) {
        editText1.setText(editText1.getText()+"0");
    }
    public void onClick1(View view) {
        editText1.setText(editText1.getText()+"1");
    }
    public void onClick2(View view) {
        editText1.setText(editText1.getText()+"2");
    }
    public void onClick3(View view) {
        editText1.setText(editText1.getText()+"3");
    }
    public void onClick4(View view) {
        editText1.setText(editText1.getText()+"4");
    }
    public void onClick5(View view) {
        editText1.setText(editText1.getText()+"5");
    }
    public void onClick6(View view) {
        editText1.setText(editText1.getText()+"6");
    }
    public void onClick7(View view) {
        editText1.setText(editText1.getText()+"7");
    }
    public void onClick8(View view) {
        editText1.setText(editText1.getText()+"8");
    }
    public void onClick9(View view) {
        editText1.setText(editText1.getText()+"9");
    }
    public void onClickAdd(View view) {
        editText1.setText(editText1.getText()+"+");
    }
    public void onClickSub(View view) {
        editText1.setText(editText1.getText()+"-");
    }
    public void onClickMultiply(View view) {
        editText1.setText(editText1.getText()+"X");
    }
    public void onClickDivide(View view) {
        editText1.setText(editText1.getText()+"0");
    }
    public void onClickPower(View view) {
        editText1.setText(editText1.getText()+"^");
    }
    public void onClickModulus(View view) {
        editText1.setText(editText1.getText()+"%");
    }
    public void onClickDot(View view) {
        editText1.setText(editText1.getText()+".");
    }
    public void onClickEquals(View view) {
        double result=calculate(String.valueOf(editText1.getText()));
        editText2.setText(String.valueOf(result));
    }

    double calculate(String input) {
        double result=0;

        //write code here

        return result;
    }
}




