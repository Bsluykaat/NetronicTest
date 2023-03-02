package com.kerumitbsl.netronictest.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.kerumitbsl.core.bean.models.user.UserModel
import com.kerumitbsl.core.bean.response.TestTaskResponse
import com.kerumitbsl.netronictest.R
import com.kerumitbsl.netronictest.adapters.UsersListAdapter
import com.kerumitbsl.netronictest.base.BaseFragment
import com.kerumitbsl.netronictest.databinding.FragmentHistoryBinding
import com.kerumitbsl.netronictest.other.SearchViewRetriever
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryFragment : BaseFragment() {

    private val binder: FragmentHistoryBinding by lazy { FragmentHistoryBinding.inflate(layoutInflater) }
    private val viewModel: HistoryViewModel by viewModel()

    private val adapter: UsersListAdapter by lazy { UsersListAdapter() }

    private val contentList = mutableListOf<UserModel>()

    private val searchViewRetriever: SearchViewRetriever by lazy { activity as SearchViewRetriever }
    private val onQueryTextListener = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            adapter.filter.filter(query)
            return false
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            adapter.filter.filter(newText)
            return false
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        setupListeners()
        observeData()
        setupAdapter()
        setupSwipeRefresh()

        return binder.root
    }

    override fun onStart() {
        searchViewRetriever.getAppBarSearchView().setOnQueryTextListener(onQueryTextListener)
        reloadContent()
        super.onStart()
    }

    private fun setupAdapter() {
        adapter.onClick = { navigateTo(HistoryFragmentDirections.fromHistoryIntoUserInfo(it)) }
        adapter.contentList = { contentList }

        binder.historyRecyclerView.adapter = adapter
        binder.historyRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun observeData() {
        viewModel.historyLiveData.observe(viewLifecycleOwner) { response ->
            when(response) {
                is TestTaskResponse.Success -> {
                    contentList.addAll(response.data)
                    adapter.submitList(contentList)
                }
                is TestTaskResponse.Error -> binder.errorTextView.text = response.meta.error.ifBlank { getString(
                    R.string.something_went_wrong) }
            }
            binder.historySwipeRefresh.isRefreshing = false
        }
    }

    private fun setupListeners() {

    }

    private fun setupSwipeRefresh() {
        binder.historySwipeRefresh.setOnRefreshListener { reloadContent() }
    }

    private fun reloadContent() {
        viewModel.refreshPagination()
        contentList.clear()
        requestContent()
    }

    private fun requestContent() {
        binder.historySwipeRefresh.isRefreshing = true
        viewModel.queryHistoryUsers()
    }
}