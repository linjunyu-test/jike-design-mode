package cn.linjunyu.v1;

/**
 * Demo class
 *
 * @author LinJn
 * @since 2021/8/1 0:12
 */
public class LocalApiAuth extends AbstractApiAuth {

    private final ApiAppIdStorage apiAppIdStorage;

    LocalApiAuth(ApiAuthInfo apiAuthInfo, ApiAppIdStorage apiAppIdStorage) {
        super(apiAuthInfo);
        this.apiAppIdStorage = apiAppIdStorage;
    }

    @Override
    public boolean validAppId(String appId) {
        return this.apiAppIdStorage.validAppId(appId);
    }

    @Override
    public String getSecretByAppId(String appId) {
        return this.apiAppIdStorage.getSecretByAppId(appId);
    }
}
