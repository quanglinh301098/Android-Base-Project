package com.linhpham.baseproject.base

import com.linhpham.baseproject.utils.SafetyClickListener

interface IBaseFragment {
  /**
   * Base activity @see [BaseActivity] which this fragment are standing on.
   */
  val baseActivity: BaseActivity?

  /**
   * Handle click event for views. It's prevent the click event is delivered to fast (may cause app error) when
   * user click on elements two fast.
   */
  val safetyClick: SafetyClickListener

  /**
   * Init views in screen (e.g., a adapter, layout manager for RecycleView).
   */
  fun initViews()

  /**
   * Declare listener on views (e.g., listen click on button, view)
   */
  fun initActions()

  /**
   * Observe states from ViewModel to update views.
   * Make sure that this method is called after [initViews] because the views are need to ready to
   * display data.
   */
  fun startObservingValues()

  /**
   * Called when user click system back button
   */
  fun onBackPressed()

}
