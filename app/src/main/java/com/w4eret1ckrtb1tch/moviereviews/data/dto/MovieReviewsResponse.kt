package com.w4eret1ckrtb1tch.moviereviews.data.dto

import com.google.gson.annotations.SerializedName

data class MovieReviewsResponse(
    @field:SerializedName("copyright") val copyright: String?,
    @field:SerializedName("has_more") val hasMore: Boolean?,
    @field:SerializedName("num_results") val numResults: Long?,
    @field:SerializedName("results") val reviewResponse: List<ReviewDto>?,
    @field:SerializedName("status") val status: String?
)
