package com.w4eret1ckrtb1tch.moviereviews.domain.repository

import androidx.paging.PagingData
import com.w4eret1ckrtb1tch.moviereviews.domain.entity.Review
import io.reactivex.Flowable

interface ReviewsRepository {

    fun getMovieReviews(): Flowable<PagingData<Review>>

}