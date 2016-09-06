package collegework.calculator2;

class Regex {

    public static String convert(String text) {
        String convert=text;
        convert=convert.replaceAll("plus", "+");
        convert=convert.replaceAll("add", "+");
        convert=convert.replaceAll("added to", "+");
        convert=convert.replaceAll("subtracted by", "-");
        convert=convert.replaceAll("minus", "-");
        convert=convert.replaceAll("raised to", "^");
        convert=convert.replaceAll("raise to", "^");
        convert=convert.replaceAll("raises to", "^");
        convert=convert.replaceAll("raised by", "^");
        convert=convert.replaceAll("raises", "^");
        convert=convert.replaceAll("to the power", "^");
        convert=convert.replaceAll("power", "^");
        convert=convert.replaceAll("divide by", "/");
        convert=convert.replaceAll("divided by", "/");
        convert=convert.replaceAll("divided", "/");
        convert=convert.replaceAll("divides", "/");
        convert=convert.replaceAll("divide", "/");
        convert=convert.replaceAll("upon", "/");
        convert=convert.replaceAll("into", "*");
        convert=convert.replaceAll("muliplied by", "*");
        convert=convert.replaceAll("muliplied to", "*");
        convert=convert.replaceAll("muliplies", "*");
        convert=convert.replaceAll("muliply", "*");
        convert=convert.replaceAll("by", "*");
        String temp=convert;
        convert=convert.replaceAll("the whole",")");
        if (!convert.equals(temp)){
            convert="("+convert;
        }
        convert=convert.replaceAll(" ", "");
        convert=convert.replaceAll("to","2");

        char c;
        for (int i=0;i<convert.length();i++){
           c= convert.charAt(i);
            if (!(Character.isDigit(c)||c=='+'||c=='-'||c=='*'||c=='/'||c=='^'||c=='('||c==')')){
                return null;
            }
        }
        return convert;
    }
}
