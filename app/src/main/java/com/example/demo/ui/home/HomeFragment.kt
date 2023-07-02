package com.example.demo.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.demo.MainActivity
import com.example.demo.R
import com.example.demo.TargetActivity
import com.example.demo.base.Config
import com.example.demo.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), View.OnClickListener {

    private val TAG: String = Config.BASE_TAG + HomeFragment::class.java.simpleName

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreateView: ")
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val hintBtn: Button = binding.btnHint
        homeViewModel.hintText.observe(viewLifecycleOwner) {
            hintBtn.text = it
        }
        hintBtn.setOnClickListener(this)

        val jumpBtn: Button = binding.btnJump
        homeViewModel.jumpText.observe(viewLifecycleOwner) {
            jumpBtn.text = it
        }
        jumpBtn.setOnClickListener(this)

        return root
    }

    override fun onDestroyView() {
        Log.d(TAG, "onDestroyView: ")
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_hint -> {
                val text = binding.btnHint.text
                Log.d(TAG, "onClick: $text")
                val activity: FragmentActivity? = this.activity
                Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
            }

            R.id.btn_jump -> {
                val text = binding.btnJump.text
                val activity: FragmentActivity? = this.activity
                val intent =
                    if (MainActivity::class.java.simpleName in activity.toString()) {
                        Intent(activity, TargetActivity::class.java)
                    } else {
                        Intent(activity, MainActivity::class.java)
                    }
                Log.d(TAG, "onClick: $text -> ${intent.component?.shortClassName}")
                startActivity(intent)
            }
        }
    }
}