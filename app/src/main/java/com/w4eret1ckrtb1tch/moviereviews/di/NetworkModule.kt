package com.w4eret1ckrtb1tch.moviereviews.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.w4eret1ckrtb1tch.moviereviews.BuildConfig
import com.w4eret1ckrtb1tch.moviereviews.data.source.MovieReviewsAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
object NetworkModule {

    @Singleton
    @Provides
    fun providesMovieReviewsAPI(retrofit: Retrofit): MovieReviewsAPI =
        retrofit.create(MovieReviewsAPI::class.java)

    @Singleton
    @Provides
    fun providesRetrofit(
        builder: Retrofit.Builder,
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit = builder
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .baseUrl(MovieReviewsAPI.BASE_URL)
        .build()

    @Singleton
    @Provides
    fun providesRetrofitBuilder(): Retrofit.Builder = Retrofit.Builder()

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .callTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) level = HttpLoggingInterceptor.Level.BASIC
        }
    }

    @Singleton
    @Provides
    fun providesGsonClient(): Gson = GsonBuilder().create()

}