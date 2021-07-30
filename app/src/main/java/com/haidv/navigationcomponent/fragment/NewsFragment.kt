package com.haidv.navigationcomponent.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.haidv.navigationcomponent.R
import com.haidv.navigationcomponent.databinding.FragmentNewsBinding

class NewsFragment : Fragment(), View.OnClickListener {

    private var binding: FragmentNewsBinding? = null

    companion object {

        @JvmStatic
        fun newInstance() =
            NewsFragment().apply {
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false)

        initUI()
        return binding?.root
    }

    private fun initUI() {
        binding?.let {
            it.buttonOpenHome.setOnClickListener(this)
            it.buttonOpenLibrary.setOnClickListener(this)
            it.buttonOpenWatch.setOnClickListener(this)
            it.buttonOpenMore.setOnClickListener(this)
        }
    }

    override fun onClick(v: View?) {
        val controller = findNavController()
        when(v?.id){
            R.id.buttonOpenHome -> controller.navigate(R.id.homeFragment)
            R.id.buttonOpenLibrary -> controller.navigate(R.id.libraryFragment)
            R.id.buttonOpenWatch -> controller.navigate(R.id.watchFragment)
            R.id.buttonOpenMore -> controller.navigate(R.id.moreFragment)
        }
    }

}