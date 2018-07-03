package com.migen.iotcloud.init;

import com.migen.iotcloud.utils.StringUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**初始化监听器
 * Created by Administrator on 2017/1/23.
 */
public class InitListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent context) {

    }

    @Override
    public void contextInitialized(ServletContextEvent context) {
        // 上下文初始化执行
        MapperConfig.CreateMapping();
        context.getServletContext().setAttribute("JSVersion", StringUtil.getVersion());
    }
}
