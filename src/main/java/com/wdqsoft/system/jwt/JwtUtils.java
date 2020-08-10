package com.wdqsoft.system.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
@Slf4j
@Data
@Component
@ConfigurationProperties(prefix = "jwtconfig.jwt")
public class JwtUtils {
    private String secret;//秘钥
    private long expire;//超时时间
    private String header;

    /**
     * token生成器
     * @param userId
     * 为了区分系统  userid 的规范 后台管理系统  cms-userid
     * 移动办公系统 moa-userid-username-loginname
     * @return
     */
    public String generateToken(String userId){

        Date nowDate=new Date();
        Date exporeDate=new Date(nowDate.getTime()+expire*1000);

        return Jwts.builder()
                .setHeaderParam("type","JWT")
                .setSubject(userId)
                .setIssuedAt(nowDate)
                .setExpiration(exporeDate)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact()
                ;
    }

    public Claims getClaimByToken(String token){
        try {
            return Jwts.parser().setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            log.info("validate is token error"+e);
            return null;
        }
    }

    /**
     * 判断token是否过期
     * @param expiration
     * @return true 过期
     */
    public boolean isTokenExpired(Date expiration){
        return expiration.before(new Date());
    }

}
