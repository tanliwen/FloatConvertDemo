package reverse.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FormatFloatWithTwoDotsImpl implements IFormatFloatWithTwoDots{

    /**
     * 输入数据保留小数点后两位 & 四舍五入
     * @param value
     * @return
     */
    @Override
    public float doFormat(float value) {
        int scale = 2;
        RoundingMode roundingMode = RoundingMode.HALF_UP;
        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal = bigDecimal.setScale(scale, roundingMode);
        return bigDecimal.floatValue();
    }
}
