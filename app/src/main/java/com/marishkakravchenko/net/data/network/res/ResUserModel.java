package com.marishkakravchenko.net.data.network.res;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResUserModel {
    @SerializedName("users")
    @Expose
    public List<User> users = new ArrayList<User>();

    @Override
    public String toString() {
        return users.get(0).name;
    }

    public class User {

        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("index")
        @Expose
        public int index;
        @SerializedName("guid")
        @Expose
        public String guid;
        @SerializedName("isActive")
        @Expose
        public boolean isActive;
        @SerializedName("balance")
        @Expose
        public String balance;
        @SerializedName("picture")
        @Expose
        public String picture;
        @SerializedName("age")
        @Expose
        public int age;
        @SerializedName("eyeColor")
        @Expose
        public String eyeColor;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("gender")
        @Expose
        public String gender;
        @SerializedName("company")
        @Expose
        public String company;
        @SerializedName("email")
        @Expose
        public String email;
        @SerializedName("phone")
        @Expose
        public String phone;
        @SerializedName("address")
        @Expose
        public String address;
        @SerializedName("about")
        @Expose
        public String about;
        @SerializedName("registered")
        @Expose
        public String registered;
        @SerializedName("latitude")
        @Expose
        public float latitude;
        @SerializedName("longitude")
        @Expose
        public float longitude;
        @SerializedName("tags")
        @Expose
        public List<String> tags = new ArrayList<String>();
        @SerializedName("friends")
        @Expose
        public List<Friend> friends = new ArrayList<Friend>();
        @SerializedName("greeting")
        @Expose
        public String greeting;
        @SerializedName("favoriteFruit")
        @Expose
        public String favoriteFruit;

    }

    public class Friend {

        @SerializedName("id")
        @Expose
        public int id;
        @SerializedName("name")
        @Expose
        public String name;

    }
}
