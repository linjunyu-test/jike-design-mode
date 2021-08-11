package cn.linjunyu.v1;


/**
 * Demo class
 *
 * @author LinJn
 * @since 2021/7/31 23:42
 */
public class ApiTokenAlgorithm {

    private ApiTokenAlgorithm() {}

    public static String token(ApiAuthInfo apiAuthInfo) {
        return "token";
    }

    public static String token(String api, String appId, String secret, Long timestamp) {
        return "token";
    }

}
