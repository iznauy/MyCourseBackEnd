package top.nju.iznauy.controller.config;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import top.nju.iznauy.controller.tools.*;
import top.nju.iznauy.entity.UserType;
import top.nju.iznauy.exception.NotLoginException;
import top.nju.iznauy.exception.PermissionDeniedException;
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
        if (method.isAnnotationPresent(StudentToken.class) || method.isAnnotationPresent(TeacherToken.class)
                || method.isAnnotationPresent(AdminToken.class) || method.isAnnotationPresent(UserToken.class)) {
            if (token == null) {
                throw new NotLoginException("未登录");
            }
            boolean unknownError = false;
            try {
                System.out.println(token);
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
            UserType userType = JwtTokenUtils.getUserType(token);
            if (method.isAnnotationPresent(UserToken.class)) {
                if (userType != UserType.student && userType != UserType.teacher)
                    throw new PermissionDeniedException("该链接仅支持学生和老师访问");
            } else if (method.isAnnotationPresent(StudentToken.class)) {
                if (userType != UserType.student)
                    throw new PermissionDeniedException("该链接仅支持学生访问");
            } else if (method.isAnnotationPresent(TeacherToken.class)) {
                if (userType != UserType.teacher)
                    throw new PermissionDeniedException("该链接仅支持老师访问");
            } else {
                if (userType != UserType.admin)
                    throw new PermissionDeniedException("该链接仅支持管理员访问");
            }
            return true;
        }
        return true;
    }
}
