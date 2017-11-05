package org.jon.lv.conf;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 解决ajax跨域
 * @author Author lv bin
 * @time   2017年8月16日
 */
@Component
public class CorsFilter implements Filter {

    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CorsFilter.class);

    public void doFilter(ServletRequest req, ServletResponse resp,  
    		FilterChain chain) throws IOException, ServletException {  
    		HttpServletResponse res = (HttpServletResponse) resp;
    		System.out.println("=================================="+req.getRemoteAddr());
            
    		// 这里最好不要写通配符，如果允许多个域请求数据的话，可以直接用逗号隔开："http://www.baidu.com,http://google.com"  
    		  
    		res.setHeader("Access-Control-Allow-Origin", "*");  
    		  
    		res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");  
    		  
    		res.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");  
    		  
    		//res.setHeader("Access-Control-Allow-Credentials","false");  
    		  
    		chain.doFilter(req, resp);  
    		  
    		}  
    public void init(FilterConfig filterConfig) {}
    public void destroy() {}
}