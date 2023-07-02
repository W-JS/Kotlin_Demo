package com.example.demo.ui.point

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.demo.base.Config
import com.example.demo.databinding.FragmentPointBinding

class PointFragment : Fragment() {

    private val TAG: String = Config.BASE_TAG + PointFragment::class.java.simpleName

    private var _binding: FragmentPointBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreateView: ")
        val pointViewModel =
            ViewModelProvider(this).get(PointViewModel::class.java)

        _binding = FragmentPointBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textPoint
        pointViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        Log.d(TAG, "onDestroyView: ")
        super.onDestroyView()
        _binding = null
    }
}