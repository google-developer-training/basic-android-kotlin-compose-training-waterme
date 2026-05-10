/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.waterme.data

import android.content.Context
import androidx.work.Data
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.waterme.model.Plant
import com.example.waterme.worker.WaterReminderWorker
import java.util.concurrent.TimeUnit

class WorkManagerWaterRepository(context: Context) : WaterRepository {
    private val workManager = WorkManager.getInstance(context)

    override val plants: List<Plant>
        get() = DataSource.plants

    override fun scheduleReminder(duration: Long, unit: TimeUnit, plantName: String) {
        val data = Data.Builder() // establish data variable using Builder()
        // populate data using putString with nameKey and plantName from WaterReminderWorker
        data.putString(WaterReminderWorker.nameKey, plantName)

        // setup one-time work request with WaterReminderWorker
        val workRequestBuilder = OneTimeWorkRequestBuilder<WaterReminderWorker>()
            .setInitialDelay(duration, unit) // duration and unit part of Reminder class
            // that was passed into this scheduleReminder function
            .setInputData(data.build()) // set input data and build the Builder
            .build()

        // call enqueueUniqueWork using workManager and pass plant name concatenated (+) with duration
        // similar to WorkManagerBluromaticRepository 'applyBlur' function and using its workManager
        workManager.enqueueUniqueWork(
            plantName + duration, // allows multiple reminders per plant
            ExistingWorkPolicy.REPLACE, // use REPLACE
            workRequestBuilder // add work request object in parameter
        )
    }
}
