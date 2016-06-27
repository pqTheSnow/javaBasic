import com.pq.util.WechatUtil;

/**
 * Created by PQ on 2016/6/26.
 */
public class Test {
    public static void main(String[] args) {
        //String accesstoken = WechatUtil.getAccessToken();
        //System.out.println("token = " + accesstoken);
        String token = "8Tfc_J-Zl40zPRDseB2Niy_ugbU5qjb7YA9_B84zLoFg5TZ1wh-kuig3FJ_HKRmrWvwvZkljAlzRP-TlBUVG3nezWVFRndl8_92Pzr1BhLvtN-3kHKYm7oOwboduuGy-FCVgCFAYVO";
        String result = WechatUtil.sendTemplateMessage(getMessage(), token);
        System.out.println(result);
    }

    public static String getMessage(){
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append("\"touser\":\"oOKhJwJAGjkw81HNYxkmR8eIpoOU\",\n");
        sb.append("\"template_id\":\"cgG8S2Y-5Xec_bWikBpRjzoBgzdpUXAEUwX4GRpVfuE\",\n");
        sb.append("\"url\":\"http://www.baidu.com\",");
        sb.append("\"data\":{\n");
        sb.append("\"mesage\": {\n");
        sb.append("\"value\":\"hi!!!\",");
        sb.append("\"color\":\"#173177\"\n");
        sb.append("}");
        sb.append("}");
        sb.append("}");
        return sb.toString();
    }
}
