package org.curtis.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class UuidGenerator {
    private static SecureRandom secureRandom = new SecureRandom();
    private static Random random;
    private static String hostname;

    static
    {
        long secureInitializer = secureRandom.nextLong();
        random = new Random(secureInitializer);

        try {
            hostname = InetAddress.getLocalHost().toString();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public static String newUuid() {
        MessageDigest md5;
        StringBuilder preDigestBuffer = new StringBuilder();

        try
        {
            md5 = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }

        // Build a unique string to digest
        preDigestBuffer.append(hostname);
        preDigestBuffer.append(":");
        preDigestBuffer.append(Long.toString(System.currentTimeMillis()));
        preDigestBuffer.append(":");
        preDigestBuffer.append(Long.toString(random.nextLong()));

        // Generate the digest
        md5.update(preDigestBuffer.toString().getBytes());

        // Hex the digest
        byte[] digestArray = md5.digest();
        StringBuilder postDigestBuffer = new StringBuilder();
        for (byte digestByte : digestArray) {
            int b = digestByte & 0xFF;
            if (b < 0x10) {
                postDigestBuffer.append('0');
            }

            postDigestBuffer.append(Integer.toHexString(b));
        }

        // Build the guid
        postDigestBuffer.insert(8, '-');
        postDigestBuffer.insert(13, '-');
        postDigestBuffer.insert(18, '-');
        postDigestBuffer.insert(23, '-');

        return postDigestBuffer.toString().toUpperCase();
    }
}
