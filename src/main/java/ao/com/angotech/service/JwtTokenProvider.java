package ao.com.angotech.service;

import ao.com.angotech.enums.RoleEnum;
import ao.com.angotech.exception.JwtAuthenticationException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtTokenProvider {

    private final SecretKey secretKey;

    public JwtTokenProvider() {
        // Gera uma chave segura para o algoritmo HS512
        this.secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }


    private long validityInMilliseconds = 3600000;

    public String createTokenString(String email, RoleEnum role) {

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .subject(email)
                .claim("role", role.name())
                .issuedAt(now)
                .expiration(validity)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public boolean validateToken(String token) {
        try {

            Jws<Claims> claimsJws = Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token);

            System.out.println("Token válido: " + token);

            return !claimsJws.getPayload().getExpiration()
                    .before(new Date());

        } catch (JwtException | IllegalArgumentException e) {
            throw new JwtAuthenticationException("Token JWT expirado ou inválido");
        }
    }

    public String getUsername(String token) {

        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public RoleEnum getRole(String token) {
        String role = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("role", String.class);

        return RoleEnum.valueOf(role);
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");

        if ( bearerToken != null && bearerToken.startsWith("Bearer ") ) {
            return bearerToken.substring(7);
        }

        return null;
    }
}
