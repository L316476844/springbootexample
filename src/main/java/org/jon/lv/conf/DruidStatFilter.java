package org.jon.lv.conf;

/**
 * @Package org.jon.lv.conf.DruidStatFilter
 * @Description: DruidStatFilter
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/12 16:45
 * version V1.0.0
 */

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * druid过滤器.
 *
 * @author Administrator
 */
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")//忽略资源
        }
)
public class DruidStatFilter extends WebStatFilter {

}
