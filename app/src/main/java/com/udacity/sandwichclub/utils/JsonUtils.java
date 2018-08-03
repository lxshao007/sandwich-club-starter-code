package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        JSONObject jo = null;
        Sandwich sd = null;
        try {
            jo = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            String mainName = jo.getJSONObject("name").getString("mainName");
            JSONArray aka = jo.getJSONObject("name").getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = new ArrayList<>();
            for (int i = 0; i < aka.length(); i++) {
                alsoKnownAs.add(aka.getString(i));
            }
            String placeOfOrigin = jo.getString("placeOfOrigin");
            String description = jo.getString("description");
            String image = jo.getString("image");
            JSONArray in = jo.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<>();
            for (int i = 0; i < in.length(); i++) {
                ingredients.add(in.getString(i));
            }
            sd = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sd;

    }
}
