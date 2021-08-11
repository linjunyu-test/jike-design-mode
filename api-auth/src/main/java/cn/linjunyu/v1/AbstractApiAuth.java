package cn.linjunyu.v1;

/**
 * Demo class
 *
 * @author LinJn
 * @since 2021/8/1 0:07
 */
public abstract class AbstractApiAuth implements ApiAuth {

    private static final Long TIME_WINDOW = 60000L;

    private final ApiAuthInfo apiAuthInfo;

    AbstractApiAuth(ApiAuthInfo apiAuthInfo) {
        this.apiAuthInfo = apiAuthInfo;
    }

    @Override
    public boolean validTimestamp() {
        return apiAuthInfo.getTimestamp() + TIME_WINDOW < apiAuthInfo.getTimestamp();
    }

    @Override
    public boolean auth() {
        final boolean validAppId = validAppId(apiAuthInfo.getAppId());
        if (!validAppId) {
            return false;
        }
        final String secret = this.getSecretByAppId(apiAuthInfo.getAppId());
        this.apiAuthInfo.setSecret(secret);
        final String token = ApiTokenAlgorithm.token(apiAuthInfo);
        return token.equals(apiAuthInfo.getToken());
    }

    public abstract boolean validAppId(String appId);

    public abstract String getSecretByAppId(String appId);
}
