package top.nju.iznauy.controller.tools;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
public class JwtTokenUtils {

    private static final String SECRET = "how are you indian mi fans?";

    private static final String ISS = "iznauy";

    private static final long EXPIRATION = 3600 * 1000L;

    public static String createToken(String username) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setIssuer(ISS)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .compact();
    }

    public static String getUsername(String token) {
        return getTokenBody(token).getSubject();
    }

    public static boolean isExpiration(String token) {
        return getTokenBody(token).getExpiration().before(new Date());
    }

    private static Claims getTokenBody(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

}
