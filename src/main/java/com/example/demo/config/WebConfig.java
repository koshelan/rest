package com.example.demo.config;

import com.example.demo.model.User;
import com.example.demo.model.UserArgument;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new UserResolver());
    }

    private static class UserResolver implements HandlerMethodArgumentResolver {

        @Override
        public boolean supportsParameter(MethodParameter methodParameter) {
            return methodParameter.hasParameterAnnotation(UserArgument.class);
        }

        @Override
        public User resolveArgument(MethodParameter methodParameter,
                ModelAndViewContainer modelAndViewContainer,
                NativeWebRequest webRequest,
                WebDataBinderFactory webDataBinderFactory) throws Exception {
            String user = webRequest.getParameter("user");
            String password = webRequest.getParameter("password");
            return new User(user, password);
        }
    }

}
