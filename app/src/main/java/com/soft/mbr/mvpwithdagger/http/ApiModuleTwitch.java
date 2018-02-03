package com.soft.mbr.mvpwithdagger.http;

import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mbrzeczek on 31.01.2018.
 */

@Module
public class ApiModuleTwitch {

    public final String BASE_URL = "https://api.twitch.tv/kraken/";
    public final String CLIENT_ID = "syqgwhqjg8ih9957fhttjuigi17tbc";


    @Provides
    public OkHttpClient provideClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);

        return new OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException
            {
                Request request = chain.request();
                HttpUrl url = request.url().newBuilder().addQueryParameter(
                        "client_id",
                        CLIENT_ID
                ).build();
                request = request.newBuilder().url(url).build();
                return chain.proceed(request);
            }
        }).build();
    }

    @Provides
    public Retrofit provideRetrofit(String baseUrl, OkHttpClient client){
        return  new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    public TwitchAPIService provideApiService(){
        return  provideRetrofit(BASE_URL, provideClient()).create(TwitchAPIService.class);
    }
}
