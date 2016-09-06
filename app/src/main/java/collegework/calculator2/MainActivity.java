package collegework.calculator2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends FragmentActivity {

    private static final int NUM_PAGES = 3;

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
        viewPager.setCurrentItem(1);
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
     * A simple pager adapter that represents 3 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 1)
                return new MainFragment();
            else if (position == 2)
                return new RightFragment();
            else if (position==0)
                return new LeftFragment();
            else
                return null;
        }
        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
    public void onClick0(View view) {
        Button b=(Button)view;
        editText1.setText(editText1.getText()+b.getText().toString());
    }
    public void onClickEquals(View view) {
        double result=calculate(String.valueOf(editText1.getText()));
        editText2.setText(String.valueOf(result));
    }
    public void onClickReset(View view){
        editText1.setText("");
    }
    public void onClickDel(View view){
        String str= editText1.getText().toString();
        if(str.length()!=0) {
            String result = str.substring(0, str.length() - 1);
            editText1.setText(result);
        }
    }
    double calculate(String input) {
        double result=0;

        //write code here

        return result;
    }
}




