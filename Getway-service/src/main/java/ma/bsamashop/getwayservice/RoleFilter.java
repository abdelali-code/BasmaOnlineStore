package ma.bsamashop.getwayservice;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RoleFilter extends ZuulFilter {


    private final Set<String> pathForAdmin = new HashSet<>(
            Arrays.asList("/users-server/api/user/users/all/user",
                    "/users-server/api/user/users/find/**",
                    "/users-server/api/user/users/delete/**",

                    "/users-server/api/user/users/unblock/**"));


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

    //TODO fix filter in dynamic route

    @Override
    public Object run() {
        RequestContext http = RequestContext.getCurrentContext();
        HttpServletRequest request = http.getRequest();

        if (request.getRequestURI().contains("/users/")) {
            System.out.println("-------Contain it -------");
//            if (!request.getAttribute("type").toString().equals("admin")) {
//                http.setResponseBody("You're not allowed get this information's");
//                http.getResponse().setHeader("Content-Type", "application/json");
//                http.setSendZuulResponse(false);
//                http.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
//            }
        }
        return null;
    }
}
