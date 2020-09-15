package com.cloud.security.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtils {

    private static final Gson gson = new  GsonBuilder().serializeNulls().create();

    public static String toJson(Object obj) {
        try {
            return gson.toJson(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}