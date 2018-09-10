package com.hb.androidcontrols.retrofit;

import android.content.Context;

import com.hb.androidcontrols.Utils.CommonUtils;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WSClient<T> {

    private static HashMap requestQue;

    public WSClient() {
        if (requestQue == null) {
            requestQue = new HashMap();
        }
    }

    private static void clearQueueAndDismissProgressDialog() {
        CommonUtils.hideProgress();
        requestQue.clear();
    }

    public void request(Context mContext,
                        final int requestId,
                        final boolean showProgress,
                        Call<T> call,
                        final ISuccessHandler<T> mSuccessHandler,
                        final IFailureHandler mFailureHandler) {


        if (showProgress) {
            setUpProgressDialog(mContext, requestId);
        }

        if (!CommonUtils.checkInternetConnection(mContext)) {

            if (showProgress) dismissProgressDialog(requestId);

            if (mFailureHandler != null) {
                mFailureHandler.failureResponse(requestId, "No Internet Connection.");
            }

        } else {

            call.enqueue(new Callback<T>() {
                @Override
                public void onResponse(Call<T> call, Response<T> response) {

                    if (showProgress) dismissProgressDialog(requestId);

                    if (mSuccessHandler != null) {
                        mSuccessHandler.successResponse(requestId, response);
                    }

                }

                @Override
                public void onFailure(Call<T> call, Throwable t) {

                    if (showProgress) dismissProgressDialog(requestId);

                    if (mFailureHandler != null) {
                        mFailureHandler.failureResponse(requestId, "" + t.getMessage());
                    }

                    call.cancel();

                }
            });

        }

    }

    private void setUpProgressDialog(Context mContext, int requestId) {
        requestQue.put(requestId, "Deployed");
        CommonUtils.showProgress(mContext);
    }

    private void dismissProgressDialog(int requestId) {
        if (requestQue.containsKey(requestId)) {
            requestQue.remove(requestId);
        }
        if (requestQue.size() <= 0) {
            CommonUtils.hideProgress();
        }
    }

}