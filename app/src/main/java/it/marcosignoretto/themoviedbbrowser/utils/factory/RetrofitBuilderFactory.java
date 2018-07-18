package it.marcosignoretto.themoviedbbrowser.utils.factory;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 20/07/2017.
 */

public class RetrofitBuilderFactory {
    public static Retrofit.Builder createDefaultRetrofitBuilder(final String baseUrl, final Gson gson){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(LenientGsonConverterFactory.create(gson));
    }

    public static Retrofit.Builder createDefaultRxRetrofitBuilder(final String baseUrl, final Gson gson){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(LenientGsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
    }
}
