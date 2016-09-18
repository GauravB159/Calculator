package collegework.calculator2;

public class Stack {

    private static final int SIZE=100;
    private char[] items=new char[SIZE];
    private double[] nums=new double[SIZE];
    private int top=-1;
    private int topN=-1;

    public void push(char x){
        if(top!=SIZE-1){
            items[++top]=x;
        }
    }

    public char pop(){
        if(top!=-1){
            return items[top--];
        }
        return '\0';
    }


    public char peek(){
        if (top!=-1){
            return items[top];
        }
        return '\0';
    }

    public boolean isEmpty() {
        if(top==-1){
            return true;
        }
        return false;
    }

    public boolean precedence(char c){
        char st=peek();
        switch(st)
        {
            case '+':
            case '-': if( c=='+' || c=='-' || c==')')
                return true;
            else
                return false;

            case '*':
            case '/':
            case '^': if( c=='^' || c=='(')
                return false;
            else
                return true;

            case '(': return false;
            default: return false;
        }
    }

    public void push(double x){
        if(topN!=SIZE-1){
            nums[++topN]=x;
        }
    }

    public double pop(boolean x){
        if(topN!=-1){
            return nums[topN--];
        }
        return 0;
    }
}