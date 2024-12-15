package com.kbtu.dukenapp.presentation.features.sign_up

import com.kbtu.dukenapp.presentation.features.sign_in.SigInContract.Effect
import com.kbtu.dukenapp.presentation.model.ResourceUiState
import com.kbtu.dukenapp.presentation.model.TextFieldUiState
import com.kbtu.dukenapp.presentation.mvi.UiEffect
import com.kbtu.dukenapp.presentation.mvi.UiEvent
import com.kbtu.dukenapp.presentation.mvi.UiState

interface SignUpContract {
    sealed interface Event : UiEvent {
        data object OnSignUpClicked : Event
    }

    data class State(
        val state: ResourceUiState<Unit>,
        val name: TextFieldUiState,
        val email: TextFieldUiState,
        val password: TextFieldUiState,
        val isButtonAvailable: Boolean = false,
    ) : UiState

    sealed interface Effect : UiEffect {
        data object OnLoading : Effect
        data object OnUserExist : Effect
        data object OnUserCreated : Effect
    }
}


