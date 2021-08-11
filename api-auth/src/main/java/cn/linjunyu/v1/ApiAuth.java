package cn.linjunyu.v1;

/**
 * Demo class
 *
 * @author LinJn
 * @since 2021/8/1 0:06
 */
public interface ApiAuth {

    boolean validTimestamp();

    boolean auth();

}
