package com.githab.laravish.material_design.ui.main.navigation

import android.graphics.BlurMaskFilter
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.SpannedString
import android.text.style.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.githab.laravish.material_design.R
import com.githab.laravish.material_design.databinding.FragmentSecondPictureBinding


class SecondPictureFragment : Fragment() {

    private var _binding: FragmentSecondPictureBinding? = null
    private val binding: FragmentSecondPictureBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSecondPictureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hw7()
        hw7Rainbow()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SecondPictureFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun hw7Rainbow() {
        val arrColor =
            arrayOf(R.color.r, R.color.o, R.color.y, R.color.g, R.color.b, R.color.db, R.color.p)
        val myText = getText(R.string.cicero)
        val spannableString = SpannableString(myText)
        spannableString.setSpan(
            UnderlineSpan(),
            0,
            spannableString.length,
            SpannedString.SPAN_INCLUSIVE_INCLUSIVE
        )
        spannableString.setSpan(
            ScaleXSpan(2f),
            0,
            myText.length,
            SpannedString.SPAN_INCLUSIVE_INCLUSIVE
        )

        var currentColor = 0
        for ((ind, _) in myText.withIndex()) {
            val color = ContextCompat.getColor(requireContext(), arrColor[currentColor])
            spannableString.setSpan(ForegroundColorSpan(color), ind, ind+1, SpannedString.SPAN_INCLUSIVE_INCLUSIVE)
            if (currentColor == arrColor.size-1) currentColor = 0 else currentColor++
        }
        binding. text.text = spannableString

    } private fun hw7() = with(binding){
        val findWord = "MATERIAL"
        val c = "MY DESIGN $findWord"
        val arr = c.split(" ")
        var newStr = ""
        var position = 0
        for (item in arr) {
            newStr += "$item "
            if (item == findWord) position = newStr.length
        }
        val spannableStringBuilder = SpannableStringBuilder(newStr)

        val color = ContextCompat.getColor(requireContext(), android.R.color.holo_blue_dark)
        spannableStringBuilder.setSpan(
            BackgroundColorSpan(color),
            position - 1 - findWord.length,
            position,
            SpannedString.SPAN_EXCLUSIVE_INCLUSIVE
        )
        spannableStringBuilder.setSpan(
            UnderlineSpan(),
            0,
            spannableStringBuilder.length,
            SpannedString.SPAN_INCLUSIVE_INCLUSIVE
        )
        spannableStringBuilder.setSpan(
            ScaleXSpan(6f),
            0,
            arr[0].length,
            SpannedString.SPAN_INCLUSIVE_INCLUSIVE
        )
        val blurMaskFilter = BlurMaskFilter(1f, BlurMaskFilter.Blur.SOLID)
        spannableStringBuilder.setSpan(
            MaskFilterSpan(blurMaskFilter),
            arr[0].length + 1,
            arr[0].length + 1 + arr[1].length,
            SpannedString.SPAN_INCLUSIVE_INCLUSIVE
        )
        text.text = spannableStringBuilder.trim()
    }
}

