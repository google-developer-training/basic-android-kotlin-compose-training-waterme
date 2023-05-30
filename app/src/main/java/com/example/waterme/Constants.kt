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

package com.example.waterme

// Notification Channel constants

// Name of Notification Channel for verbose notifications of background work
val VERBOSE_NOTIFICATION_CHANNEL_NAME: CharSequence = "Verbose WorkManager Notifications"

// Description of Notification Channel for verbose notifications of background work
const val VERBOSE_NOTIFICATION_CHANNEL_DESCRIPTION = "Shows notifications whenever work starts"

// Title of Notification for verbose notifications of background work
val NOTIFICATION_TITLE: CharSequence = "Water me!"

// ID of Notification Channel for verbose notifications of background work
const val CHANNEL_ID = "VERBOSE_NOTIFICATION"

// ID of Notification for verbose notifications of background work
const val NOTIFICATION_ID = 1

// Request code for pending intent
const val REQUEST_CODE = 0

// Reminder schedule
const val FIVE_SECONDS: Long = 5
const val ONE_DAY: Long = 1
const val SEVEN_DAYS: Long = 7
const val THIRTY_DAYS: Long = 30
