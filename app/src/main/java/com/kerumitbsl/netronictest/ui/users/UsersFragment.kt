package com.kerumitbsl.netronictest.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kerumitbsl.netronictest.base.BaseFragment
import com.kerumitbsl.netronictest.databinding.FragmentUsersBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class UsersFragment : BaseFragment() {

    private val binder: FragmentUsersBinding by lazy { FragmentUsersBinding.inflate(layoutInflater) }
    private val viewModel: UsersViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return binder.root
    }
}