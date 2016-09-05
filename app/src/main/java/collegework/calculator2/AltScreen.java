package collegework.calculator2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AltScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alt_screen);
    }
    public void switchMode(View view)
    {
        Intent intent=new Intent(this,startCalc.class);
        startActivity(intent);
    }
}
