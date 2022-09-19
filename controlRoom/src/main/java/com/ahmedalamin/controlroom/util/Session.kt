package com.ahmedalamin.controlroom.util

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Akshay Raj on 7/28/2016.
 * Snow Corporation Inc.
 * www.snowcorp.org
 */
class Session(var _context: Context) {
    var pref: SharedPreferences
    var editor: SharedPreferences.Editor

    // shared pref mode
    var PRIVATE_MODE = 0
    var isFirstTimeLaunch: Boolean
        get() = pref.getBoolean(IS_FIRST_TIME_LAUNCH, true)
        set(isFirstTime) {
            editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime)
            editor.commit()
        }

    companion object {
        // Shared preferences file name
        private const val PREF_NAME = "snow-intro-slider"
        private const val IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch"
    }

    init {
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }
}