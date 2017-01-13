package org.github.finance.mall.payment;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author ligaofeng 2016年12月8日 上午11:30:57
 */
@Component
public class SpringHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringHolder.applicationContext = applicationContext;
    }

    /**
     * @param beanId
     * @return
     * @throws BeansException
     */
    public static Object getBean(String beanId) {
        return applicationContext.getBean(beanId);
    }

    /**
     * @param requiredType
     * @return
     */
    public static <T> T getBean(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }

    /**
     * @param beanId
     * @param requiredType
     * @return
     */
    public static <T> T getBean(String beanId, Class<T> requiredType) {
        return applicationContext.getBean(beanId, requiredType);
    }
}
