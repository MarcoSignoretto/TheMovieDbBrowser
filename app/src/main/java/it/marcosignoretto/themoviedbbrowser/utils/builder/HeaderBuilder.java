package it.marcosignoretto.themoviedbbrowser.utils.builder;

import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 26/05/2017.
 */

/**
 * Builder which allows to generate headers for retrofit and not only
 */
public class HeaderBuilder {

    /**
     * Set of useful Http keys used in app webservices
     */
    public static final class Keys{
        public static final String ACCEPT = "Accept";
        public static final String X_REQUESTED_WITH = "X-Requested-With";
        public static final String USER_AGENT = "User-Agent";
        public static final String CONTENT_TYPE = "Content-Type";
        public static final String AUTHORIZATION = "Authorization";
        public static final String SET_COOKIE = "Set-Cookie";
    }

    /**
     * Set of useful Http values used in app webservices, and methods to compose dynamic values like Authorization header
     */
    public static final class Values {
        public static final String APPLICATION_JSON = "application/json";
        public static final String APPLICATION_URLENCODED = "application/x-www-form-urlencoded";
        public static final String XML_HTTP_REQUEST = "XMLHttpRequest";
        public static final String TEXT_HTML = "text/html";

        @NonNull public static String token(@NonNull final String value){return "Token "+value;}
        @NonNull public static String bearer(@NonNull final String value){return "Bearer "+value;}
        @NonNull public static String basic(@NonNull final String value){return "Basic "+value;}

        @NonNull public static String userAgent(@NonNull final String appName){return appName+ "(Linux; Android)";}


    }

    private Map<String,String> headers = new HashMap<>();
    private int headerCount = 0;

    public HeaderBuilder() {
    }

    /**
     * Method used to add an Header rule to current header
     * @param key: Http key, try to avoid hardcoded String and use HeaderBuilder.Keys
     * @param value: Http Value, try to avoid hardcoded String and use HeaderBuilder.Values
     * @return current builder as in any builder pattern
     * @see HeaderBuilder.Keys
     * @see HeaderBuilder.Values
     */
    public HeaderBuilder add(@NonNull final String key, @NonNull final String value){
        headers.put(key, value);
        return this;
    }

    /**
     * Method used to create Header for a webservice from the current builder state
     * @return the header which is a simple java Map, and should be used as value for a @HeaderMap parameter
     */
    public Map<String,String> build(){
        return headers;
    }


}
