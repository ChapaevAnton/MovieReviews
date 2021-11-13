package com.w4eret1ckrtb1tch.moviereviews.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*


@Parcelize
data class Review(
    val id: UUID = UUID.randomUUID(),
    val titleImageUrl: String?,
    val title: String,
    val descriptionShort: String
) : Parcelable

@Parcelize
data class MovieReviews(
    val hasMore: Boolean? = false,
    val numResults: Long?,
    val reviews: List<Review>?
) : Parcelable