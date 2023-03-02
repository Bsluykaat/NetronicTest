package com.kerumitbsl.netronictest.ui.userInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.kerumitbsl.netronictest.R
import com.kerumitbsl.netronictest.databinding.FragmentUserInfoBinding
import com.kerumitbsl.netronictest.extensions.formatHtml
import com.kerumitbsl.netronictest.extensions.loadImage
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserInfoFragment : Fragment() {

    private val binder: FragmentUserInfoBinding by lazy { FragmentUserInfoBinding.inflate(layoutInflater) }
    private val args: UserInfoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        setupData()

        return binder.root
    }

    private fun setupData() {
        loadImage(args.user.picture.large, binder.userInfoIconImageView)
        binder.userInfoNameTextView.text = getString(R.string.initials_text, "${args.user.name.title} ${args.user.name.first} ${args.user.name.last}")
        binder.userInfoGenderTextView.text = getString(R.string.gender_text, args.user.gender)
        binder.userInfoEmailTextView.text = getString(R.string.email_text, args.user.email)
        binder.userInfoNationalityTextView.text = getString(R.string.nationality_text, args.user.nat)
        binder.userInfoDateOfBirthTextView.text = getString(R.string.date_of_birth_text, args.user.dob.date, args.user.dob.age.toString())
        binder.userInfoIdTextView.text = getString(R.string.id_text, args.user.id.name, args.user.id.value)
    }

}