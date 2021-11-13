package com.w4eret1ckrtb1tch.moviereviews.presentation.activity

import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity


class SplashScreen : AppCompatActivity() {

    private val mHandler = Handler(Looper.getMainLooper())
    private val mLauncher: Launcher = Launcher()
    override fun onStart() {
        super.onStart()
        mHandler.postDelayed(mLauncher, SPLASH_DELAY)
    }

    override fun onStop() {
        mHandler.removeCallbacks(mLauncher)
        super.onStop()
    }

    private fun launch() {
        if (!isFinishing) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private inner class Launcher : Runnable {
        override fun run() {
            launch()
        }
    }

    companion object {
        private const val SPLASH_DELAY = 3000L
    }
}