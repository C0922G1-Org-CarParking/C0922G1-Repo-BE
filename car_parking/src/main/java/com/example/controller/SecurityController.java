package com.example.controller;

import com.example.jwt.JwtUtility;
import com.example.payload.reponse.JwtResponse;
import com.example.payload.reponse.MessageResponse;
import com.example.payload.request.LoginRequest;
import com.example.service.IAccountService;
import com.example.service.impl.AccountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/public")
@CrossOrigin
public class SecurityController {

    @Autowired
    private JwtUtility jwtUtility;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IAccountService IAccountService;

    @Autowired
    private PasswordEncoder encoder;

    /**
     * Created by: HoangNM
     * Date created: 29/03/2023
     * Function: login, authentication
     *
     * @param loginRequest
     * @return HttpStatus.No_Content if result is error or HttpStatus.OK is result is not error
     */

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtility.generateJwtToken(loginRequest.getUsername());
        AccountDetails userDetails = (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(
                new JwtResponse(
                        jwt,
                        userDetails.getUsername(),
                        roles)
        );
    }

    /**
     * Created by: HoangNM
     * Date created: 29/03/2023
     * Function: forgot password
     */

//    @PostMapping("/reset-password")
//    public ResponseEntity<?> reset(@RequestBody LoginRequest loginRequest) throws  UnsupportedEncodingException {
//
//        if (IAccountService.existsByUserName(loginRequest.getUsername()) != null) {
//            return ResponseEntity.ok(new MessageResponse("Sent email "));
//        }
//        return ResponseEntity
//                .badRequest()
//                .body(new MessageResponse("Tài khoản không đúng"));
//    }

}
