package com.linhpham.goodnight.ui.dashboard.home

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.window.OnBackInvokedCallback
import android.window.OnBackInvokedDispatcher
import androidx.annotation.RequiresApi
import androidx.health.connect.client.HealthConnectClient
import androidx.health.connect.client.records.SleepSessionRecord
import androidx.health.connect.client.records.SleepStageRecord
import androidx.health.connect.client.request.ReadRecordsRequest
import androidx.health.connect.client.time.TimeRangeFilter
import com.linhpham.goodnight.base.BaseFragment
import com.linhpham.goodnight.databinding.FragmentHomeBinding
import com.linhpham.goodnight.utils.eventbus.OpenLogin
import com.linhpham.goodnight.utils.extensions.showToast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus
import java.time.Instant
import java.util.*

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val healthConnectClient by lazy { HealthConnectClient.getOrCreate(requireContext()) }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

    override fun initViews() {

    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun initActions() {
//        binding.btnOK.setOnClickListener {
//            CoroutineScope(Dispatchers.IO).launch {
//                readSleepSessions(healthConnectClient, Date().toInstant(),Date(Date().time + (1000 * 60 * 60 * 24)).toInstant()
//                )
//            }
//            EventBus.getDefault().post(OpenLogin())
//        }
    }

    override fun startObservingValues() {

    }

    private suspend fun readSleepSessions(
        healthConnectClient: HealthConnectClient,
        startTime: Instant,
        endTime: Instant
    ) {
        val response = healthConnectClient.readRecords(ReadRecordsRequest(SleepSessionRecord::class, timeRangeFilter = TimeRangeFilter.between(startTime, endTime)))
        for (sleepRecord in response.records) {
            // Process each exercise record
            // Optionally pull in sleep stages of the same time range
            val sleepStageRecords = healthConnectClient.readRecords(
                ReadRecordsRequest(
                            SleepStageRecord::class,
                            timeRangeFilter =
                            TimeRangeFilter.between(sleepRecord.startTime, sleepRecord.endTime)
                        )
                    )
                .records
        }
    }

    suspend fun deleteSleepSession(
        healthConnectClient: HealthConnectClient,
        sleepRecord: SleepSessionRecord,
    ) {
        val timeRangeFilter = TimeRangeFilter.between(sleepRecord.startTime, sleepRecord.endTime)
        healthConnectClient.deleteRecords(SleepSessionRecord::class, timeRangeFilter)
        healthConnectClient.deleteRecords(SleepStageRecord::class, timeRangeFilter)
    }

}