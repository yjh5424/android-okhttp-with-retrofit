package yjh.test.android_okhttp_retrofit;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dsm2016 on 2017-08-03.
 */

public interface Service {

    int HTTP_OK = 200;
    int HTTP_CREATED = 201;
    int HTTP_NO_CONTENT = 204;
    int HTTP_BAD_REQUEST = 400;
    int HTTP_INTERNAL_SERVER_ERROR = 500;

    String SERVER_URL="http://13.124.15.202:8080/";


    //you must use com.google.gson to use json
    @GET("print")
    Call<JsonArray> loadFood();

    @GET("print")
    Call<JsonArray> loadFoodCategory(@Query("") int num);

}
