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
import com.example.achivify.databinding.FragmentTodoListBinding
import java.text.SimpleDateFormat
import java.util.Date

class TodoListFragment : Fragment() {

    private var _binding: FragmentTodoListBinding? = null
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
        _binding = FragmentTodoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            val currentDate = Date()
            val userName = SpannableString("David")
            val currentDateReformat = SpannableString(SimpleDateFormat("dd MMM yyyy").format(currentDate))
            var headingText = SpannableString("What's Up,")
            var dateText = SpannableString("Today,")

            val colorSpan = ForegroundColorSpan(Color.parseColor("#FA6464"))

            userName.setSpan(colorSpan, 0, userName.length, 0)
            currentDateReformat.setSpan(colorSpan, 0, currentDateReformat.length, 0)

            headingText = SpannableString.valueOf(TextUtils.concat(headingText, " ", userName))
            dateText = SpannableString.valueOf(TextUtils.concat(dateText, " ", currentDateReformat))

            headingTodo.text = headingText
            subheadingTodo.text = dateText
        }
    }
}