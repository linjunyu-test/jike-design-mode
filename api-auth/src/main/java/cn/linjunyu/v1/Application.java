package cn.linjunyu.v1;

/**
 * Demo class
 *
 * @author LinJn
 * @since 2021/8/1 0:15
 */
public class Application {

    public static void main(String[] args) {
        String url = "http://linjun.cn?AppId=aa&timestamp=bb&token=cc";
        final ApiAuthInfo apiAuthInfo = ApiAuthInfo.parse(url);
        ApiAppIdStorage apiAppIdStorage = new LocalApiAppIdStorage();
        final ApiAuth apiAuth = new LocalApiAuth(apiAuthInfo, apiAppIdStorage);
        if (!apiAuth.validTimestamp()) {
            System.out.println("时间窗口验证失败");
        }
        if (apiAuth.auth()) {
            System.out.println("token 验证失败");
        }
        System.out.println("api 接口验证成功");
    }

}
