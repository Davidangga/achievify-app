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
import com.example.achivify.databinding.FragmentAchievementsBinding
import com.example.achivify.databinding.FragmentExploreBinding

class AchievementsFragment : Fragment() {
    private var _binding: FragmentAchievementsBinding? = null
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
        _binding = FragmentAchievementsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            val colorSpan = ForegroundColorSpan(Color.parseColor("#FA6464"))
            val headingHighlighted = SpannableString("Achievement")
            headingHighlighted.setSpan(colorSpan, 0, headingHighlighted.length,0)
            var headingText = SpannableString("Made by You")
            headingText = SpannableString.valueOf(TextUtils.concat(headingHighlighted, " ", headingText))
            explorePageTitle.text = headingText
        }
    }
}