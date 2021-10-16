package com.example.fundoonotesbackend.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.springframework.stereotype.Component;

@Component
public class Token {

    private static final String TOKEN_SECRET = "secret";

    public String createToken(int id) {
        try {
            //to set algorithm
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

            String token = JWT.create()
                    .withClaim("user_id", id)
                    .sign(algorithm);
            System.out.println("For Id "+id+" Your Token is here :: "+token);
            return token;
        } catch (JWTCreationException e) {
            e.printStackTrace();
            //if log token signing failed
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Long decodeToken(String token) {

        Long user_id;
        //verification algorithm
        Verification verification = null;
        try {
            verification = JWT.require(Algorithm.HMAC256(TOKEN_SECRET));
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
        }

        JWTVerifier jwtVerifire = verification.build();
        //Decoding again
        DecodedJWT decodedJwt = jwtVerifire.verify(token);
        Claim claim = decodedJwt.getClaim("user_id");
        user_id = claim.asLong();
        return user_id;
    }

}
