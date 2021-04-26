package ma.bsamashop.getwayservice;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AuthFilter extends ZuulFilter {


    private final Set<String> pathNeedsAuth = new HashSet<>(
            Arrays.asList("/users-server/api/signup",
                    "/users-server/api/login"));

    @Override
    public String filterType() {

        return "pre";
    }
    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext http = RequestContext.getCurrentContext();
        HttpServletRequest request = http.getRequest();
        //get the path from http request
        String path = request.getRequestURI();
        if (!pathNeedsAuth.contains(path)) {

            String token = request.getHeader("auth");
            System.out.println(token);
            if (token != null) {
                //split the String into two part [Bearer string, the real token]
                String[] bearer = token.split("Bearer");
                //check if the token provided
                if (bearer.length > 1 && bearer[1] != null) {
                    token = bearer[1];
                    try {
                        //parse the String into json
                        Claims claims = Jwts.parser().setSigningKey("fdslkfhkdfhdljfqdhlfhffqshlkfhsfjfxcblukhf").parseClaimsJws(token).getBody();
                        //sent the user is around the app with http request
                        request.setAttribute("id", Long.parseLong(claims.get("Id").toString()));
                        request.setAttribute("type", claims.get("type").toString());
                    } catch (Exception e) {
                        filterMessage(http, "Invalid token!!");
                    }
                } else {
                    filterMessage(http, "Must provide a token!!");
                }
            } else {
                filterMessage(http, "Must provide a token!!");
            }
        }
        return null;
    }


    private void filterMessage(RequestContext http, String msg) {

        http.setResponseBody(msg);
        http.getResponse().setHeader("Content-Type", "application/json");
        http.setSendZuulResponse(false);
        http.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());

    }
}
