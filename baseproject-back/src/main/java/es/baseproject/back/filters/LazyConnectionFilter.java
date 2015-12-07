package es.baseproject.back.filters;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.*;
import javax.transaction.UserTransaction;

public class LazyConnectionFilter implements Filter {

    @Resource
    private UserTransaction utx;
    
    @Override
    public void init(FilterConfig fc) throws ServletException {}

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        try {
            utx.begin();
            fc.doFilter(sr, sr1);
            utx.commit();
        } catch (Exception e) {}
    }

    @Override
    public void destroy() {}
}