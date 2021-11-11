package com.example.kotlinstoragedemo


import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass.
 */
class SplashScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_splash_screen, container, false)

        Handler(Looper.getMainLooper()).postDelayed({

           // findNavController().navigate(R.id.action_splashScreenFragment_to_viewPagerFragment)

            if(!runBoard()){
                findNavController().navigate(R.id.action_splashScreenFragment_to_viewPagerFragment)
            }else{
                findNavController().navigate(R.id.action_splashScreenFragment_to_loginFragment)
            }

        },2000)
   return view
    }

    private fun runBoard(): Boolean {

        val sharedpref =requireActivity().getSharedPreferences("check", Context.MODE_PRIVATE)
        return sharedpref.getBoolean("finish",false)

    }


}
