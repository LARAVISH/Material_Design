package com.githab.laravish.material_design.ui.main.pictures


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import coil.transform.RoundedCornersTransformation
import com.githab.laravish.material_design.*
import com.githab.laravish.material_design.databinding.FragmentPictureBinding
import com.githab.laravish.material_design.ui.main.AppState
import com.githab.laravish.material_design.ui.main.PictureOfTheDayViewModel
import com.githab.laravish.material_design.ui.main.drawer.BottomNavigationDrawerFragment
import com.githab.laravish.material_design.ui.main.setting.SettingFragment


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
        viewModel.sentRequest(TODAY)
        searchWiki()
        chipGroupOnClick()
        setHasOptionsMenu(true)
        (requireActivity() as MainActivity).setSupportActionBar(binding.bottomNavigation)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.bottom_app_bar_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_favorite ->{
                Toast.makeText(requireContext(),"favorite",Toast.LENGTH_LONG).show()
            }
            R.id.action_setting ->{
                requireActivity().supportFragmentManager.beginTransaction().hide(this)
                    .add(R.id.container, SettingFragment.newInstance())
                    .addToBackStack("").commit()
            }
            android.R.id.home -> activity?.let { BottomNavigationDrawerFragment()
                .show(it.supportFragmentManager,"BNDF") }
        }
       return super.onOptionsItemSelected(item)
    }

    private fun chipGroupOnClick() = with(binding) {

        chipToday.setOnClickListener {
            viewModel.sentRequest(TODAY)
        }
        chipYesterday.setOnClickListener {
            viewModel.sentRequest(YESTERDAY)
        }
        chipToDaysAgo.setOnClickListener {
            viewModel.sentRequest(TO_DAYS_AGO)
        }
    }

    private fun searchWiki() {
        binding.inputLayout.setEndIconOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data =
                    Uri.parse("$URL_WIKI${binding.editText.text.toString()}")
            })
        }
    }

    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Error -> {
                Toast.makeText(requireContext(),
                    getString(R.string.error_loading),
                    Toast.LENGTH_LONG).show()
            }
            AppState.Loading -> {
                Toast.makeText(requireContext(), getString(R.string.loading), Toast.LENGTH_LONG)
                    .show()
            }
            is AppState.Success -> {
                imageView.load(appState.pictureOfTheDayResponseData.url) {
                    crossfade(true)
                    placeholder(R.drawable.ic_launcher_background)
                    transformations(RoundedCornersTransformation(50f))
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

