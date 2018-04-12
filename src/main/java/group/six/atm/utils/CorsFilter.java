package group.six.atm.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// HttpServletResponseres=(HttpServletResponse)response;

		// res.setContentType("text/html;charset=UTF-8");

		// res.setHeader("Access-Control-Allow-Origin","*");

		// res.setHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS,DELETE");

		// res.setHeader("Access-Control-Max-Age","86400");

		// res.setHeader("Access-Control-Allow-Headers","Origin,No-Cache,X-Requested-With,If-Modified-Since,Pragma,Last-Modified,Cache-Control,Expires,Content-Type,X-E4M-With,userId,token");

		// chain.doFilter(request, response);
		
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		httpServletResponse.setHeader("Access-Control-Allow-Headers","Origin,No-Cache,X-Requested-With,If-Modified-Since,Pragma,Last-Modified,Cache-Control,Expires,Content-Type,X-E4M-With,userId,token");
		
		httpServletResponse.setContentType("application/json;charset=UTF-8");
		
		httpServletResponse.setHeader("X-Requested-With", "XMLHttpRequest");
		
		httpServletResponse.setHeader("XDomainRequestAllowed","1");
		
		httpServletResponse.setHeader("Access-Control-Allow-Credentials","true");
		
		httpServletResponse.setHeader("Access-Control-Allow-Origin", "file://");

		httpServletResponse.setHeader("Access-Control-Allow-Headers", "accept,content-type");

		httpServletResponse.setHeader("Access-Control-Allow-Methods", "OPTIONS,GET,POST,DELETE,PUT,PATCH");

		chain.doFilter(request, httpServletResponse);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void destroy() {
		
	}

}
