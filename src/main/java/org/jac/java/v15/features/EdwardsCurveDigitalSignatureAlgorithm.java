package org.jac.java.v15.features;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * A demo program of Edward Curve Digital Signature Algorithm.
 */
public class EdwardsCurveDigitalSignatureAlgorithm {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException {

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("Ed25519");
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        //Generate the signature for message: "abc"
        String message = "abc";
        byte[] msgBytes = message.getBytes(StandardCharsets.UTF_8);
        Signature signInstance = Signature.getInstance("Ed25519");
        //Sign message with private key
        signInstance.initSign(keyPair.getPrivate());
        signInstance.update(msgBytes);
        byte[] sign = signInstance.sign();
        String signature = Base64.getEncoder().encodeToString(sign);
        System.out.println("Signature: " + signature);

        //Distribute the public key and message
        PublicKey publicKey = keyPair.getPublic();
        String pubKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        System.out.println("Public Key: " + pubKey);

        //Verify the Signature
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(pubKey));
        signInstance.initVerify(publicKey);
        signInstance.update(message.getBytes(StandardCharsets.UTF_8));
        boolean result = signInstance.verify(Base64.getDecoder().decode(signature));
        System.out.println("Result: " + result);
    }

}
