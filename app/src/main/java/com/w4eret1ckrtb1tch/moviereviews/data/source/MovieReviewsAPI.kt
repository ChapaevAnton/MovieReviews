package com.w4eret1ckrtb1tch.moviereviews.data.source

import com.w4eret1ckrtb1tch.moviereviews.BuildConfig
import com.w4eret1ckrtb1tch.moviereviews.data.dto.MovieReviewsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieReviewsAPI {

    @GET("svc/movies/v2/reviews/{filter}.json")
    fun getReviews(
        @Path("filter") filterCritics: String,
        @Query("api-key") apiKey: String,
        @Query("offset") page: Int
    ): Single<MovieReviewsResponse>

    companion object Options {
        const val BASE_URL = "https://api.nytimes.com/"
        const val FILTER_CRITICS = "all"
        const val API_KEY = BuildConfig.API_KEY
    }
}