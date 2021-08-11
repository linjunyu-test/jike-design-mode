package cn.linjunyu.v2;

/**
 * Demo class
 *
 * @author LinJn
 * @since 2021/8/11 14:28
 */
public class DefaultApiAuthenticatorImpl implements ApiAuthenticator {

    private final CredentialStorage credentialStorage;

    public DefaultApiAuthenticatorImpl() {
        this.credentialStorage = new MySqlCredentialStorage();
    }

    public DefaultApiAuthenticatorImpl(CredentialStorage credentialStorage) {
        this.credentialStorage = credentialStorage;
    }

    @Override
    public void auth(String url) {

    }

    @Override
    public void auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();
        String originalUrl = apiRequest.getOriginalUrl();
        final AuthToken clientToken = new AuthToken(token, timestamp);
        if (clientToken.isExpired()) {
            throw new RuntimeException("the token is expired");
        }
        final String password = this.credentialStorage.getPasswordByAppId(appId);
        final AuthToken serverToken = AuthToken.create(originalUrl, timestamp, appId, password, null);
        if (!serverToken.match(clientToken)) {
            throw new RuntimeException("Token verfication failed.");
        }
    }
}
