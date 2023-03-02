package com.kerumitbsl.netronictest.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.kerumitbsl.core.bean.models.user.UserModel
import com.kerumitbsl.core.bean.response.TestTaskResponse
import com.kerumitbsl.netronictest.R
import com.kerumitbsl.netronictest.adapters.UsersListAdapter
import com.kerumitbsl.netronictest.base.BaseFragment
import com.kerumitbsl.netronictest.databinding.FragmentUsersBinding
import com.kerumitbsl.netronictest.other.SearchViewRetriever
import org.koin.androidx.viewmodel.ext.android.viewModel

class UsersFragment : BaseFragment() {

    private val binder: FragmentUsersBinding by lazy { FragmentUsersBinding.inflate(layoutInflater) }
    private val viewModel: UsersViewModel by viewModel()

    private val adapter: UsersListAdapter by lazy { UsersListAdapter() }

    private val contentList = mutableListOf<UserModel>()

    private val searchViewRetriever: SearchViewRetriever by lazy { activity as SearchViewRetriever }
    private val onQueryTextListener = object : OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            adapter.filter.filter(query)
            return false
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            adapter.filter.filter(newText)
            return false
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        reloadContent()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        setupAdapter()
        setupSwipeRefresh()
        setupListeners()
        observeData()

        return binder.root
    }

    override fun onStart() {
        searchViewRetriever.getAppBarSearchView().setOnQueryTextListener(onQueryTextListener)
        super.onStart()
    }

    private fun setupAdapter() {
        adapter.onClick = { navigateTo(UsersFragmentDirections.intoUserInfo(it)) }
        adapter.contentList = { contentList }

        binder.usersRecyclerView.adapter = adapter
        binder.usersRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun observeData() {
        viewModel.usersLiveData.observe(viewLifecycleOwner) { response ->
            when(response) {
                is TestTaskResponse.Success -> {
                    contentList.addAll(response.data.results)
                    viewModel.saveUsersIntoHistory(response.data.results.toList())
                    adapter.submitList(contentList)
                }
                is TestTaskResponse.Error -> binder.errorTextView.text = response.meta.error.ifBlank { getString(
                    R.string.something_went_wrong) }
            }
            binder.usersSwipeRefresh.isRefreshing = false
        }
    }

    private fun setupListeners() {
        binder.loadUsersButton.setOnClickListener {
            requestContent()
        }
        binder.historyButton.setOnClickListener {
            navigateTo(UsersFragmentDirections.intoHistory())
        }
    }

    private fun setupSwipeRefresh() {
        binder.usersSwipeRefresh.setOnRefreshListener { reloadContent() }
    }

    private fun reloadContent() {
        viewModel.refreshPagination()
        contentList.clear()
        requestContent()
    }

    private fun requestContent() {
        binder.usersSwipeRefresh.isRefreshing = true
        viewModel.loadUsersRequest()
    }
}