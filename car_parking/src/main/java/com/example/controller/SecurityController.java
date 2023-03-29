package com.example.controller;

import com.example.jwt.JwtUtility;
import com.example.model.Account;
import com.example.payload.reponse.JwtResponse;
import com.example.payload.reponse.MessageResponse;
import com.example.payload.request.LoginRequest;
import com.example.service.IAccountService;
import com.example.service.impl.AccountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Random;
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
    private IAccountService accountService;

    @Autowired
    private JavaMailSender emailSender;

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
     * Function: reset password (forgot password)
     */

    @GetMapping("/reset-password/{email}")
    public ResponseEntity<?> resetPassword(@PathVariable String email) {
        Account account= accountService.findAccountByEmployeeEmail(email);
        if (account != null) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Mật khẩu mới.");
            String newPassword = String.valueOf(new Random().nextInt(900000) + 100000);
            message.setText("Mật khẩu mới của bạn là: " + newPassword);
            try{
                accountService.saveNewPassword(newPassword,account.getId());
                emailSender.send(message);
                return ResponseEntity.ok(new MessageResponse("Mật khẩu mới đã gửi về mail của bạn."));
            }catch (Exception e) {
                return ResponseEntity .badRequest()
                        .body(new MessageResponse("Gửi mail thất bại."));
            }

        }
        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Tài khoản không đúng hoặc chưa đăng ký."));
    }

}
