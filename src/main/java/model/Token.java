package model;

import java.util.Random;

public class Token {

    private String token;

    public String getToken() {
        return token;
    }


    public static String generateTokenDeel() {

        Random randomTokenNumber = new Random();
        int partAsInt = randomTokenNumber.nextInt(9999);
        StringBuilder tokenDeel = new StringBuilder(Integer.toString(partAsInt));

        for (int i = tokenDeel.length(); i < 4; i++) {
            tokenDeel.insert(0, "0");
        }
        return tokenDeel.toString();
    }

    public static String generateToken() {
        StringBuilder tokenDeel = new StringBuilder();
        for (int i = 0; i < 3; i++) {

            tokenDeel.append(generateTokenDeel());
            if (i != 2) {
                tokenDeel.append("-");
            }
        }
        return tokenDeel.toString();
    }
}
