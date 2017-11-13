package com.qf.es.startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.google.common.util.concurrent.AbstractIdleService;
import com.qf.es.config.ESConfig;

public class Starter extends AbstractIdleService {
	
	private static final Logger log = LoggerFactory.getLogger(Starter.class);

    private AnnotationConfigApplicationContext context;

    public static void main(String[] args) {
        final Starter bootstrap = new Starter();
        bootstrap.startAsync();
        try {
            final Object lock = new Object();
            synchronized (lock) {
                while (true) {
                    lock.wait();
                }
            }
        } 
        catch (final InterruptedException ex) {
            log.error("ignore interruption");
        }
    }

    @Override
    protected void startUp() throws Exception {
        context = new AnnotationConfigApplicationContext();
        context.register(ESConfig.class);
        context.refresh();
        context.start();
        context.registerShutdownHook();
        if (log.isDebugEnabled()) {
        	log.debug("---------------- ES service started successfully ------------");
        }
    }

    @Override
    protected void shutDown() throws Exception {
        context.stop();
        if (log.isDebugEnabled()) {
        	log.debug("----------------- ES service stopped successfully -------------");
        }
    }
    
    public Object getBean(String beanName) {
		return context.getBean(beanName);
	}

}
