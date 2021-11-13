package com.w4eret1ckrtb1tch.moviereviews.di

import androidx.lifecycle.ViewModel
import com.w4eret1ckrtb1tch.moviereviews.presentation.fragment.ListFragment
import com.w4eret1ckrtb1tch.moviereviews.presentation.viewmodel.ListViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface FragmentModule {

    @ContributesAndroidInjector(
        modules = [
            ViewModelBuilder::class
        ]
    )
    fun listFragment(): ListFragment

    @Binds
    @[IntoMap ViewModelKey(ListViewModel::class)]
    fun bindsListViewModel(listViewModel: ListViewModel): ViewModel
}