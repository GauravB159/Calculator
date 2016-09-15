package collegework.calculator2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static java.lang.Math.pow;

public class BaseN extends AppCompatActivity {
    public int modeType=2;
    EditText editText1,answer,type;
    Button b,del,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_n);
        type=(EditText)findViewById(R.id.type);
        editText1=(EditText)findViewById(R.id.input1);
        answer=(EditText)findViewById(R.id.answer1);
        del=(Button)findViewById(R.id.clear);
        O=(Button)findViewById(R.id.zero);
        P=(Button)findViewById(R.id.one);
        A=(Button)findViewById(R.id.two);
        B=(Button)findViewById(R.id.three);
        C=(Button)findViewById(R.id.four);
        D=(Button)findViewById(R.id.five);
        E=(Button)findViewById(R.id.six);
        F=(Button)findViewById(R.id.seven);
        G=(Button)findViewById(R.id.eight);
        H=(Button)findViewById(R.id.nine);
        I=(Button)findViewById(R.id.ten);
        J=(Button)findViewById(R.id.eleven);
        K=(Button)findViewById(R.id.twelve);
        L=(Button)findViewById(R.id.thirteen);
        M=(Button)findViewById(R.id.fourteen);
        N=(Button)findViewById(R.id.fifteen);
        setDec(del);
        del.setOnLongClickListener(new View.OnLongClickListener() {

            public boolean onLongClick(View v) {
                editText1.setText("");
                return true;
            }
        });
    }
    public void setBin(View view)
    {
        type.setText("BIN");
        if(TextUtils.isEmpty(editText1.getText())) {
            O.setEnabled(true);
            P.setEnabled(true);
            A.setEnabled(false);
            B.setEnabled(false);
            C.setEnabled(false);
            D.setEnabled(false);
            E.setEnabled(false);
            F.setEnabled(false);
            G.setEnabled(false);
            H.setEnabled(false);
            I.setEnabled(false);
            J.setEnabled(false);
            K.setEnabled(false);
            L.setEnabled(false);
            M.setEnabled(false);
            N.setEnabled(false);
            modeType = 0;
        }
        else {
            switch(modeType)
            {
                case 0:{
                    answer.setText(editText1.getText().toString());
                    break;
                }
                case 1: {
                    answer.setText(octalToBinary(editText1.getText().toString()));
                    break;
                }
                case 2:{
                    answer.setText(decimalToBin(editText1.getText().toString()));
                    break;
                }
                case 3:{
                    answer.setText(hexToBin(editText1.getText().toString()));
                    break;
                }
            }
        }

    }
    public void setOct(View view)
    {
        type.setText("OCT");
        if(TextUtils.isEmpty(editText1.getText())) {
            O.setEnabled(true);
            P.setEnabled(true);
            A.setEnabled(true);
            B.setEnabled(true);
            C.setEnabled(true);
            D.setEnabled(true);
            E.setEnabled(true);
            F.setEnabled(true);
            G.setEnabled(false);
            H.setEnabled(false);
            I.setEnabled(false);
            J.setEnabled(false);
            K.setEnabled(false);
            L.setEnabled(false);
            M.setEnabled(false);
            N.setEnabled(false);
            modeType = 1;
        }
        else {
            switch(modeType)
            {
                case 0:{
                    answer.setText(binaryToOctal(editText1.getText().toString()));
                    break;
                }
                case 1: {
                    answer.setText(editText1.getText().toString());
                    break;
                }
                case 2:{
                    answer.setText(decimalToOctal(editText1.getText().toString()));
                    break;
                }
                case 3:{
                    answer.setText(hexToOct(editText1.getText().toString()));
                    break;
                }
            }
        }
    }
    public void setDec(View view)
    {
        type.setText("DEC");
        if(TextUtils.isEmpty(editText1.getText())) {
            O.setEnabled(true);
            P.setEnabled(true);
            A.setEnabled(true);
            B.setEnabled(true);
            C.setEnabled(true);
            D.setEnabled(true);
            E.setEnabled(true);
            F.setEnabled(true);
            G.setEnabled(true);
            H.setEnabled(true);
            I.setEnabled(false);
            J.setEnabled(false);
            K.setEnabled(false);
            L.setEnabled(false);
            M.setEnabled(false);
            N.setEnabled(false);
            modeType = 2;
        }
        else {
            switch(modeType)
            {
                case 0:{
                    answer.setText(binaryToDecimal(editText1.getText().toString()));
                    break;
                }
                case 1: {
                    answer.setText(octalToDecimal(editText1.getText().toString()));
                    break;
                }
                case 2:{
                    answer.setText(editText1.getText().toString());
                    break;
                }
                case 3:{
                    answer.setText(hexToDec(editText1.getText().toString()));
                    break;
                }
            }
        }
    }
    public void setHex(View view)
    {
        type.setText("HEX");
        if(TextUtils.isEmpty(editText1.getText())) {
        O.setEnabled(true);
        P.setEnabled(true);
        A.setEnabled(true);
        B.setEnabled(true);
        C.setEnabled(true);
        D.setEnabled(true);
        E.setEnabled(true);
        F.setEnabled(true);
        G.setEnabled(true);
        H.setEnabled(true);
        I.setEnabled(true);
        J.setEnabled(true);
        K.setEnabled(true);
        L.setEnabled(true);
        M.setEnabled(true);
        N.setEnabled(true);
        modeType = 3;
    }
    else {
        switch(modeType)
        {
            case 0:{
                answer.setText(binaryToHex(editText1.getText().toString()));
                break;
            }
            case 1: {
                answer.setText(octalToHex(editText1.getText().toString()));
                break;
            }
            case 2:{
                answer.setText(decimalToHex(editText1.getText().toString()));
                break;
            }
            case 3:{
                answer.setText(editText1.getText().toString());
                break;
            }
        }
    }
    }
    public void onClick1(View view) {
        b=(Button)view;
        editText1.setText(editText1.getText().toString()+b.getText().toString());
    }
    static public String binaryToDecimal(String input)
    {
        String answer="";
        int ans=0;
        for(int i=0;i<input.length();i++)
        {
            char bit=input.charAt(i);
            ans=ans+Character.getNumericValue(bit)*(int)pow(2,input.length()-i-1);
        }
        answer=Integer.toString(ans);
        return answer;
    }
    static public String binaryToOctal(String input)
    {
        String answer="";
        answer=binaryToDecimal(input);
        answer=decimalToOctal(answer);
        return answer;
    }
    static public String binaryToHex(String input)
    {
        String answer="";
        answer=binaryToDecimal(input);
        answer=decimalToHex(answer);
        return answer;
    }
    static public String octalToDecimal(String input)
    {
        int answer=0;
        for(int i=0;i<input.length();i++) {
            char bit=input.charAt(i);
            answer=answer+((int)bit-48)*(int)pow(8.0,input.length()-i-1);
        }
        return Integer.toString(answer);
    }
    static public String octalToHex(String input)
    {
        String answer="";
        answer=octalToDecimal(input);
        answer=decimalToHex(answer);
        return answer;
    }
    static public String octalToBinary(String input)
    {
        String answer="";
        answer=octalToDecimal(input);
        answer=decimalToBin(answer);
        return answer;
    }
    static public String decimalToOctal(String input)
    {
        String answer="";
        int inp=Integer.parseInt(input);
        while(inp!=0)
        {
            int remainder=inp%8;
            answer=answer+Integer.toString(remainder);
            inp=inp/8;
        }
        String ans=new StringBuilder(answer).reverse().toString();
        return ans;
    }
    static public String decimalToBin(String input)
    {
        String answer="";
        int inp=Integer.parseInt(input);
        while(inp!=0)
        {
            int remainder=inp%2;
            answer=answer+Integer.toString(remainder);
            inp=inp/2;
        }
        String ans=new StringBuilder(answer).reverse().toString();
        return ans;
    }
    static public String decimalToHex(String input)
    {
        String answer="";
        int inp=Integer.parseInt(input);
        while(inp!=0)
        {
            int remainder=inp%16;
            if(remainder<10)
                answer=answer+Integer.toString(remainder);
            else
            {
                remainder=remainder+55;
                char add=(char)remainder;
                answer=answer+add;
            }
            inp=inp/16;
        }
        String ans=new StringBuilder(answer).reverse().toString();
        return ans;
    }
    static public String hexToDec(String input)
    {
        int answer=0;
        for(int i=0;i<input.length();i++) {
            char bit=input.charAt(i);
            if((int)bit<60)
            {
                answer=answer+((int)bit-48)*(int)pow(16.0,input.length()-i-1);
            }
            else
            {
                answer=answer+((int)bit-55)*(int)pow(16.0,input.length()-i-1);
            }
        }
        return Integer.toString(answer);
    }
    static public String hexToBin(String input)
    {
        String answer="";
        answer=hexToDec(input);
        answer=decimalToBin(answer);
        return answer;
    }
    static public String hexToOct(String input)
    {
        String answer="";
        answer=hexToDec(input);
        answer=decimalToOctal(answer);
        return answer;
    }
    public void onClickD(View view){
        String str= editText1.getText().toString();
        if(str.length()!=0) {
            String result = str.substring(0, str.length() - 1);
            editText1.setText(result);
        }
    }
}
