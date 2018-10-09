package company.gg;

import java.util.HashMap;
import java.util.Random;

public class EncodeAndDecodeTinyURL_535 {

    // Assume tiny url is [a-zA-Z0-9], that's 26*2+10 = 62 letters
    // Assume use 6 bits, that's 62^6 values
    private static String charString = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
    private static HashMap<String, String> shortToLongMap = new HashMap<>();
    private static HashMap<String, String> longToShortMap = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while (!longToShortMap.containsKey(longUrl)) {
            String shortUrl = getRandomString();
            if (!shortToLongMap.containsKey(shortUrl)) {
                shortToLongMap.put(shortUrl, longUrl);
                longToShortMap.put(longUrl, shortUrl);
            }
        }
        return longToShortMap.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLongMap.get(shortUrl);
    }

    private static String getRandomString() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(charString.charAt(random.nextInt(62)));
        }
        return sb.toString();
    }
}
