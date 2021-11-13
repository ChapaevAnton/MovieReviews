package com.w4eret1ckrtb1tch.moviereviews.di

import androidx.lifecycle.ViewModelProvider
import com.w4eret1ckrtb1tch.moviereviews.presentation.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface ViewModelBuilder {

    @Reusable
    @Binds
    fun bindsViewModelFactory(
        viewModelFactory: ViewModelFactory
    ): ViewModelProvider.Factory

}