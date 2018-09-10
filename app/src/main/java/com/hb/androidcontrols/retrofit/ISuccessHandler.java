package com.hb.androidcontrols.retrofit;

import retrofit2.Response;

public interface ISuccessHandler<T> {

    void successResponse(int requestCode, Response<T> mResponse);

}
