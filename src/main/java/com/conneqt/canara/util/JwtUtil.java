package com.conneqt.canara.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

	public static String generateSecretKey() {
        // Generate a random 32-byte secret key.
        SecureRandom random = new SecureRandom();
        byte[] secretKeyBytes = new byte[32];
        random.nextBytes(secretKeyBytes);

        // Convert the secret key bytes to a string.
        String secretKey = Base64.getEncoder().encodeToString(secretKeyBytes);
        
        System.out.println("Secret Key: "+secretKey);
        
        return secretKey;
    }
	
	
    private String SECRET_KEY = generateSecretKey();
    
    

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        
        System.out.println("DATA: "+userDetails.getUsername());
        System.out.println("claims: "+claims);
        
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {

        return Jwts.builder()
        		   .setClaims(claims)
        		   .setSubject(subject)
        		   .setIssuedAt(new Date(System.currentTimeMillis()))
        		   .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
        		   .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
        		   .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        
        
        System.out.println("validate Token User Name: "+username);
        
        
        return (username.equals(userDetails.getUsername()) &&
        		!isTokenExpired(token));
    }
}