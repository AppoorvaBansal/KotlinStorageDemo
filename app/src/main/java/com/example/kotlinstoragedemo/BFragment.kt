package com.example.kotlinstoragedemo


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_b.*
import kotlinx.android.synthetic.main.fragment_b.view.*

/**
 * A simple [Fragment] subclass.
 */
class BFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_b, container, false)

      view.btnNextOne.setOnClickListener {
            runBoard()
            findNavController().navigate(R.id.action_viewPagerFragment_to_loginFragment)
        }


   return view


    }

    private fun runBoard() {
        val sharedpref =requireActivity().getSharedPreferences("check", Context.MODE_PRIVATE)
        val editor = sharedpref.edit()
        editor.putBoolean("finish",true)
        editor.apply()
    }


}
