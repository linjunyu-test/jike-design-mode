package cn.linjunyu.v2;

/**
 * Demo class
 *
 * @author LinJn
 * @since 2021/8/11 14:26
 */
public interface ApiAuthenticator {

    void auth(String url);

    void auth(ApiRequest apiRequest);
}
