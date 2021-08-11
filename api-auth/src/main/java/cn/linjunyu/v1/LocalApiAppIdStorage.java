package cn.linjunyu.v1;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Demo class
 *
 * @author LinJn
 * @since 2021/7/31 23:58
 */
public class LocalApiAppIdStorage implements ApiAppIdStorage {

    private ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();


    @Override
    public boolean validAppId(String appId) {
        return map.containsKey(appId);
    }

    @Override
    public String getSecretByAppId(String appId) {
        return map.get(appId);
    }
}
