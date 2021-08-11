package cn.linjunyu.v2;

import lombok.Getter;
import lombok.Setter;

/**
 * Demo class
 *
 * @author LinJn
 * @since 2021/8/2 21:13
 */
@Getter
@Setter
public class ApiRequest {

    private String appId;

    private String token;

    private Long timestamp;

    private String originalUrl;
}
