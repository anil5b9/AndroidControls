package com.hb.androidcontrols.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static RetrofitInterface mRetrofitInterface;

    public static RetrofitInterface getmRetrofitInterface() {

        if (mRetrofitInterface == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(RetrofitConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mRetrofitInterface = retrofit.create(RetrofitInterface.class);
        }

        return mRetrofitInterface;
    }
}
