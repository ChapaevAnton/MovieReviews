package com.w4eret1ckrtb1tch.moviereviews.data.repository

import androidx.paging.PagingState
import androidx.paging.rxjava2.RxPagingSource
import com.w4eret1ckrtb1tch.moviereviews.data.dto.MovieReviewsResponse
import com.w4eret1ckrtb1tch.moviereviews.data.dto.ReviewDto
import com.w4eret1ckrtb1tch.moviereviews.data.source.MovieReviewsAPI
import com.w4eret1ckrtb1tch.moviereviews.domain.entity.Review
import com.w4eret1ckrtb1tch.moviereviews.domain.mapper.ReviewsMapper
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ReviewsPagingSource @Inject constructor(
    private val api: MovieReviewsAPI,
    private val mapper: @JvmSuppressWildcards ReviewsMapper<ReviewDto, MovieReviewsResponse>
) : RxPagingSource<Int, Review>() {

    override fun getRefreshKey(state: PagingState<Int, Review>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null
        return anchorPage.prevKey?.plus(PAGE_STEP) ?: anchorPage.nextKey?.minus(PAGE_STEP)
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, Review>> {
        val nextPageNumber = params.key ?: INITIAL_PAGE
        return api.getReviews(
            MovieReviewsAPI.FILTER_CRITICS,
            MovieReviewsAPI.API_KEY,
            nextPageNumber
        )
            .subscribeOn(Schedulers.io()).map { movieReviewsResponse ->
                mapper.mapResponse(nextPageNumber, movieReviewsResponse)
            }.onErrorReturn { LoadResult.Error(it) }
    }

    companion object {
        const val INITIAL_PAGE = 0
        const val PAGE_STEP = 20
    }
}