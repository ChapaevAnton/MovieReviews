package com.w4eret1ckrtb1tch.moviereviews.di

import com.w4eret1ckrtb1tch.moviereviews.presentation.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {


    @ContributesAndroidInjector(
        modules = [
        ViewModelBuilder::class
        ]
    )
    fun mainActivity(): MainActivity

}