package com.linhpham.baseproject.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.linhpham.baseproject.R
import com.linhpham.baseproject.base.BaseFragment
import com.linhpham.baseproject.databinding.FragmentDashboardBinding
import com.linhpham.baseproject.ui.home.NavHomeFragment
import com.linhpham.baseproject.ui.settings.NavSettingsFragment
import com.linhpham.baseproject.utils.eventbus.OpenLogin
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe


class DashBoardFragment : BaseFragment<FragmentDashboardBinding>() {
    private val viewModel: DashboardViewModel by viewModels()

    private val fragments by lazy {
        listOf(
            (childFragmentManager.findFragmentByTag("dashboard-0") as? NavHomeFragment)
                ?: NavHomeFragment(),
            (childFragmentManager.findFragmentByTag("dashboard-1") as? NavSettingsFragment)
                ?: NavSettingsFragment()
        )
    }

    override val handleBackPress: Boolean
        get() = false

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding = FragmentDashboardBinding.inflate(inflater, container, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Add fragments
        childFragmentManager.beginTransaction().apply {
            fragments.forEachIndexed { index, item ->
                if (!childFragmentManager.fragments.contains(item)) {
                    add(R.id.fragmentContainer, item, "dashboard-$index")
                    if (index > 0){
                        hide(item)
                    }else{
                        show(item)
                    }
                }
            }
        }.commit()

    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    override fun initViews() {

    }

    override fun initActions() {
        with(binding) {
            menuHome.setOnClickListener {
                viewModel.setSelectedTab(it.id)
            }

            menuSettings.setOnClickListener {
                viewModel.setSelectedTab(it.id)
//                findNavController().navigate(DashBoardFragmentDirections.fragmentDashBoardToFragmentDetail())
            }
        }
    }

    override fun startObservingValues() {
        viewModel.selectedTab.observe(viewLifecycleOwner) {
            updateSelectedTab(it)
        }
    }

    private fun updateSelectedTab(selectedTab: Int) {
        binding.menuHome.isSelected = false
        binding.menuSettings.isSelected = false
        when (selectedTab) {
            R.id.menuSettings -> {
                binding.menuSettings.isSelected = true
                setSelectedTabIndex(1)
            }
            else -> {
                binding.menuHome.isSelected = true
                setSelectedTabIndex(0)
            }
        }
    }

    private fun setSelectedTabIndex(index: Int) {
        childFragmentManager.beginTransaction()
            .selectFragment(index)
            .commit()
    }

    @Subscribe
    fun openLogin(eventBus: OpenLogin) {
        findNavController().navigate(DashBoardFragmentDirections.fragmentDashBoardToFragmentLogin())
    }

    private fun FragmentTransaction.selectFragment(selectedIndex: Int): FragmentTransaction {
        fragments.forEachIndexed { index, fragment ->
            if (index == selectedIndex) {
                show(fragment)
            } else {
                hide(fragment)
            }
        }
        return this
    }

}



