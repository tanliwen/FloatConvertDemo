package reverse.demo;

public class IReverseStringImpl implements IReverseString{

    @Override
    public String doReverse(String data) {
        StringBuilder sb = new StringBuilder();
        for (int i = data.length() - 1; i >= 0; i--) {
            char indexChar = data.charAt(i);
            if (indexChar != '0' ) {
                sb.append(indexChar);
            }
        }
        return sb.toString();
    }
}
