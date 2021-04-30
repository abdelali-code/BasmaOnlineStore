package ma.bsamashop.getwayservice;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

public class RoleFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 11;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext http = RequestContext.getCurrentContext();
        HttpServletRequest request = http.getRequest();

        if (request.getRequestURI().contains("/users/")) {

            if (!request.getAttribute("type").toString().equals("admin")) {
                http.setResponseBody("You're not allowed get this information's");
                http.getResponse().setHeader("Content-Type", "application/json");
                http.setSendZuulResponse(false);
                http.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }
        }
        return null;
    }
}
