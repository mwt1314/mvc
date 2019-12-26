package cn.dgkj.token;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.UUID;

/**
 * @author mawt
 */
@Component
@Aspect
public class FormTokenAop {

    @Autowired
    private HttpServletRequest request;

    @Pointcut("@annotation(Token)")
    public void formRepeat() {

    }

    @Around("formRepeat()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = joinPoint.proceed();

        boolean validToken = false; //token是否一致
        String tokenKey = request.getParameter("tokenKey");
        String tokenValue = request.getParameter("tokenValue");
        if (tokenKey != null && tokenValue != null) {
            Object attribute = request.getSession().getAttribute(tokenKey);
            if (attribute != null) {
                String realTokenValue = (String) attribute;
                if (Objects.equals(tokenValue, realTokenValue)) {
                    //token不一致
                    validToken = true;
                }
            }
        }
        if (validToken) {
            //token一致

            Method targetMethod = ((MethodSignature) (joinPoint.getSignature())).getMethod();
            Token tokenAnnotation = targetMethod.getAnnotation(Token.class);
            if (tokenAnnotation != null) {
                String key = tokenAnnotation.key();
                boolean needSaveSession = tokenAnnotation.save();
                boolean needRemoveSession = tokenAnnotation.remove();
                if (needSaveSession) {
                    request.getSession(true).setAttribute("token" + key, UUID.randomUUID().toString());
                }

            }

        } else {
            //token不一致
            throw new RuntimeException();
        }

        return proceed;
    }

    private boolean isRepeatSubmit(HttpServletRequest request, String key) {
        String serverToken = (String) request.getSession(true).getAttribute("token" + key);
        if (serverToken == null) {
            return true;
        }
        String clinetToken = request.getParameter("token" + key);
        if (clinetToken == null) {
            return true;
        }
        if (!serverToken.equals(clinetToken)) {
            return true;
        }
        return false;
    }

}
