package com.usermodule.user.security;

import com.usermodule.user.constants.MessageConstants;
import com.usermodule.user.security.helpers.JwtTokenHelper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    private final UserDetailsService userDetailsService;
    private final JwtTokenHelper jwtTokenHelper;
    @Autowired
    public JWTAuthorizationFilter(UserDetailsService userDetailsService, JwtTokenHelper jwtTokenHelper) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenHelper = jwtTokenHelper;
    }

    private static final Logger LOG = LogManager.getLogger(JWTAuthorizationFilter.class);

 //   private List<String> listOfUrl = getGlobalAntMatcherList();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse
            response, FilterChain filterChain) throws IOException, ServletException {
        LOG.debug(MessageConstants.INSIDE_METHOD, "doFilterInternal");
//        if(!shouldNotFilter(request)) {
//            String reqToken = request.getHeader("Authorization");
//            if(performBasicCheck(reqToken)) {
//                reqToken = reqToken.substring(7);
//                String userName = getUserNameFromJwt(reqToken);if(userName == null)
//                    throw new UserDetailException(ValidationConstants.TOKEN_INVALID_USERNAME, ErrorCode.USER_DATA_ERROR);
//                performAuthentication(request, userName, reqToken);
//            }
//        }
        filterChain.doFilter(request, response);
    }

//    @Override
//    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
//        AntPathMatcher antPathMatcher = new AntPathMatcher();
//        for(String url : listOfUrl) {
//            if(antPathMatcher.match(url, request.getServletPath()))
//                return true;
//        }
//        return false;
//    }
//
//    private List<String> getGlobalAntMatcherList() {
//        List<String> urlList = new ArrayList<>();
//        urlList.add("/actuator");
//        urlList.add("/actuator/**");
//        urlList.add("/helper/**");
//        urlList.add("/users/signup");
//        urlList.add("/auth/login");
//        return urlList;
//    }
//
//    private boolean performBasicCheck(String reqToken) throws ServletException {
//        if(!validateToken(reqToken)) {
//            throw new ServletException("User Not Authorized!!!");
//        }
//        boolean result = false;
//        if(!reqToken.startsWith("Basic"))
//            result = true;
//        return result;
//    }
//
//    private String getUserNameFromJwt(String reqToken) {
//        String userName = null;
//        try {
//            userName = jwtTokenHelper.getUserNameFromToken(reqToken);
//        } catch (IllegalArgumentException ile) {
//            LOG.error("Unable to Parse JWT Token!!!");
//        } catch (ExpiredJwtException exj) {
//            LOG.error("JWT Token has Expired!!!");
//        } catch (MalformedJwtException ex) {
//            LOG.error("Invalid JWT");
//        }
//        return userName;
//    }
//
//    private void performAuthentication(HttpServletRequest request, String userName, String reqToken) {
//        LOG.debug(MessageConstants.INSIDE_METHOD, "performAuthentication");
//        if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            LOG.debug("Fetch User Details for UserName: {}", userName);
//            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
//            String reqUrl = request.getServletPath() + "::" + request.getMethod();
//            if(validateTokenWithClaims(reqToken, reqUrl)) {
//                LOG.debug("Request Token is Validated with user details!!!");
//                UsernamePasswordAuthenticationToken usrPassAuthToken =
//                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                usrPassAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(usrPassAuthToken);
//            } else {
//                LOG.debug(ValidationConstants.TOKEN_INVALID_USER_DETAILS);
//                throw new JWTValidationException(ValidationConstants.TOKEN_INVALID_USER_DETAILS, ErrorCode.JWT_VALIDATION_ERROR);
//            }
//        } else {
//            LOG.debug(ValidationConstants.TOKEN_INVALID_NULL);
//            throw new JWTValidationException(ValidationConstants.TOKEN_INVALID_NULL, ErrorCode.JWT_VALIDATION_ERROR);
//        }
//    }
//
//    public boolean validateTokenWithClaims(String reqToken, String reqUrl) {
//        boolean validToken = this.jwtTokenHelper.validateToken(reqToken);
//        boolean result = false;
//        if(validToken) {
//            Claims allClaims = this.jwtTokenHelper.getAllClaimsFromToken(reqToken);
//            var apiUrl = allClaims.get("apiUrl");
//            if(apiUrl != null) {
//                if(apiUrl.toString().equalsIgnoreCase(reqUrl))
//                    return true;
//            } else {
//                result = true;
//            }
//        }
//        return result;
//    }
//
//    public boolean validateTokenWithClaims(String reqToken, String reqUrl, String appKey) {
//        boolean validToken = this.jwtTokenHelper.validateToken(reqToken, appKey);
//        boolean result = false;
//        if(validToken) {
//            Claims allClaims = this.jwtTokenHelper.getAllClaimsFromToken(reqToken, appKey);
//            var apiUrl = allClaims.get("apiUrl");
//            if(apiUrl != null) {
//                if(apiUrl.toString().equalsIgnoreCase(reqUrl))
//                    return true;
//            } else {
//                result = true;
//            }
//        }
//        return result;
//    }
//
//    private boolean validateToken(String token) {
//        LOG.debug(MessageConstants.INSIDE_METHOD, "validateToken");
//        boolean result = true;
//        if(token.isEmpty() || !(token.startsWith("Bearer") || token.startsWith("Basic"))) {
//            LOG.debug("Token is Not Valid!!!, value is: {}", token);
//            result = false;
//        }
//        return result;
//    }
}
