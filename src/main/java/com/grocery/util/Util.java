package com.grocery.util;

import com.grocery.exceptions.QPInvalidCredentialsException;
import com.grocery.lib.User;
import com.grocery.lib.UserRole;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Util {

    public boolean isUserLoggedIn(HttpServletRequest request, HttpServletResponse response, List<UserRole> userRole) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null)
            invalidateSession(request, response);
        if (userRole.contains(user.getStaffRole()))
            return true;
        invalidateSession(request, response);
        return false;
    }

    public void invalidateSession(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        throw new QPInvalidCredentialsException("User not loggedIn");
    }

}
