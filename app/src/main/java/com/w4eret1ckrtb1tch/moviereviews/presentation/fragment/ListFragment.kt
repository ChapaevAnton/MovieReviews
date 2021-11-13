package com.w4eret1ckrtb1tch.moviereviews.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.w4eret1ckrtb1tch.moviereviews.R
import com.w4eret1ckrtb1tch.moviereviews.databinding.FragmentListBinding
import com.w4eret1ckrtb1tch.moviereviews.presentation.adapter.SpacingItemDecoration
import com.w4eret1ckrtb1tch.moviereviews.presentation.adapter.StateAdapter
import com.w4eret1ckrtb1tch.moviereviews.presentation.adapter.review.ReviewsAdapter
import com.w4eret1ckrtb1tch.moviereviews.presentation.viewmodel.ListViewModel
import com.w4eret1ckrtb1tch.moviereviews.presentation.viewmodel.ViewModelFactory
import dagger.Lazy
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ListFragment : DaggerFragment(R.layout.fragment_list) {

    private var binding: FragmentListBinding? = null

    @Inject
    lateinit var viewModelFactory: Lazy<ViewModelFactory>
    private val viewModel by viewModels<ListViewModel>(factoryProducer = { viewModelFactory.get() })
    private val adapter by lazy { ReviewsAdapter() }
    private val decorator by lazy { SpacingItemDecoration(5, 5) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            listReviews.addItemDecoration(decorator)
            listReviews.adapter = adapter.withLoadStateHeaderAndFooter(
                header = StateAdapter(),
                footer = StateAdapter { adapter.retry() }
            )
        }
        viewModel.getReview.observe(viewLifecycleOwner) { reviews ->
            adapter.submitData(lifecycle, reviews)
        }
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

}