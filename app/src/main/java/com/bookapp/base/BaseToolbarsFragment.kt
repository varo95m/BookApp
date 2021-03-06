package com.bookapp.base

import com.bookapp.ui.MainToolbarsViewModel
import es.babel.easymvvm.core.navigator.EmaNavigationState
import es.babel.easymvvm.core.state.EmaBaseState
import org.kodein.di.generic.instance

/**
 * Base fragment for LDA application with toolbars management
 *
 * <p>
 * Copyright (c) 2018, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */

abstract class BaseToolbarsFragment<S : EmaBaseState, VM : BaseToolbarsViewModel<S, NS>, NS : EmaNavigationState> : BaseFragment<S, VM, NS>() {

    lateinit var mainToolbarsVm: MainToolbarsViewModel

    private val mainToolbarsViewModelSeed: MainToolbarsViewModel by instance()

    override fun onInitialized(viewModel: VM) {

        (viewModel as? BaseToolbarsViewModel<*, *>)?.also {
            mainToolbarsVm = addExtraViewModel(mainToolbarsViewModelSeed,this,requireActivity())
            it.mainToolbarsVm = mainToolbarsVm
            onInitializedWithToolbarsManagement(viewModel, mainToolbarsVm)
        } ?: throw RuntimeException("The view model must be inherited from BaseToolbarsViewModel")
    }

    abstract fun onInitializedWithToolbarsManagement(viewModel: VM, mainToolbarViewModel: MainToolbarsViewModel)
}