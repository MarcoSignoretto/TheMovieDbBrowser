package it.marcosignoretto.themoviedbbrowser.utils.factory;


import com.google.gson.GsonBuilder;

import java.text.DateFormat;
import java.util.Date;

import io.reactivex.annotations.Nullable;
import it.marcosignoretto.themoviedbbrowser.utils.gson.BooleanSerializer;
import it.marcosignoretto.themoviedbbrowser.utils.gson.GsonDateAdapter;

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 20/07/2017.
 */

public class GsonBuilderFactory {
    public static GsonBuilder createDefaultGsonBuilder(@Nullable final DateFormat dateFormat){
        final GsonBuilder gsonBuilder = new GsonBuilder()
                .registerTypeAdapter(Boolean.class, new BooleanSerializer())
                .excludeFieldsWithoutExposeAnnotation();
        if(dateFormat!=null){
            gsonBuilder.registerTypeAdapter(Date.class, new GsonDateAdapter(dateFormat));
        }
        return gsonBuilder;
    }
}
