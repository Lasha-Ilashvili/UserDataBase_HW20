package com.example.userdatabase_hw20.presentation.screen

import android.util.Log.d
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.userdatabase_hw20.data.common.Resource
import com.example.userdatabase_hw20.databinding.FragmentMainBinding
import com.example.userdatabase_hw20.domain.model.User
import com.example.userdatabase_hw20.presentation.base.BaseFragment
import com.example.userdatabase_hw20.presentation.event.UserEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val viewModel: MainViewModel by viewModels()

    override fun setListeners() {
        with(binding) {
            btnAddUser.setOnClickListener {
                viewModel.onEvent(UserEvent.AddUser(user = getUser()))
            }

            btnRemoveUser.setOnClickListener {
                viewModel.onEvent(UserEvent.RemoveUser(user = getUser()))
            }

            btnUpdateUser.setOnClickListener {
                viewModel.onEvent(UserEvent.UpdateUser(user = getUser()))
            }
        }
    }

    private fun getUser(): User {
        return User(
            firstName = binding.etFirstName.text.toString().takeIf { it.isNotBlank() },
            lastName = binding.etLastName.text.toString().takeIf { it.isNotBlank() },
            age = binding.etAge.text.toString().toIntOrNull(),
            email = binding.etEmail.text.toString().takeIf { it.isNotBlank() }
        )
    }

    override fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.users.collect {
                    when (it) {
                        is Resource.Error -> {
                            d("CheckFlow", it.toString())
                        }

                        is Resource.Success -> {
                            d("CheckFlow", it.toString())
                        }
                    }
                }
            }
        }
    }
}