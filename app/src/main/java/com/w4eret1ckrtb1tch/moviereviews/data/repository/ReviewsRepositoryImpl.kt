package com.w4eret1ckrtb1tch.moviereviews.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava2.RxPagingSource
import androidx.paging.rxjava2.flowable
import com.w4eret1ckrtb1tch.moviereviews.domain.entity.Review
import com.w4eret1ckrtb1tch.moviereviews.domain.repository.ReviewsRepository
import io.reactivex.Flowable
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

class ReviewsRepositoryImpl @Inject constructor(
    private val reviewsSource: @JvmSuppressWildcards RxPagingSource<Int, Review>
) : ReviewsRepository {

    private val configReviewsSource = PagingConfig(
        pageSize = 20,
        enablePlaceholders = false,
        prefetchDistance = 10,
        maxSize = 500
    )

    @ExperimentalCoroutinesApi
    override fun getMovieReviews(): Flowable<PagingData<Review>> {
        return Pager(
            config = configReviewsSource,
            pagingSourceFactory = { reviewsSource }
        ).flowable
    }
}