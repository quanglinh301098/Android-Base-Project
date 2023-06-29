package com.linhpham.goodnight.ui

import android.graphics.Color
import android.graphics.SurfaceTexture
import android.media.MediaPlayer
import android.os.Bundle
import android.view.Surface
import android.view.TextureView
import android.view.View
import android.view.WindowManager
import android.window.OnBackInvokedDispatcher
import androidx.core.view.WindowCompat
import androidx.health.connect.client.HealthConnectClient
import androidx.health.connect.client.PermissionController
import androidx.health.connect.client.permission.HealthPermission
import androidx.health.connect.client.records.HeartRateRecord
import androidx.health.connect.client.records.SleepSessionRecord
import androidx.health.connect.client.records.SleepStageRecord
import androidx.health.connect.client.records.StepsRecord
import androidx.navigation.fragment.NavHostFragment
import com.linhpham.goodnight.R
import com.linhpham.goodnight.base.BaseActivity
import com.linhpham.goodnight.databinding.ActivityMainBinding
import com.linhpham.goodnight.utils.extensions.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity(), TextureView.SurfaceTextureListener,
    MediaPlayer.OnVideoSizeChangedListener {
    private lateinit var binding: ActivityMainBinding

    private var _surface: Surface? = null
    private val healthConnectClient by lazy { HealthConnectClient.getOrCreate(this) }
    private val player: MediaPlayer by lazy {
        MediaPlayer.create(this@MainActivity, R.raw.video).apply {
            isLooping = true
            setVolume(0f, 0f)
            setVideoScalingMode(MediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        navigateToHome()

        if (HealthConnectClient.isAvailable(this)) {
            // Health Connect is available and installed.
            CoroutineScope(Dispatchers.IO).launch {
                checkPermissionsAndRun(healthConnectClient)
            }
        } else {
            // ...
            showToast(getString(R.string.pls_instal_health_connect))
        }
    }

    private fun initViews() {
        binding.textureView.surfaceTextureListener = this
    }

    private fun navigateToHome() {
        viewModelStore.clear()
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_main)
        graph.setStartDestination(R.id.fragmentDashBoard)
        navHostFragment.navController.setGraph(graph, null)
    }

    // build a set of permissions for required data types
    private val permissionsList =
        setOf(
            HealthPermission.createReadPermission(HeartRateRecord::class),
            HealthPermission.createWritePermission(HeartRateRecord::class),
            HealthPermission.createReadPermission(StepsRecord::class),
            HealthPermission.createWritePermission(StepsRecord::class),
            HealthPermission.createWritePermission(SleepSessionRecord::class),
            HealthPermission.createWritePermission(SleepStageRecord::class)
        )

    // Create the permissions launcher.
    private val requestPermissionActivityContract =
        PermissionController.createRequestPermissionResultContract()

    private val requestPermissions =
        registerForActivityResult(requestPermissionActivityContract) { granted ->
            if (granted.containsAll(permissionsList)) {
                // Permissions successfully granted
                showToast(getString(R.string.permistion_succesful))
            } else {
                // Lack of required permissions
            }
        }

    private suspend fun checkPermissionsAndRun(healthConnectClient: HealthConnectClient) {
        val granted =
            healthConnectClient.permissionController.getGrantedPermissions(permissionsList)
        if (granted.containsAll(permissionsList)) {
            // Permissions already granted, proceed with inserting or reading data.
            showToast(getString(R.string.permistion_aded))
        } else {
            requestPermissions.launch(permissionsList)
        }
    }

    override fun onResume() {
        super.onResume()
        player.start()
    }

    override fun onPause() {
        player.pause()
        super.onPause()
    }

    override fun onDestroy() {
        player.release()
        super.onDestroy()
    }

    override fun onSurfaceTextureAvailable(surface: SurfaceTexture, width: Int, height: Int) {
        _surface = Surface(surface)
        player.setSurface(_surface)
        player.start()
    }

    override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture, width: Int, height: Int) {

    }

    override fun onSurfaceTextureDestroyed(surface: SurfaceTexture): Boolean {
        return true
    }

    override fun onSurfaceTextureUpdated(surface: SurfaceTexture) {
    }

    override fun getOnBackInvokedDispatcher(): OnBackInvokedDispatcher {
        return super.getOnBackInvokedDispatcher()
    }

    override fun onVideoSizeChanged(mp: MediaPlayer?, width: Int, height: Int) {

    }
}
