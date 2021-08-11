package cn.linjunyu.v2;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Demo class
 *
 * @author LinJn
 * @since 2021/8/2 21:31
 */
public class AuthToken {

    private static final long DEFAULT_EXPIRED_INTERVAL = 60 * 1000L;

    private final String token;

    private final Long createTime;

    private long expiredInterval = DEFAULT_EXPIRED_INTERVAL;

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }


    public AuthToken(String token, long createTime, long expiredInterval) {
        this.token = token;
        this.createTime = createTime;
        this.expiredInterval = expiredInterval;
    }

    public static AuthToken create(String api,
                                   Long createTime,
                                   String appId,
                                   String password,
                                   Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        sb.append(api);
        sb.append(createTime);
        sb.append(appId);
        sb.append(password);
        if (params != null && !params.isEmpty()) {
            for (String value : params.values().stream().sorted().collect(Collectors.toList())) {
                sb.append(value);
            }
        }
        try {
            final String token = URLDecoder.decode(sb.toString(), "UTF-8");
            return new AuthToken(token, createTime);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public String getToken() {
        return this.token;
    }

    public boolean isExpired() {
        return this.createTime + expiredInterval > System.currentTimeMillis();
    }

    public boolean match(AuthToken authToken) {
        return this.token.equals(authToken.getToken());
    }
}
