package com.kerumitbsl.netronictest.ui.userInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kerumitbsl.netronictest.databinding.FragmentUserInfoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserInfoFragment : Fragment() {

    private val binder: FragmentUserInfoBinding by lazy { FragmentUserInfoBinding.inflate(layoutInflater) }
    private val viewModel: UserInfoViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binder.root
    }

}