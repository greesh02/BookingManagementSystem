package com.greeshwar.BookingManagementSystem.Services.AuthServices;


import com.greeshwar.BookingManagementSystem.Enums.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.*;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Value("${security.jwt.expiration-time}")
    private long jwtExpiration;

    public String extractUserName(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        System.out.println(claims);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", userDetails.getAuthorities().stream()
                .map((auth) -> {
                            System.out.println(auth);
                    return auth.getAuthority();
                }
                )
                .toList());
        return generateToken(claims, userDetails);
    }

    public  Set<Role> extractRoles(String token) {
        Claims claims = extractAllClaims(token);
        Set<Role> roles = new HashSet<>();
        List<String> r = claims.get("roles", List.class);
        for(String item:r){
            roles.add(Role.valueOf(item));
        }

        return roles;
    }


    public String generateToken(Map<String,Object> extraClaims,UserDetails userDetails){
        return buildToken(extraClaims,userDetails,jwtExpiration);
    }

    public long getExpirationTime(){
        return jwtExpiration;
    }

    private String buildToken(Map<String,Object> extraClaims,UserDetails userDetails,long expiration){
        return Jwts
                .builder()
                .setHeaderParam("typ", "JWT")
                .claims(extraClaims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey(), Jwts.SIG.HS256)
                .compact();



    }

    public boolean isTokenVaild(String token,UserDetails userDetails){
        final String username =  extractUserName(token);
        // only checking expirationdate of token
        return ((userDetails == null || username.equals(userDetails.getUsername())) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
    private Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
    }

    private Claims extractAllClaims(String token){
//        return Jwts.parser()
//                .setSigningKey(getSignInKey())
//                .build()
//                .parseClaimsJws(token)
//                .getBody();

        Claims data = Jwts.parser()
                .verifyWith(getSignInKey()) // checks if token is valid
                .build()
                .parseSignedClaims(token)
                .getPayload(); // all the data present in token
        System.out.println(data);
        return data;
    }

//    public List<SimpleGrantedAuthority> extractAuthorities(String token) {
//        Claims claims = extractAllClaims(token);
//        List<String> roles = (List<String>) claims.get("roles");
//        return roles.stream()
//                .map(SimpleGrantedAuthority::new)
//                .toList();
//    }

    private SecretKey getSignInKey(){
        byte[] keyBytes = secretKey.getBytes();
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
