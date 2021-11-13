package com.w4eret1ckrtb1tch.moviereviews.di

import com.w4eret1ckrtb1tch.moviereviews.data.dto.MovieReviewsResponse
import com.w4eret1ckrtb1tch.moviereviews.data.dto.ReviewDto
import com.w4eret1ckrtb1tch.moviereviews.data.mapper.ReviewsMapperImpl
import com.w4eret1ckrtb1tch.moviereviews.data.repository.ReviewsRepositoryImpl
import com.w4eret1ckrtb1tch.moviereviews.domain.mapper.ReviewsMapper
import com.w4eret1ckrtb1tch.moviereviews.domain.repository.ReviewsRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface AppModule {

    @Reusable
    @Binds
    fun bindsReviewsMapper(
        reviewsMapper: ReviewsMapperImpl
    ): @JvmSuppressWildcards ReviewsMapper<ReviewDto, MovieReviewsResponse>

    @Reusable
    @Binds
    fun bindsReviewsRepository(reviewsRepository: ReviewsRepositoryImpl): ReviewsRepository

}