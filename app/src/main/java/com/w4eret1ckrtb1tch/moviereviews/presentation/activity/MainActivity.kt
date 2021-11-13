package com.w4eret1ckrtb1tch.moviereviews.presentation.activity

import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.w4eret1ckrtb1tch.moviereviews.R
import com.w4eret1ckrtb1tch.moviereviews.databinding.ActivityMainBinding
import com.w4eret1ckrtb1tch.moviereviews.presentation.fragment.ListFragment
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<ListFragment>(R.id.fragment_container)
            }
        }
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}