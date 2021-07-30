package com.haidv.navigationcomponent.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.haidv.navigationcomponent.R
import com.haidv.navigationcomponent.databinding.FragmentWatchBinding

class WatchFragment : Fragment(), View.OnClickListener {

    private var binding: FragmentWatchBinding? = null

    companion object {
        @JvmStatic
        fun newInstance() =
            WatchFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_watch, container, false)

        initUI()
        return binding?.root
    }

    private fun initUI() {
        binding?.let {
            it.buttonOpenHome.setOnClickListener(this)
            it.buttonOpenNews.setOnClickListener(this)
            it.buttonOpenLibrary.setOnClickListener(this)
            it.buttonOpenMore.setOnClickListener(this)
        }
    }

    override fun onClick(v: View?) {
        val controller = findNavController()
        when(v?.id){
            R.id.buttonOpenHome -> controller.navigate(R.id.homeFragment)
            R.id.buttonOpenNews -> controller.navigate(R.id.newsFragment)
            R.id.buttonOpenLibrary -> controller.navigate(R.id.libraryFragment)
            R.id.buttonOpenMore -> controller.navigate(R.id.moreFragment)
        }
    }

}