package com.example.achivify.ui.view

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.TextUtils
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.achivify.R
import com.example.achivify.databinding.FragmentExploreBinding
import com.example.achivify.databinding.FragmentTodoListBinding

class ExploreFragment : Fragment() {
    private var _binding: FragmentExploreBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            val colorSpan = ForegroundColorSpan(Color.parseColor("#FA6464"))
            val headingHighlighted = SpannableString("Explore")
            headingHighlighted.setSpan(colorSpan, 0, headingHighlighted.length,0)
            var headingText = SpannableString("People Stories")
            headingText = SpannableString.valueOf(TextUtils.concat(headingHighlighted, " ", headingText))
            explorePageTitle.text = headingText
        }
    }

}