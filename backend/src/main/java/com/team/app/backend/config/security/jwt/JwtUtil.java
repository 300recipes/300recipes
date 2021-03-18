package com.team.app.backend.config.security.jwt;

import com.team.app.backend.persistance.model.User;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

import static java.lang.String.format;
import static com.team.app.backend.config.security.SecurityConstants.*;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    public String generateAccessToken(User user) {
        return Jwts.builder()
                .setSubject(format("%s,%s,%s", user.getId(), user.getUsername(), user.getRole().getName()))
                .setIssuer(ISSUER)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // 1 week
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    public String getUserId(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject().split(",")[0];
    }

    public String getUsername(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject().split(",")[1];
    }

    public String getRole(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject().split(",")[2];
    }

    public Date getExpirationDate(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.getExpiration();
    }

    public boolean validate(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            System.out.println("Invalid JWT signature - "+ ex.getMessage());
        } catch (MalformedJwtException ex) {
            System.out.println("Invalid JWT token - " +  ex.getMessage());
        } catch (ExpiredJwtException ex) {
            System.out.println("Expired JWT token - "+ ex.getMessage());
        } catch (UnsupportedJwtException ex) {
            System.out.println("Unsupported JWT token - "+ ex.getMessage());
        } catch (IllegalArgumentException ex) {
            System.out.println("JWT claims string is empty - " + ex.getMessage());
        }
        return false;
    }

}