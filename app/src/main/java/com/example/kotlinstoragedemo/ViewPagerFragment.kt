package com.example.kotlinstoragedemo


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinstoragedemo.OnBoarding.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_view_pager.view.*

/**
 * A simple [Fragment] subclass.
 */
class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_view_pager, container, false)

        val frList = arrayListOf<Fragment>(
            AFragment(),BFragment()
        )
        val adapter = ViewPagerAdapter(frList,requireActivity().supportFragmentManager,lifecycle)

        view.viewpager1.adapter =adapter


        return  view
    }


}
