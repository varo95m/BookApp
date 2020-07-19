package com.bookapp.model

import com.domain.FLOAT_ZERO
import com.domain.STRING_EMPTY

data class ToolbarModel(
        val backClickListener: (() -> Unit)? = null,
        val backVisibility: Boolean = false,
        val backDrawableCross: Boolean = false,
        val closeSessionVisibility: Boolean = true,
        val title: String = STRING_EMPTY,
        val visibility: Boolean = true,
        val elevation: Boolean = true,
        val gone: Boolean = true,
        val exitButton: ExitButton? = null
) {
    data class ExitButton(
            val text: String = STRING_EMPTY,
            val onClickListener: (() -> Unit),
            val textSize: Float = FLOAT_ZERO,
            val enabled: Boolean = true
    )
}