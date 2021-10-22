package com.yasintorun.poolManagement.core.utilities.security.jwt;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
@Service
public class TokenManager {
	Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	
	public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setAudience(TokenOptions.audience)
                .setIssuer(TokenOptions.issuer)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TokenOptions.tokenExpiration))
                .signWith(key)
                .compact();
    }
	
	public boolean tokenValidate(String token) {
        if (getUsernameToken(token) != null && isExpired(token)) {
            return true;
        }
        return false;
    }

    public String getUsernameToken(String token) {
        Claims claims = getClaims(token);
        return claims.getSubject();
    }

    public boolean isExpired(String token) {
        Claims claims = getClaims(token);
        return claims.getExpiration().after(new Date(System.currentTimeMillis()));
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }
}
