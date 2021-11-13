package com.w4eret1ckrtb1tch.moviereviews.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.rxjava2.cachedIn
import com.w4eret1ckrtb1tch.moviereviews.domain.entity.Review
import com.w4eret1ckrtb1tch.moviereviews.domain.repository.ReviewsRepository
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject


class ListViewModel @Inject constructor(private val repository: ReviewsRepository) : ViewModel() {

    private val review: MutableLiveData<PagingData<Review>> = MutableLiveData()
    val getReview: LiveData<PagingData<Review>> = review
    private val compositeDisposable = CompositeDisposable()

    init {
        loadReviews()
    }

    @ExperimentalCoroutinesApi
    private fun loadReviews() {
        compositeDisposable.add(
            repository.getMovieReviews()
                .cachedIn(viewModelScope)
                .subscribe {
                    review.value = it
                })
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}