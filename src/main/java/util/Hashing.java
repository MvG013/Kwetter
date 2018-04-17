package util;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Hashing {

    private Hashing() {
    }

    public static String hashPassword(String data) {
        return DigestUtils.sha256Hex(data);
    }

}