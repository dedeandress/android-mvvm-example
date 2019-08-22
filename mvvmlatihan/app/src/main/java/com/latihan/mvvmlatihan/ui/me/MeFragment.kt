package com.latihan.mvvmlatihan.ui.me

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

import com.latihan.mvvmlatihan.R

class MeFragment : Fragment() {

    companion object {
        fun newInstance() = MeFragment()
    }

    private lateinit var viewModel: MeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Profile"
        return inflater.inflate(R.layout.me_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
