package com.w4eret1ckrtb1tch.moviereviews.domain.mapper

import androidx.paging.PagingSource
import com.w4eret1ckrtb1tch.moviereviews.domain.entity.MovieReviews
import com.w4eret1ckrtb1tch.moviereviews.domain.entity.Review

interface ReviewsMapper<in REVIEW, in MOVE_REVIEWS> {

    fun mapResponse(reviewDto: REVIEW): Review

    fun mapResponse(reviewsDto: List<REVIEW>): List<Review>

    fun mapResponse(movieReviewsResponse: MOVE_REVIEWS): MovieReviews

    fun mapResponse(
        page: Int,
        movieReviewsResponse: MOVE_REVIEWS
    ): PagingSource.LoadResult<Int, Review>

}