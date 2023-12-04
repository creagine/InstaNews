package com.rudiridho.instanews.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rudiridho.instanews.viewModel.NewsViewModel
import com.rudiridho.instanews.databinding.FragmentNewsListBinding
import com.rudiridho.instanews.view.adapter.NewsAdapter

class NewsListFragment : Fragment() {

    private lateinit var viewModel: NewsViewModel
    private lateinit var newsAdapter: NewsAdapter
    private var _binding: FragmentNewsListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize ViewModel
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        // Initialize RecyclerView
        newsAdapter = NewsAdapter()
        binding.newsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.newsRecyclerView.adapter = newsAdapter

        viewModel.getTopHeadlines("b3bc3e676c1341afaae60cf01bfb1d41", "us")

        // Observe ViewModel LiveData
        viewModel.topHeadlines.observe(viewLifecycleOwner) { articles ->
            newsAdapter.submitList(articles)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
