package pl.training.autoportal.service;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

@Timer
@Interceptor
public class Profiler implements Serializable {

    @Inject
    private Logger logger;

    @AroundInvoke
    public Object aroundInvoke(InvocationContext context) throws Exception {
        long currentTime = System.currentTimeMillis();
        Object result = context.proceed();
        logger.log(Level.INFO, "#### Execution time: " + (System.currentTimeMillis() - currentTime));
        return result;
    }

}
