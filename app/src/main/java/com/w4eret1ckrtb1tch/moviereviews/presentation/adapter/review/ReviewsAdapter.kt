package com.w4eret1ckrtb1tch.moviereviews.presentation.adapter.review

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.w4eret1ckrtb1tch.moviereviews.databinding.ItemReviewBinding
import com.w4eret1ckrtb1tch.moviereviews.domain.entity.Review

class ReviewsAdapter : PagingDataAdapter<Review, ReviewsAdapter.ReviewItem>(ReviewComparator()) {

    override fun onBindViewHolder(holder: ReviewItem, position: Int) =
        holder.bind(getItem(position))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ReviewItem(LayoutInflater.from(parent.context), parent)

    class ReviewItem internal constructor(private val binding: ItemReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            operator fun invoke(
                layoutInflater: LayoutInflater,
                parent: ViewGroup? = null,
                attachToRoot: Boolean = false
            ): ReviewItem {
                return ReviewItem(ItemReviewBinding.inflate(layoutInflater, parent, attachToRoot))
            }
        }

        fun bind(review: Review?) {
            review?.let {
                with(binding) {
                    Glide.with(root).load(review.titleImageUrl).centerCrop().into(titleImage)
                    title.text = review.title
                    descriptionShort.text = review.descriptionShort
                }
            }
        }
    }
}