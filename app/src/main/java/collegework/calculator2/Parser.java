package collegework.calculator2;

public class Parser {


    public static double evaluate(String infix)
    {
        Stack stack=new Stack();
        String temp = null;
        char c;
        int j,k;
        for (int i=0; i<infix.length(); i++)
        {
            c=infix.charAt(i);
            if (Character.isDigit(c)||c=='.')
            {
                if (temp==null){
                    temp=Character.toString(c);
                }
                else{
                    temp=temp+Character.toString(c);
                }
                if ((i!=infix.length()-1)&&(Character.isDigit(infix.charAt(i+1))||infix.charAt(i+1)=='.'))
                {
                    continue;
                }
                else
                {
                    stack.push(Double.parseDouble(temp));
                    temp=null;
                }
            }
            else if (Character.isLetter(c))
            {
                j=i+1;
                k=0;
                while (!(infix.charAt(j)=='|'&&k==0))
                {
                    if (temp==null){
                        temp=Character.toString(infix.charAt(j));
                    }
                    else
                    {
                        temp=temp+Character.toString(infix.charAt(j));
                    }
                    if (Character.isLetter(infix.charAt(j)))
                    {
                        k++;
                    }
                    if (infix.charAt(j)=='|')
                    {
                        k--;
                    }
                    j++;
                }
                i=j;
                switch(c)
                {
                    case 'a':
                        //factorial
                        break;
                    case 'b':
                        stack.push(Math.log(Parser.evaluate(temp)));
                        break;
                    case 'c':
                        stack.push(Math.log10(Parser.evaluate(temp)));
                        break;
                    case 'd':
                        //log of var base
                        break;
                    case 'e':
                        stack.push(Math.sqrt(Parser.evaluate(temp)));
                        break;
                    case 'f':
                        //nth root
                        break;
                    case 'g':
                        //nCr
                        break;
                    case 'h':
                        //pCr
                        break;
                    case 'i':
                        //complex
                        break;
                    case 'j':
                        stack.push(Math.sin(Parser.evaluate(temp)));
                        break;
                    case 'k':
                        stack.push(Math.cos(Parser.evaluate(temp)));
                        break;
                    case 'l':
                        stack.push(Math.tan(Parser.evaluate(temp)));
                        break;
                    case 'm':
                        stack.push(Math.asin(Parser.evaluate(temp)));
                        break;
                    case 'n':
                        stack.push(Math.acos(Parser.evaluate(temp)));
                        break;
                    case 'o':
                        stack.push(Math.atan(Parser.evaluate(temp)));
                        break;
                    case 'p':
                        stack.push(Math.sinh(Parser.evaluate(temp)));
                        break;
                    case 'q':
                        stack.push(Math.cosh(Parser.evaluate(temp)));
                        break;
                    case 'r':
                        stack.push(Math.tanh(Parser.evaluate(temp)));
                        break;
                    case 's':
                        //asinh
                        break;
                    case 't':
                        //acosh
                        break;
                    case 'u':
                        //atanh
                        break;
                    case 'v':
                        //integration
                        break;
                    case 'w':
                        //diff
                        break;
                    case 'x':
                        //summation
                        break;
                }
                temp=null;
            }
            else
            {
                if (stack.isEmpty())
                {
                    stack.push(c);
                }
                else
                {
                    while (stack.precedence(c)&&!stack.isEmpty())
                    {
                        operation(stack.pop(),stack);
                    }
                    if (c==')')
                    {
                        stack.pop();
                    }
                    else stack.push(c);
                }
            }
        }
        while(!stack.isEmpty())
        {
            operation(stack.pop(),stack);
        }
        return(stack.pop(true));
    }

    private static void operation(char c,Stack stack) {
        double b=stack.pop(true);
        double a=stack.pop(true);
        switch (c)
        {
            case '+':
                stack.push(a+b);
                break;
            case '-':
                stack.push(a-b);
                break;
            case '*':
                stack.push(a*b);
                break;
            case '/':
                stack.push(a/b);
                break;
            case '^':
                stack.push(Math.pow(a,b));
                break;
        }
    }
    public static double evaluate(String infix,double x){
        infix=infix.replaceAll("x",Double.toString(x));
        return evaluate(infix);
    }
}
