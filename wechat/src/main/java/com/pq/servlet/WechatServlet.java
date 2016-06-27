package com.pq.servlet;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by PQ on 2016/6/26.
 */
@javax.servlet.annotation.WebServlet(name = "WechatServlet")
public class WechatServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        String hello = "WanJun,how are you!!";

        String result = getMessage();
        System.out.println("xml : " + result);
        PrintWriter out = response.getWriter();
        out.write(getMessage());
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

    private String getMessage(){
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[oOKhJwJAGjkw81HNYxkmR8eIpoOU]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[gh_b228ff5a4b01]]></FromUserName>");
        sb.append("<CreateTime>12345678</CreateTime>");
        sb.append("<MsgType><![CDATA[text]]></MsgType>");
        sb.append("<Content><![CDATA[WanJun, how are you]]></Content>");
        sb.append("</xml>");
        return sb.toString();
    }
}
