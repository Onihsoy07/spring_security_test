package com.example.spring_security_test;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JasyptTest {

    @Autowired
    StringEncryptor stringEncryptor;

    @Test
    public void jasyptTest() {
        String puerText = "hello";
        String encryptText = stringEncryptor.encrypt(puerText);
        String decryptText = stringEncryptor.decrypt(encryptText);
        System.out.println(puerText + " " + encryptText + " " + decryptText);
    }
}
