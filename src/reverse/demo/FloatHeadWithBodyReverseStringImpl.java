package reverse.demo;

public class FloatHeadWithBodyReverseStringImpl implements IFloatHeadWithBodyReverse {

    private IFormatFloatWithTwoDots iFormatFloatWithTwoDots = new FormatFloatWithTwoDotsImpl();

    private IReverseString iReverseString = new IReverseStringImpl();

    private static final boolean DEBUG = false;

    @Override
    public float doSplit(float data) {
        //前处理
        data = iFormatFloatWithTwoDots.doFormat(data);
        boolean isNegative = false;
        if (data < 0) {
            isNegative = true;
            //可能造成精度丢失
            data = data * -1;
        }

        //TODO 优化科学计数的问题，待解决
        String strData = Float.toString(data);
//        String strData =  new BigDecimal(data).setScale(2, RoundingMode.UP).toString(); 存在精度丢失的问题

        if (DEBUG) {
            System.out.println("floatString = " + strData);
        }

        String[] headWithBodyArray = strData.split("\\.");
        if (headWithBodyArray.length == 2) {
            if (headWithBodyArray[1].contains("E") || headWithBodyArray[1].contains("e") || headWithBodyArray[0].contains("E") || headWithBodyArray[0].contains("e")) {
                if (DEBUG) {
                    System.out.println("originHead: " + headWithBodyArray[0]);
                    System.out.println("originBody: " + headWithBodyArray[1]);
                }
                throw new IllegalArgumentException("不支持科学计算的表达式");
            }

            String reverseHead = iReverseString.doReverse(headWithBodyArray[0]);
            String reverseBody = iReverseString.doReverse(headWithBodyArray[1]);
            if (reverseBody.equals("")) {
                reverseBody = "00";
            }
            if (DEBUG) {
                System.out.println("reverseHead: " + reverseHead);
                System.out.println("reverseBody: " + reverseBody);
            }
            if (!isNegative) {
                return Float.parseFloat(reverseHead + "." + reverseBody);
            } else {
                return Float.parseFloat("-" + reverseHead + "." + reverseBody);
            }
        } else {
            throw new IllegalArgumentException("不存在小数点，处理异常情况检查");
        }
    }
}
