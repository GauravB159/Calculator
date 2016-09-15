package collegework.calculator2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

public class linear2var extends AppCompatActivity {
    static String [][] str;
    static String[] str2;
    static EditText[][] arr;
    static EditText[] arr2;
    static TextView answer;
    Button del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear2var);
        del=(Button)findViewById(R.id.clear);
        arr=new EditText[2][2];
        arr2=new EditText[2];
        str=new String[2][2];
        str2=new String[2];
        arr[0][0]=(EditText)findViewById(R.id.ip1);
        arr[0][1]=(EditText)findViewById(R.id.ip2);
        arr[1][0]=(EditText)findViewById(R.id.ip4);
        arr[1][1]=(EditText)findViewById(R.id.ip5);
        arr2[0]=(EditText)findViewById(R.id.ip3);
        arr2[1]=(EditText)findViewById(R.id.ip6);
        arr[0][0].requestFocus();
        answer=(TextView)findViewById(R.id.ans);
        del.setOnLongClickListener(new View.OnLongClickListener() {

            public boolean onLongClick(View v) {
                clearArr();
                answer.setText("");
                return true;
            }
        });
    }
    void clearArr()
    {
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++)
            {
                arr[i][j].setText("");
            }
        }
        for(int i=0;i<arr2.length;i++)
        {
            arr2[i].setText("");
        }
        answer.setText("");
    }
    public static String[][] convert(EditText[][]a) {
        String [][] str=new String[a.length][a.length];
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[i].length;j++)
            {
                str[i][j]=a[i][j].getText().toString();
            }
        }
        return str;
    }
    public static boolean check(EditText[][]a,EditText[]b)
    {
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[i].length;j++)
            {
                if(a[i][j].getText().toString().isEmpty())
                {
                    return false;
                }
            }
        }
        for(int i=0;i<b.length;i++)
        {
            if(b[i].getText().toString().isEmpty())
            {
                return false;
            }
        }
        return true;
    }
    boolean countdot(String input)
    {
        for(int i=0;i<input.length();i++)
        {
            if(input.charAt(i)=='.')
            {
                return false;
            }
        }
        return true;
    }
    public void onClicker(View view)
    {
        View et = getCurrentFocus();
        EditText current = (EditText) et;
        Button b=(Button)findViewById(view.getId());
        if(b.getText().toString().equals("-"))
        {
            if(current.getText().toString().isEmpty()) {
                current.setText(current.getText().toString() + b.getText().toString());
            }

        }
        else if(b.getText().toString().equals("."))
        {
            if(countdot(current.getText().toString())&&(!current.getText().toString().isEmpty())) {
                current.setText(current.getText().toString() + b.getText().toString());
            }
        }
        else{
            current.setText(current.getText().toString() + b.getText().toString());
        }
    }
    void onClear(View view){
        EditText current=(EditText)getCurrentFocus();
        current.setText("");
    }
    public static String[] convert(EditText[]a) {
        String [] str=new String[a.length];
        for(int i=0;i<a.length;i++)
        {
                str[i]=a[i].getText().toString();
        }
        return str;
    }
    public static void equals(View view)
    {
        if (check(arr, arr2)) {
            str = convert(arr);
            str2 = convert(arr2);
            String ans = "";
            ans = LinearSolve(str, str2, 2);
            answer.setText(ans);
        }
        else
        {
            answer.setText("Fill all variables");
        }
    }
    public static String LinearSolve(String[][] a, String[] b, int m)
    {
        String ans="",result="";
        for (int i = 0; i < m; i++)
        {
            double ko = Double.parseDouble(a[i][i]);
            for (int j = 0; j < m; j++)
            {
                double k1=Double.parseDouble(a[i][j]);
                k1 = k1 / ko;
                a[i][j]=Double.toString(k1);
            }
            double k2=Double.parseDouble(b[i]);
            k2 = k2 / ko;
            b[i]=Double.toString(k2);
            for (int k = 0; k < m; k++)
            {
                if (k == i)
                {
                    continue;
                }
                double d = Double.parseDouble(a[k][i]);
                double k3= Double.parseDouble(b[k]);
                k3 = k3 - d * k2;
                b[k]=Double.toString(k3);
                for (int l = 0; l < m; l++)
                {
                    double k4,k5;
                    k4=Double.parseDouble(a[k][l]);
                    k5=Double.parseDouble(a[i][l]);
                    k4 = k4 - d * k5;
                    a[k][l]=Double.toString(k4);
                }
            }
        }
        boolean hasUniqueSolution = false;
        if (Double.isInfinite(Double.parseDouble(b[0])))
        {
           ans="No solutions";
        }
        else if (Double.isNaN(Double.parseDouble(b[0])))
        {
            ans="Infinite solutions";
        }
        else
        {
            hasUniqueSolution = true;
        }
        if (hasUniqueSolution == true)
        {
            char c=(char)88;
            for (int i = 0; i < m; i++)
            {
                double totrunc=Double.parseDouble(b[i]);
                Double truncatedDouble = new BigDecimal(totrunc)
                        .setScale(3, BigDecimal.ROUND_HALF_UP)
                        .doubleValue();
                String bc=Double.toString(truncatedDouble);
                ans=ans+Character.toString(c)+" : "+bc+" ";
                c++;
            }
        }
        return ans;
    }
}

