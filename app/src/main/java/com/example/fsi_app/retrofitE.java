package com.example.fsi_app;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class retrofitE {
    private static retrofitE instance = null;

    private apiFSI myApi;

    private retrofitE(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(apiFSI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(apiFSI.class);
    }

    public static retrofitE getInstance(){

        if(instance == null){
            instance = new retrofitE();
        }
        return instance;
    }

    public apiFSI getMyApi(){
        return myApi;
    }

}
