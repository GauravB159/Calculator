package collegework.calculator2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Equations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equations);
    }
    public void switchLinear(View view)
    {
        Intent intent=new Intent(this,linear2var.class);
        startActivity(intent);
    }
    public void switchLinear3(View view)
    {
        Intent intent=new Intent(this,linearvar3.class);
        startActivity(intent);
    }
    public void switchLinear4(View view)
    {
        Intent intent=new Intent(this,linearvar4.class);
        startActivity(intent);
    }
}
