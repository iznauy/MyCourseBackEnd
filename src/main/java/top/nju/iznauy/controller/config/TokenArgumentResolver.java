package top.nju.iznauy.controller.config;

import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import top.nju.iznauy.controller.tools.AdminUsername;
import top.nju.iznauy.controller.tools.JwtTokenUtils;
import top.nju.iznauy.controller.tools.UserEmail;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
public class TokenArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameter().isAnnotationPresent(UserEmail.class)
                || methodParameter.getParameter().isAnnotationPresent(AdminUsername.class);
    }

    @Nullable
    @Override
    public Object resolveArgument(MethodParameter methodParameter, @Nullable ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, @Nullable WebDataBinderFactory webDataBinderFactory) throws Exception {
        String token = nativeWebRequest.getHeader("token");
        return JwtTokenUtils.getUsername(token);
    }
}
