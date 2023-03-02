package com.kerumitbsl.netronictest.base

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

open class BaseFragment: Fragment() {

    fun navigateTo(navDirections: NavDirections) = findNavController().navigate(navDirections)

    //Here would be more useful methods and variables if needed
}