package it.marcosignoretto.themoviedbbrowser.utils.factory;

import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.DateFormat;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;


/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 12/05/2017.
 */

public class RetrofitFactory {


    public static Retrofit createDefaultRxGsonRetrofit(String baseUrl, boolean logHttpRequests,@Nullable Integer connectionTimeoutSeconds, @Nullable DateFormat dateFormat ){
        if(baseUrl == null)baseUrl = "http://www.placeholder.com/";

        GsonBuilder gsonBuilder = GsonBuilderFactory.createDefaultGsonBuilder(dateFormat);
        Gson gson = gsonBuilder.create();

        Retrofit.Builder retrofitBuilder = RetrofitBuilderFactory.createDefaultRxRetrofitBuilder(baseUrl,gson);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // Logging purpose
        if(logHttpRequests) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            httpClient.addInterceptor(logging);
        }
        if(connectionTimeoutSeconds!=null){
            httpClient.connectTimeout(connectionTimeoutSeconds, TimeUnit.SECONDS);
            httpClient.readTimeout(connectionTimeoutSeconds, TimeUnit.SECONDS);
        }
        retrofitBuilder.client(httpClient.build());
        return retrofitBuilder.build();
    }



}
