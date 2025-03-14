package features.ui.di

import features.ui.screens.authmenu.AuthMenuViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.datetime.Clock
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val uiDiModule = module {
    viewModel {
        AuthMenuViewModel(
            dispatcher = Dispatchers.Default,
            loginService = get(),
            authRepository = get(),
            clock = Clock.System
        )
    }
}