package com.w4eret1ckrtb1tch.moviereviews.di

import androidx.paging.rxjava2.RxPagingSource
import com.w4eret1ckrtb1tch.moviereviews.data.repository.ReviewsPagingSource
import com.w4eret1ckrtb1tch.moviereviews.domain.entity.Review
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface PagingModule {

    @Reusable
    @Binds
    fun bindsReviewsPagingSource(
        reviewsPagingSource: ReviewsPagingSource
    ): @JvmSuppressWildcards RxPagingSource<Int, Review>

}