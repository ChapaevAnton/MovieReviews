package com.w4eret1ckrtb1tch.moviereviews.data.mapper

import androidx.paging.PagingSource
import com.w4eret1ckrtb1tch.moviereviews.data.dto.MovieReviewsResponse
import com.w4eret1ckrtb1tch.moviereviews.data.dto.ReviewDto
import com.w4eret1ckrtb1tch.moviereviews.data.repository.ReviewsPagingSource.Companion.PAGE_STEP
import com.w4eret1ckrtb1tch.moviereviews.domain.entity.MovieReviews
import com.w4eret1ckrtb1tch.moviereviews.domain.entity.Review
import com.w4eret1ckrtb1tch.moviereviews.domain.mapper.ReviewsMapper
import javax.inject.Inject

class ReviewsMapperImpl @Inject constructor() :
    ReviewsMapper<@JvmSuppressWildcards ReviewDto, @JvmSuppressWildcards MovieReviewsResponse> {

    override fun mapResponse(
        page: Int,
        movieReviewsResponse: MovieReviewsResponse
    ): PagingSource.LoadResult<Int, Review> {
        return PagingSource.LoadResult.Page(
            data = mapResponse(movieReviewsResponse.reviewResponse ?: emptyList()),
            prevKey = if (page == 0) null else page.minus(PAGE_STEP),
            nextKey = if (movieReviewsResponse.hasMore == false) null else page.plus(PAGE_STEP)
        )
    }

    override fun mapResponse(reviewDto: ReviewDto): Review {
        return with(reviewDto) {
            Review(
                title = displayTitle ?: "no title",
                descriptionShort = summaryShort ?: "no description",
                titleImageUrl = multimedia?.srcUrl
            )
        }
    }

    override fun mapResponse(reviewsDto: List<ReviewDto>): List<Review> {
        return reviewsDto.map { mapResponse(it) }
    }

    override fun mapResponse(movieReviewsResponse: MovieReviewsResponse): MovieReviews {
        return with(movieReviewsResponse) {
            MovieReviews(
                hasMore = hasMore,
                numResults = numResults,
                reviews = mapResponse(reviewResponse ?: emptyList())
            )
        }
    }
}