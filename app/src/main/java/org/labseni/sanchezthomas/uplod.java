package org.labseni.sanchezthomas;

/**
 * Created by AMD on 11/30/2017.
 */

public class uplod {

    public String name;
    public String url;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public uplod() {
    }

    public uplod(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}