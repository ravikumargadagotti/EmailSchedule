package com.revanItSolutions.emailAlert.util;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RandomMessage {

    public String returnRandomString(){
        List<String> list = new ArrayList<String>();
        list.add("Your wordpress minor version has been updated.");
        list.add("Plugin 'Akismet Anti-Spam' has been updated to latest version");
        list.add("Plugin 'BeTheme Header Builder' has been updated to latest version");
        list.add("Plugin 'Contact Form 7' has been updated to latest version");
        list.add("Plugin 'Disable Comments' has been updated to latest version");
        list.add("Plugin 'Elementor' has been updated to latest version");
        list.add("Plugin 'Force Regenerate Thumbnails' has been updated to latest version");
        list.add("Plugin 'Limit Login Attempts Reloaded' has been updated to latest version");
        list.add("Plugin 'Really Simple SSL' has been updated to latest version");
        list.add("Plugin 'Slider Revolution' has been updated to latest version");
        list.add("Plugin 'UpdraftPlus - Backup/Restore' has been updated to latest version");
        list.add("Plugin 'WPBakery Page Builder' has been updated to latest version");
        list.add("Plugin 'WPS Hide Login' has been updated to latest version");
        list.add("Plugin 'Yoast SEO' has been updated to latest version");

        return list.get(new Random().nextInt(list.size()));
    }

}
