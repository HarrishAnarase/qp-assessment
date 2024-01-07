package com.grocery.controllers;


import com.grocery.body.UserLoginBody;
import com.grocery.exceptions.QPException;
import com.grocery.exceptions.QPInvalidCredentialsException;
import com.grocery.lib.User;
import com.grocery.response.Status;
import com.grocery.response.StatusResponse;
import com.grocery.services.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller class used for login api
 * @author Harrish Anarase
 * @since 2024
 * @version 1.0
 */
@RestController
@RequestMapping(path = {"/user"}, produces = "application/json")
public class UserApiController {

    private final HttpServletRequest request;
    private final HttpServletResponse response;

    @Autowired
    UserApiController(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        this.request = request;
        this.response = response;
    }

    @Autowired
    private UserServiceImpl userService;

    /**
     * any user can login
     * @param body
     * @return StatusResponse
     */
    @PostMapping("/login")
    public ResponseEntity<StatusResponse> login(@Valid @RequestBody UserLoginBody body) {
        StatusResponse statusResponse = new StatusResponse();
        try {
            if (!userService.isValidLogin(body.getUserName(), body.getPassword()))
                throw new QPInvalidCredentialsException("Invalid Credentials");
            User user = userService.getUserInstant(body.getUserName());
            request.getSession(true).setAttribute("user", user);
            statusResponse.setStatus(new Status("User logged in successfully."));
        } catch (QPException e) {
            request.getSession().invalidate();
            statusResponse.setStatus(new Status(e.getMessage()));
        }
        return ResponseEntity.ok(statusResponse);
    }
}
