package com.wdqsoft.system.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 请求服务的request中的网络信息
 *
 */
@Slf4j
public class RequestNetUtil {
    public static JSONObject getIpAddr(HttpServletRequest request) {
        JSONObject requestObject=new JSONObject();
        String ipAddress = "";
        String type="";
        String url="";
        String method="";
//        String statuCode="statuCode";
        //方法返回请求行中的参数部分（参数名+值）
        String queryString="";

        try {
            ipAddress = request.getHeader("x-forwarded-for");
             type="x-forwarded-for";
             url=request.getRequestURI();
             method=request.getMethod();
            queryString=request.getQueryString();
//            statuCode=request.getHeader("status");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
                type="Proxy-Client-IP";
                url=request.getRequestURI();
                method=request.getMethod();
                queryString=request.getQueryString();
//                statuCode=request.getHeader("status");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
                type="WL-Proxy-Client-IP";
                url=request.getRequestURI();
                method=request.getMethod();
                queryString=request.getQueryString();
//                statuCode=request.getHeader("status");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                type="getRemoteAddr()";
                url=request.getRequestURI();
                method=request.getMethod();
                queryString=request.getQueryString();
//                statuCode=request.getHeader("status");
                if (ipAddress.equals("127.0.0.1")) {
                    // 根据网卡取本机配置的IP
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    ipAddress = inet.getHostAddress();
                    type="ipAddress.equals(127.0.0.1)";
                    url=request.getRequestURI();
                    method=request.getMethod();
                    queryString=request.getQueryString();
//                    statuCode=request.getHeader("status");
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
                // = 15
                if (ipAddress.indexOf(",") > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch (Exception e) {
            ipAddress="";
        }
        // ipAddress = this.getRequest().getRemoteAddr();
        requestObject.put("type",type);
        requestObject.put("ipAddress",ipAddress);
        requestObject.put("url",url);
        requestObject.put("method",method);
        requestObject.put("queryString",queryString);
//        requestObject.put("statuCode",statuCode);
        requestObject.put("date",DateUtils.getCurrentDateYYYYMMDD(""));
        log.info(requestObject.toJSONString());
        return requestObject;
    }

    public static String getIpAddrString(HttpServletRequest request) {

        return getIpAddr( request).toJSONString();
    }

//    public static TCmsRequestlog getIpAddrOb(HttpServletRequest request) {
//        JSONObject object= getIpAddr( request);
//        TCmsRequestlog requestlog=new TCmsRequestlog();
//        requestlog.setIp(object.getString("id"));
//        requestlog.setMethod(object.getString("method"));
//        requestlog.setDate(object.getString("date"));
//        requestlog.setIp(object.getString("ipAddress"));
//        requestlog.setUrl(object.getString("url"));
//
//        requestlog.setContent(Base64Utils.setEncodeBase64(object.toJSONString()));
//
//        return requestlog;
//    }
}

