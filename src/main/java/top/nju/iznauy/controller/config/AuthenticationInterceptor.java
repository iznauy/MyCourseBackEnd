package top.nju.iznauy.controller.config;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import top.nju.iznauy.controller.tools.AdminToken;
import top.nju.iznauy.controller.tools.JwtTokenUtils;
import top.nju.iznauy.controller.tools.PassToken;
import top.nju.iznauy.controller.tools.UserToken;
import top.nju.iznauy.exception.NotLoginException;
import top.nju.iznauy.exception.TokenExpiredException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod))
            return true;
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(PassToken.class))
            return true;
        String token = request.getHeader("token");
        if (method.isAnnotationPresent(UserToken.class) || method.isAnnotationPresent(AdminToken.class)) {
            if (token == null) {
                throw new NotLoginException("未登录");
            }
            boolean unknownError = false;
            try {
                JwtTokenUtils.isExpiration(token);
            } catch (ExpiredJwtException e) {
                e.printStackTrace();
                throw new TokenExpiredException("token过期");
            } catch (Exception e) {
                e.printStackTrace();
                unknownError = true;
            }
            if (unknownError)
                throw new NotLoginException("未知错误");
            return true;
        }
        return true;
    }
}
