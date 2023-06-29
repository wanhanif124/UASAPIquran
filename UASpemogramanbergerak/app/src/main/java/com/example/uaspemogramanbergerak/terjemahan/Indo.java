package com.example.uaspemogramanbergerak.terjemahan;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Indo{

    @SerializedName("translations")
    private List<ItemTranslation> translations;


    public List<ItemTranslation> getTranslations(){
        return translations;
    }


    @Override
    public String toString(){
        return
                "Indo{" +
                        "translations = '" + translations +
                        "}";
    }
}
