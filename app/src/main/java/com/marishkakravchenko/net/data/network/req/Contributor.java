package com.marishkakravchenko.net.data.network.req;

/**
 * Created by Marina on 16.08.2016.
 */
public class Contributor {

    String login;
    String html_url;

    int contributions;

    @Override
    public String toString() {
        return login + " (" + contributions + ")";
    }

}
