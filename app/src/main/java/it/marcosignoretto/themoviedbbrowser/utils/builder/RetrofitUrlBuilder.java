package it.marcosignoretto.themoviedbbrowser.utils.builder;

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 22/06/2017.
 */

/**
 * This class allows to generate dynamic url with path variables, variables names are not used but only positions are considered
 */
public class RetrofitUrlBuilder {

    private String urlWithPath;
    private final Object[] pathParams;

    /**
     * Create a RetrofitUrlBuilder, which allow to generate dynamic urls with path variables
     * @param urlWithPath: url with path variable (example /hello/{pathVar1}/execute)
     * @param pathParams: list of values for the path variables
     */
    public RetrofitUrlBuilder(final String urlWithPath, final Object ... pathParams) {
        this.urlWithPath = urlWithPath;
        this.pathParams = pathParams;
    }

    /**
     * Substitute path variable with content of pathParams used in constructor
     * @return String obtained after parameters substitutions
     */
    public String build() {
        int counter = 0;
        for (int i = 0; i < pathParams.length; ++i){
            if(urlWithPath.contains("{") && urlWithPath.contains("}")) {
                urlWithPath = urlWithPath.replaceFirst("\\{.+?\\}", pathParams[i].toString());
                ++counter;
            }
        }
        if(counter != pathParams.length) throw new IllegalArgumentException("Too many path params");
        if(urlWithPath.contains("{") || urlWithPath.contains("}")) throw new IllegalArgumentException("To few params into pathParams or malformat path");
        return urlWithPath;
    }

}
