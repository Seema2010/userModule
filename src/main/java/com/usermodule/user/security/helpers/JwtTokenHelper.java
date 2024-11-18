package com.usermodule.user.security.helpers;

import com.usermodule.user.constants.MessageConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenHelper {

    @Value("${jwt.access-Token-Validity}")
    private int accessTokenValiditySeconds;

    @Value("${jwt.token-key}")
    private String tokenKey;

    private static final Logger LOG = LogManager.getLogger(JwtTokenHelper.class);

    public String getTokenKey() {
        LOG.debug(MessageConstants.INSIDE_METHOD, "getTokenKey");
        return tokenKey;
    }

    public String getUserNameFromToken(String token) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "getUserNameFromToken");
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "getExpirationDateFromToken");
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public Date getExpirationDateFromToken(String token, String appKey) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "getExpirationDateFromToken");
        return getClaimFromToken(token, Claims::getExpiration, appKey);
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "getClaimFromToken");
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver, String appKey) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "getClaimFromToken");
        final Claims claims = getAllClaimsFromToken(token, appKey);
        return claimsResolver.apply(claims);
    }

    public Claims getAllClaimsFromToken(String token) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "getAllClaimsFromToken");
        return Jwts.parser().setSigningKey(tokenKey).parseClaimsJws(token).getBody();
    }

    public Claims getAllClaimsFromToken(String token, String appKey) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "getAllClaimsFromToken");
        return Jwts.parser().setSigningKey(appKey).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token, String appKey) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "isTokenExpired");
        final Date expiration = getExpirationDateFromToken(token, appKey);
        return expiration.before(new Date());
    }

    private Boolean isTokenExpired(String token) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "isTokenExpired");
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(UserDetails userDetails, Map<String, Object> claims) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "generateToken");
        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String userName) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "doGenerateToken");
        return Jwts.builder().setClaims(claims).setSubject(userName).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenValiditySeconds))
                .signWith(SignatureAlgorithm.HS512, tokenKey).compact();
    }

    public Boolean validateToken(String token, String appKey) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "validateToken");
        return !isTokenExpired(token, appKey);
    }

    public Boolean validateToken(String token) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "validateToken");
        return !isTokenExpired(token);
    }

    public String generateAPIToken(Map<String, Object> claims, String userName, String appKey) {
        LOG.debug(MessageConstants.INSIDE_METHOD, "generateAPIToken");
        return Jwts.builder().setClaims(claims).setSubject(userName).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenValiditySeconds))
                .signWith(SignatureAlgorithm.HS512, appKey).compact();
    }
}
