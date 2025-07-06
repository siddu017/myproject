package SiDev.urlShrink;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UrlService {

    private final Map<String, String> urlStore = new HashMap<>();

    public String shortenUrl(String longUrl) {
        String shortCode = UUID.randomUUID().toString().substring(0, 6);
        urlStore.put(shortCode, longUrl);
        return shortCode;
    }

    public String getLongUrl(String shortCode) {
        return urlStore.getOrDefault(shortCode.trim(), "URL not found");
    }
}
