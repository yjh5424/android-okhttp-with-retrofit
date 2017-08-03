package yjh.test.android_okhttp_retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dsm2016 on 2017-08-03.
 */

public class HttpManager {

    public static Service getInstance(){
        OkHttpClient client=new OkHttpClient.Builder()
                .build();

        return new Retrofit.Builder()
                .baseUrl(Service.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Service.class);
    }
}


