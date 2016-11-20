package com.ondetemjogo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * More details:
 * https://spring.io/blog/2015/01/20/the-resource-server-angular-js-and-spring-
 * security-part-iii#cors-negotiation
 *
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

   @Override
   public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
      HttpServletResponse response = (HttpServletResponse) res;
      HttpServletRequest request = (HttpServletRequest) req;
      response.setHeader("Access-Control-Allow-Origin", "*");
      response.setHeader("Access-Control-Allow-Methods", "GET, DELETE, OPTIONS, POST, PUT");
      response.setHeader("Access-Control-Max-Age", "3600");
      response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Authorization, Content-Type");

      if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
         response.setStatus(HttpServletResponse.SC_OK);
      } else {
         chain.doFilter(req, res);
      }
   }

   @Override
   public void init(FilterConfig filterConfig) {      
	   // doNothing
   }

   @Override
   public void destroy() {
      // doNothing
   }
}