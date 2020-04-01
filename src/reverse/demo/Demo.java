package reverse.demo;

/**
 * 给定一个float值（精确到0.00），将其整型部分和小数部分分别倒序调整，比如：-12.34 –> -21.43
 *
 * 实现情况说明:
 * 1.保留小数点后两位,四舍五入
 * 2.浮点数过大, java 自带Float 转 String 为科学表达式, 还原Float时存在问题, BigDecimal 转  String存在精度丢失的问题
 * 暂不支持
 */
public class Demo {
    public static void main(String[] args) {
        IFloatHeadWithBodyReverse iSplitFloatHeadWithBody = new FloatHeadWithBodyReverseStringImpl();
        System.out.println(iSplitFloatHeadWithBody.doSplit(0f));
        System.out.println(iSplitFloatHeadWithBody.doSplit(-12.34f));
        System.out.println(iSplitFloatHeadWithBody.doSplit(-12f));
        System.out.println(iSplitFloatHeadWithBody.doSplit(-12.12f));
        System.out.println(iSplitFloatHeadWithBody.doSplit(12.144f));
        System.out.println(iSplitFloatHeadWithBody.doSplit(-12.145f));
        System.out.println(iSplitFloatHeadWithBody.doSplit(0.12f));
    }
}
