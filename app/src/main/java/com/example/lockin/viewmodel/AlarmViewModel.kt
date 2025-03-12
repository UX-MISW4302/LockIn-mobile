package com.example.yourapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.lockin.model.Alarm
import java.util.Date

class AlarmViewModel : ViewModel() {
    private val _alarms = mutableStateListOf<Alarm>()
    val alarms: List<Alarm> get() = _alarms

    fun addAlarm(alarm: Alarm) {
        _alarms.add(alarm)
    }
}



// Mock data for testing
val mockAlarms = listOf(
    Alarm(id = 1, name = "Morning Reminder",
        duration = 3600000, beginningDateTime = Date(1733070000000), endingDateTime = Date(1733073600000)
    ),
    Alarm(id = 2, name = "Meeting Alert",
        duration = 5400000, beginningDateTime = Date(1733156400000), endingDateTime = Date(1733161800000)
    ),
    Alarm(id = 3, name = "Deadline Reminder",
        duration = 7200000, beginningDateTime = Date(1733242800000), endingDateTime = Date(1733250000000)
    ),
    Alarm(id = 4, name = "Workout Notification",
        duration = 4500000, beginningDateTime = Date(1733329200000), endingDateTime = Date(1733333700000)
    ),
    Alarm(id = 5, name = "Study Session Timer",
        duration = 3600000, beginningDateTime = Date(1733415600000), endingDateTime = Date(1733419200000)
    )
)