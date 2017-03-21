package com.fruit.sales.common;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;
import org.springframework.ui.context.Theme;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * SpringMVC通用工具
 * 
 *
 */
public final class WebContextHolder {

    private static final Logger logger = LoggerFactory.getLogger(WebContextHolder.class);

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attributes.getRequest();
    }

    public static HttpSession getSession() {
        return getSession(true);
    }

    public static HttpSession getSession(boolean create) {
        return getRequest().getSession(create);
    }

    public String getSessionId() {
        return getSession().getId();
    }

    public ServletContext getServletContext() {
        return getSession().getServletContext();    // servlet2.3
    }

    public Locale getLocale() {
        return RequestContextUtils.getLocale(getRequest());
    }

    public Theme getTheme() {
        return RequestContextUtils.getTheme(getRequest());
    }

    public ApplicationContext getApplicationContext() {
        return WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }

    public ApplicationEventPublisher getApplicationEventPublisher() {
        return (ApplicationEventPublisher) getApplicationContext();
    }

    public LocaleResolver getLocaleResolver() {
        return RequestContextUtils.getLocaleResolver(getRequest());
    }

    public ThemeResolver getThemeResolver() {
        return RequestContextUtils.getThemeResolver(getRequest());
    }

    public ResourceLoader getResourceLoader() {
        return (ResourceLoader) getApplicationContext();
    }

    public ResourcePatternResolver getResourcePatternResolver() {
        return (ResourcePatternResolver) getApplicationContext();
    }

    public MessageSource getMessageSource() {
        return (MessageSource) getApplicationContext();
    }

    public ConversionService getConversionService() {
        return getBeanFromApplicationContext(ConversionService.class);
    }

    public Collection<String> getActiveProfiles() {
        return Arrays.asList(getApplicationContext().getEnvironment().getActiveProfiles());
    }

    public ClassLoader getBeanClassLoader() {
        return ClassUtils.getDefaultClassLoader();
    }

    private <T> T getBeanFromApplicationContext(Class<T> requiredType) {
        try {
            return getApplicationContext().getBean(requiredType);
        } catch (NoUniqueBeanDefinitionException e) {
        	logger.error(e.getMessage(), e);
            throw e;
        } catch (NoSuchBeanDefinitionException e) {
        	logger.warn(e.getMessage());
            return null;
        }
    }

}