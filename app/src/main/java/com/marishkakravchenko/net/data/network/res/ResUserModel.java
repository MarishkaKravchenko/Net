package com.marishkakravchenko.net.data.network.res;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResUserModel {

    public List<User> getUsers() {
        return users;
    }

    @SerializedName("users")
    @Expose
    private List<User> users = new ArrayList<User>();
    
    public class User {

        @SerializedName("id")
        @Expose private
        String id;
        @SerializedName("index")
        @Expose private
        int index;
        @SerializedName("guid")
        @Expose private
        String guid;
        @SerializedName("isActive")
        @Expose private
        boolean isActive;
        @SerializedName("balance")
        @Expose private
        String balance;
        @SerializedName("picture")
        @Expose private
        String picture;
        @SerializedName("age")
        @Expose private
        int age;
        @SerializedName("eyeColor")
        @Expose private
        String eyeColor;
        @SerializedName("name")
        @Expose private
        String name;
        @SerializedName("gender")
        @Expose private
        String gender;
        @SerializedName("company")
        @Expose private
        String company;
        @SerializedName("email")
        @Expose private
        String email;
        @SerializedName("phone")
        @Expose private
        String phone;
        @SerializedName("address")
        @Expose private
        String address;
        @SerializedName("about")
        @Expose private
        String about;
        @SerializedName("registered")
        @Expose private
        String registered;
        @SerializedName("latitude")
        @Expose private
        float latitude;
        @SerializedName("longitude")
        @Expose private
        float longitude;
        @SerializedName("tags")
        @Expose private
        List<String> tags = new ArrayList<String>();
        @SerializedName("friends")
        @Expose private
        List<Friend> friends = new ArrayList<Friend>();
        @SerializedName("greeting")
        @Expose private
        String greeting;
        @SerializedName("favoriteFruit")
        @Expose private
        String favoriteFruit;

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getGender() {
            return gender;
        }

        public int getAge() {
            return age;
        }
    }

    public class Friend {

        @SerializedName("id")
        @Expose private
        int id;
        @SerializedName("name")
        @Expose private
        String name;

    }
}
