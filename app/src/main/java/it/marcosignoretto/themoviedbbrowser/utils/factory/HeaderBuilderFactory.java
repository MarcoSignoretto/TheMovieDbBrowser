package it.marcosignoretto.themoviedbbrowser.utils.factory;

import android.util.Base64;

import it.marcosignoretto.themoviedbbrowser.utils.builder.HeaderBuilder;
import it.marcosignoretto.themoviedbbrowser.utils.builder.HeaderBuilder.Keys;
import it.marcosignoretto.themoviedbbrowser.utils.builder.HeaderBuilder.Values;

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 26/05/2017.
 */

public class HeaderBuilderFactory {

    public static HeaderBuilder createHttpHeaderBuilder(final String appName){
        return new HeaderBuilder()
                .add(Keys.ACCEPT, Values.TEXT_HTML)
                .add(Keys.X_REQUESTED_WITH, Values.XML_HTTP_REQUEST)
                .add(Keys.USER_AGENT, Values.userAgent(appName));
    }

    public static HeaderBuilder createHttpOAuthHeaderBuilder(final String appName, final String token){
        return createHttpHeaderBuilder(appName)
                .add(Keys.AUTHORIZATION, Values.bearer(token));
    }

    public static HeaderBuilder createHttpCookiesHeaderBuilder(final String appName, final String cookies){
        return createHttpHeaderBuilder(appName)
                .add(Keys.SET_COOKIE, cookies);
    }

    public static HeaderBuilder createDefaultBaseHeaderBuilder(final String appName){
        return new HeaderBuilder()
                .add(Keys.ACCEPT, Values.APPLICATION_JSON)
                .add(Keys.X_REQUESTED_WITH, Values.XML_HTTP_REQUEST)
                .add(Keys.USER_AGENT, Values.userAgent(appName));
    }

    public static HeaderBuilder createDefaultOAuthHeaderBuilder(final String appName, final String token){
        return createDefaultBaseHeaderBuilder(appName)
                .add(HeaderBuilder.Keys.AUTHORIZATION, Values.bearer(token));

    }

    public static HeaderBuilder createDefaultBasicAuthHeaderBuilder(final String appName, final String username, final String password){
        final String ps = username+":"+password;
        final String token = Base64.encodeToString(ps.getBytes(),Base64.NO_WRAP);
        return createDefaultBaseHeaderBuilder(appName)
                .add(HeaderBuilder.Keys.AUTHORIZATION, Values.basic(token));

    }


}
