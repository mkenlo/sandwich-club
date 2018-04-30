package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich =  new Sandwich();

        try {
            JSONObject sandwichJson = new JSONObject(json);

            sandwich.setMainName(sandwichJson.getJSONObject("name").getString("mainName"));
            sandwich.setDescription(sandwichJson.getString("description"));
            sandwich.setPlaceOfOrigin(sandwichJson.getString("placeOfOrigin"));
            List<String> list = new ArrayList<>();
            JSONArray alias = sandwichJson.getJSONObject("name").getJSONArray("alsoKnownAs");
            for (int i = 0; i < alias.length(); i++){
                list.add(alias.getString(i));
            }
            sandwich.setAlsoKnownAs(list);
            list = new ArrayList<>();
            JSONArray ingredients = sandwichJson.getJSONArray("ingredients");
            for (int i = 0; i < ingredients.length(); i++){
                list.add(ingredients.getString(i));
            }
            sandwich.setIngredients(list);

            sandwich.setImage(sandwichJson.getString("image"));


        }catch(JSONException ex){
            ex.printStackTrace();
        }


        return sandwich;
    }
}
