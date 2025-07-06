package SiDev.urlShrink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/url")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody Map<String, String> request) {
        String longUrl = request.get("longUrl");
        return urlService.shortenUrl(longUrl);
    }

    @GetMapping("/{shortCode}")
    public String getLongUrl(@PathVariable String shortCode) {
        return urlService.getLongUrl(shortCode);
    }


}

