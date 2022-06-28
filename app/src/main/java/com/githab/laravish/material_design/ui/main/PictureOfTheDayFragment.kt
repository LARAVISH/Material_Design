package com.githab.laravish.material_design.ui.main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import coil.transform.RoundedCornersTransformation
import com.githab.laravish.material_design.R
import com.githab.laravish.material_design.databinding.FragmentPictureBinding


class PictureOfTheDayFragment : Fragment() {

    private var _binding: FragmentPictureBinding? = null
    private val binding: FragmentPictureBinding
        get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider(this)[PictureOfTheDayViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentPictureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveData().observe(viewLifecycleOwner) { appState ->
            renderData(appState)
        }
        viewModel.sentRequest()
    }

    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Error -> {
                Toast.makeText(requireContext(), getString(R.string.error_loading), Toast.LENGTH_LONG).show()
            }
            AppState.Loading -> {
                Toast.makeText(requireContext(), getString(R.string.loading), Toast.LENGTH_LONG).show()
            }
            is AppState.Success -> {
                imageView.load(appState.pictureOfTheDayResponseData.url) {
                    crossfade(true)
                    placeholder(R.drawable.ic_launcher_background)
                    transformations(RoundedCornersTransformation(35f))
                    error(R.drawable.ic_launcher_background)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newInstance() = PictureOfTheDayFragment()
    }
}

