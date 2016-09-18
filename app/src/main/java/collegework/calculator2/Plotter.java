package collegework.calculator2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Plotter extends AppCompatActivity {

    FunctionPlotter view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new FunctionPlotter(this);
        setContentView(view);
    }
}