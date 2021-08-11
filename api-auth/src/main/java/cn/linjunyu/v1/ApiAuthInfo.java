package cn.linjunyu.v1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 这个类还负责解析 url ，很明显是不对的
 *
 * @author LinJn
 * @since 2021/7/31 23:36
 */
@Getter
@Setter
@ToString
public class ApiAuthInfo {

    private String api;

    private String appId;

    private String secret;

    private Long timestamp;

    private String token;

    public static ApiAuthInfo parse(String url) {
        // 先验证一下是否是 url
        // 解析成对应的数据
        return new ApiAuthInfo();
    }

}
