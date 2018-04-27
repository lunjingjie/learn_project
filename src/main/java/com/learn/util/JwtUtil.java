package com.learn.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.xml.transform.Source;
import java.io.UnsupportedEncodingException;
import java.util.Date;

public class JwtUtil {

    public static String createToken () {
        String token = "";
        try {
            Algorithm algorithmHS = Algorithm.HMAC256("secret");
            token = JWT.create().withIssuer("auth0").withExpiresAt(new Date(System.currentTimeMillis() + 3600 * 1000 * 2)).sign(algorithmHS);
        } catch (UnsupportedEncodingException exception) {
            exception.printStackTrace();
        } catch (JWTCreationException exception) {
            exception.printStackTrace();
        }
        return token;
    }

    public static boolean vertifyToken(String token) {
        boolean result;
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm).withIssuer("auth0")
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            System.out.println(jwt.getToken());
            System.out.println(jwt.getHeader());
            System.out.println(jwt.getPayload());
            System.out.println(jwt.getSignature());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JWTVerificationException e) {
            e.printStackTrace();
        }
        return true;
    }
}
