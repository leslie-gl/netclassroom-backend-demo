package com.leslie.common.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletResponse相关工具类
 *
 * @author kira
 * @date 2020/4/8 8:34
 */
public class ServletResponseUtils {

    /**
     * response返回信息
     *
     * @param response
     * @param info
     * @throws IOException
     */
    public static void responseWriterInfo(HttpServletResponse response, String info) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(info);
        response.getWriter().flush();
        response.getWriter().close();
    }
}
