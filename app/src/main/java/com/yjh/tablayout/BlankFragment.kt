package com.yjh.tablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/*
* 创造空页面
* */

private const val ARG_PARAM1 = "param1"


class BlankFragment : Fragment() {

    private var mTextString: String? = null
    var rootView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mTextString = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if(rootView == null) {
            rootView = inflater.inflate(R.layout.blankfragment, container, false)
        }
        initView()
        return rootView
    }

    private fun initView() {
        val textView: TextView = rootView?.let {
            it.findViewById(R.id.text)
        }!!
        textView.text = mTextString

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) = //在这里创建fragment，并且外部的参数从这里传进来，之后通过bundle和ARG_PARAM1关键字拿到
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}