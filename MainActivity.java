package bhaskarbarua.calc;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;


public class MainActivity extends FragmentActivity implements TextToSpeech.OnInitListener {

    private static final int NUM_PAGES = 3;
    private ViewPager viewPager;

    private TextToSpeech textToSpeech;
    private String textInput;

    private double result;

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

        textToSpeech = new TextToSpeech(this, this);
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
        editText1.setText(editText1.getText().toString()+b.getText().toString());
    }
    public void onClickEquals(View view) {
        result=calculate(String.valueOf(editText1.getText()));
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

    public void switchModeBasen(View view) {
        Intent intent=new Intent(this,BaseN.class);
        startActivity(intent);

    }




    // When the app closes shutdown text to speech
    @Override
    public void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }

    // Initializes text to speech capability
    @Override
    public void onInit(int status) {
        // Check if TextToSpeech is available
        if (status == TextToSpeech.SUCCESS) {

            int result = textToSpeech.setLanguage(Locale.getDefault());

            // If language data or a specific language isn't available error
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(this, "Language Not Supported", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Text To Speech Failed", Toast.LENGTH_SHORT).show();
        }

    }

    // Speaks the selected text using the correct voice for the language
    public void readTheText(View view) {

        // Set the voice to use
        textToSpeech.setLanguage(Locale.getDefault());

        textToSpeech.speak(textInput, TextToSpeech.QUEUE_FLUSH, null);
    }

    // Converts speech to text
    public void acceptSpeechInput(View view) {

        // Starts an Activity that will convert speech to text
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        // Use a language model based on free-form speech recognition
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        // Recognize speech based on the default speech of device
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        // Prompt the user to speak
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_input_phrase));

        try {

            startActivityForResult(intent, 100);

        } catch (ActivityNotFoundException e) {

            Toast.makeText(this, getString(R.string.stt_not_supported_message), Toast.LENGTH_LONG).show();

        }
    }

    // The results of the speech recognizer are sent here
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // 100 is the request code sent by startActivityForResult
        if ((requestCode == 100) && (data != null) && (resultCode == RESULT_OK)) {

            // Store the data sent back in an ArrayList
            ArrayList<String> spokenText = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            // Put the spoken text in the EditText

            textInput = spokenText.get(0);

            String input=Regex.convert(textInput);
            if (input!=null) {

                editText1.setText(input);
                editText2.setText(String.valueOf(result));

                textToSpeech.setLanguage(Locale.US);

                textToSpeech.speak(textInput + " is equal to " + result, TextToSpeech.QUEUE_FLUSH, null);
            }
            else{
                Toast.makeText(MainActivity.this, "Not a valid expression!", Toast.LENGTH_LONG).show();
            }
        }
    }
}

