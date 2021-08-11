package cn.linjunyu.v1;

/**
 * Demo class
 *
 * @author LinJn
 * @since 2021/7/31 23:54
 */
public interface ApiAppIdStorage {

    boolean validAppId(String appId);

    String getSecretByAppId(String appId);

}
