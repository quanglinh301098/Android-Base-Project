package com.linhpham.baseproject.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.linhpham.baseproject.utils.SafetyClickListener

abstract class BaseFragment<T : ViewBinding> : Fragment(), IBaseFragment {
    private var _binding: T? = null
    protected val binding  get() =  _binding!!

    open val handleBackPress = true

    override val baseActivity: BaseActivity?
        get() = activity as? BaseActivity

    override val safetyClick: SafetyClickListener by lazy {
        SafetyClickListener()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startObservingValuesOnce()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding(inflater, container)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initActions()
        startObservingValues()
        if (handleBackPress) {
            (requireActivity() as OnBackPressedDispatcherOwner).onBackPressedDispatcher.addCallback(
                viewLifecycleOwner
            ) {
                onBackPressed()
            }
        }
    }

    override fun onBackPressed() {
        if (!findNavController().popBackStack()) {
            requireActivity().finish()
        }
    }

    abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): T

    open fun startObservingValuesOnce() {}
}
