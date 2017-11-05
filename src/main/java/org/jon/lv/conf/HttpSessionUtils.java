package org.jon.lv.conf;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * session 会话工具
 */
public class HttpSessionUtils {

    private static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest();
    }

    private static HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * @Description: 存放会话级别的值
     * @Title putObject
     * @Author  lv bin
     * @Date 2016/10/26 16:29
     * @param  requestKey, obj
     * @return void
     * @throws
     */
    public static void putObject(String requestKey, Object obj){
        getRequest().setAttribute(requestKey, obj);
    }

    /**
     * @Description: 根据 session key获取会话值
     * @Title getObject
     * @Author  lv bin
     * @Date 2016/10/26 16:27
     * @param  requestKey
     * @return T
     * @throws
     */
    public static <T> T  getObject(String requestKey){
        return  (T)getRequest().getAttribute(requestKey);
    }

    /**
     * 获取当前用户id
     * @return
     */
    public static Long getCurrentAppUserId(){

        Object object = getRequest().getAttribute(AuthSessionUtils.APP_CURRENT_USER_ID);

        if(object != null) return (Long)object;

        return null;
    }

    /**
     * 获取当前用户token
     * @return
     */
    public static String getCurrentAppUserToken() {
        Object object = getRequest().getAttribute(AuthSessionUtils.APP_CURRENT_USER_TOKEN);

        if(object != null) return (String)object;

        return null;
    }
}
