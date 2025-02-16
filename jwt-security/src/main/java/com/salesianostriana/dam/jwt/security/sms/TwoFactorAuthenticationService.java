package com.salesianostriana.dam.jwt.security.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TwoFactorAuthenticationService {

    @Autowired
    private SmsService smsService;

    private ConcurrentHashMap<String, String> verificationCodes = new ConcurrentHashMap<>();

    public String generateVerificationCode() {
        return String.format("%06d", new Random().nextInt(999999));
    }

    public void sendVerificationCode(String phoneNumber) {
        String code = generateVerificationCode();
        verificationCodes.put(phoneNumber, code);
        smsService.sendSms(phoneNumber, "Your verification code is: " + code);
    }

    public boolean verifyCode(String phoneNumber, String userInputCode) {
        String actualCode = verificationCodes.get(phoneNumber);
        if (actualCode != null && actualCode.equals(userInputCode)) {
            verificationCodes.remove(phoneNumber);
            return true;
        }
        return false;
    }
}
