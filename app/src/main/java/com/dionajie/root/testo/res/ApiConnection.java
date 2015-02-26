package com.dionajie.root.testo.res;

import android.content.Context;
import android.net.http.HttpResponseCache;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.client.Response;
import retrofit.http.GET;


public class ApiConnection {

    public static final String END_POINT = "http://dry-sierra-6832.herokuapp.com";

    public static final int CACHE_SIZE = 10 * 1024 * 1024;


    static RestAdapter restAdapter;
    static Context context;

    class SampleErrorHandler implements ErrorHandler{

        @Override
        public Throwable handleError(RetrofitError cause) {
            Response r = cause.getResponse();

            return cause;

        }
    }

    public static RestAdapter getRestAdapter(Context contextActivity){
        context = contextActivity;
        if (restAdapter == null)buildRestAdapter();
        return restAdapter;
    }

    private static void buildRestAdapter(){
        OkHttpClient okHttpClient = new OkHttpClient();
        File cacheDir = new File(context.getFilesDir(), "cached_sample");
        try {
            Cache responseCache = new Cache(cacheDir,CACHE_SIZE);
            okHttpClient.setCache(responseCache);
            restAdapter = new RestAdapter.Builder()
                    .setEndpoint(END_POINT)
                    .setClient(new OkClient(okHttpClient))
                    .build();
        }catch (IOException e){
            Log.i("ApiConnection",e.getMessage());

        }

    }

    private OkHttpClient getOkClient() throws IOException{
        OkHttpClient okHttpClient = new OkHttpClient();
        File cacheDir = new File(System.getProperty("java.io.tmpdir"), UUID.randomUUID().toString());
        Cache responseCache = new Cache(cacheDir,1024);
        okHttpClient.setCache(responseCache);
        return okHttpClient;
    }
}
