package top.nju.iznauy.controller.tools;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import top.nju.iznauy.entity.UserType;

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

    private static final String USER_TYPE_HEADER = "userType";

    public static String createToken(String username, UserType userType) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setHeaderParam(USER_TYPE_HEADER, userType.toString())
                .setIssuer(ISS)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .compact();
    }

    public static String getUsername(String token) {
        return getTokenClaims(token).getBody().getSubject();
    }

    public static UserType getUserType(String token) {
        return UserType.valueOf((String)getTokenClaims(token).getHeader().get(USER_TYPE_HEADER));
    }

    public static boolean isExpiration(String token) {
        return getTokenClaims(token).getBody().getExpiration().before(new Date());
    }

    private static Jws<Claims> getTokenClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token);
    }


}
