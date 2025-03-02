package features.ui.screens.authmenu

import androidx.lifecycle.ViewModel
import features.domain.api.auth.repository.AuthRepository
import foundation.statemanager.StateManager
import foundation.statemanager.StateOwner
import kotlinx.coroutines.CoroutineDispatcher

internal class AuthMenuViewModel(
    private val dispatcher: CoroutineDispatcher,
    private val authRepository: AuthRepository
) : ViewModel(), StateOwner<AuthMenuState> by StateManager(AuthMenuState()) {

    fun updateEmail(value: String) {
        updateStateSync {
            update {
                it.copy(email = value.trim())
            }
        }
    }

    fun updatePassword(value: String) {
        updateStateSync {
            update {
                it.copy(password = value.trim())
            }
        }
    }

    fun togglePasswordVisibility() {
        updateStateSync {
            update {
                it.copy(passwordVisibility = !it.passwordVisibility)
            }
        }
    }
}