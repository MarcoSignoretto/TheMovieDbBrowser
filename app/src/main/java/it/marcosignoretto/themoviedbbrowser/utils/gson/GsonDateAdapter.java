package it.marcosignoretto.themoviedbbrowser.utils.gson;

import android.text.TextUtils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */
public class GsonDateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {

    private DateFormat dateFormat;

    public GsonDateAdapter(final DateFormat dateFormat){
        this.dateFormat = dateFormat;
    }

    @Override
    public synchronized JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(dateFormat.format(date));
    }

    @Override
    public synchronized Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        try {
            if (TextUtils.isEmpty(jsonElement.getAsString())) return null;
            else return dateFormat.parse(jsonElement.getAsString());
        } catch (ParseException e) {
            throw new JsonParseException(e);
        }
    }
}
