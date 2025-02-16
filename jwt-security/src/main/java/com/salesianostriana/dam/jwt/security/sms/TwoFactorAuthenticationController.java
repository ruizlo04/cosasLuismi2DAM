package com.salesianostriana.dam.jwt.security.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/2fa")
public class TwoFactorAuthenticationController {

    @Autowired
    private TwoFactorAuthenticationService twoFactorAuthenticationService;

    @PostMapping("/send-code")
    public ResponseEntity<String> sendCode(@RequestParam String phoneNumber) {
        twoFactorAuthenticationService.sendVerificationCode(phoneNumber);
        return ResponseEntity.ok("Verification code sent to: " + phoneNumber);
    }

    @PostMapping("/verify-code")
    public ResponseEntity<String> verifyCode(@RequestParam String phoneNumber, @RequestParam String code) {
        boolean isVerified = twoFactorAuthenticationService.verifyCode(phoneNumber, code);
        if (isVerified) {
            return ResponseEntity.ok("Code verified successfully!");
        } else {
            return ResponseEntity.status(400).body("Invalid verification code.");
        }
    }
}
