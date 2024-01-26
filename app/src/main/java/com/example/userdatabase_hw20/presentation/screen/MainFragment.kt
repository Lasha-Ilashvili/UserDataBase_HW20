package com.example.userdatabase_hw20.presentation.screen

import android.util.Log.d
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.userdatabase_hw20.databinding.FragmentMainBinding
import com.example.userdatabase_hw20.domain.model.User
import com.example.userdatabase_hw20.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val viewModel: MainViewModel by viewModels()

    override fun setUp() {
        viewModel.onEvent(
            User(
                firstName = "Charlie Downs",
                lastName = "Lena Barber",
                age = 1285,
                email = "gene.sctt@example.com"
            )
        )
    }

    override fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.testFlow.collect {
                    d("TestList", it.toString())
                }
            }
        }
    }
}