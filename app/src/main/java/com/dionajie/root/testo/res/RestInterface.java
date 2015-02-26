package com.dionajie.root.testo.res;

import com.dionajie.root.testo.Model.Guest;

import java.util.List;
import java.util.concurrent.Callable;


import retrofit.http.GET;
import retrofit.http.Query;
import retrofit.Callback;



/**
 * Created by root on 25/02/15.
 */
public interface RestInterface {

        @GET("/api/people")
        void getPeople(Callback<List<Guest>> callback);

}
