package com.redSocial.security.jwt;

import com.redSocial.security.entidad.UserPrincipal;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {

    private final static Logger log = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;

    public String generadorToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        return Jwts.builder().setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

    }

    public String getUsernameDeToken(String token) {
        return Jwts.parser().setSigningKey(secret)
                .parseClaimsJwt(token)
                .getBody().getSubject();
    }

    public boolean validarToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJwt(token);
            return true;
        } catch (MalformedJwtException |
                UnsupportedJwtException |
                ExpiredJwtException |
                IllegalArgumentException |
                SignatureException e) {

            log.error("Token validacion error");
            log.error("Info: ");
            log.error("{}", e.getMessage());
            e.printStackTrace();
            log.error("");
        }
        return false;
    }

}
