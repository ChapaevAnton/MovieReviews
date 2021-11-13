package com.w4eret1ckrtb1tch.moviereviews.presentation.adapter.review

import androidx.recyclerview.widget.DiffUtil
import com.w4eret1ckrtb1tch.moviereviews.domain.entity.Review

class ReviewComparator : DiffUtil.ItemCallback<Review>() {
    override fun areItemsTheSame(oldItem: Review, newItem: Review) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Review, newItem: Review) = oldItem == newItem
}