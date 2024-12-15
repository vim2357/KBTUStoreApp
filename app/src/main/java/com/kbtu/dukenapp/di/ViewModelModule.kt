package com.kbtu.dukenapp.di

import com.kbtu.dukenapp.presentation.features.home.HomeViewModel
import com.kbtu.dukenapp.presentation.features.sign_in.SigInViewModel
import com.kbtu.dukenapp.presentation.features.sign_up.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::SigInViewModel)
    viewModelOf(::SignUpViewModel)
    viewModelOf(::HomeViewModel)
}

