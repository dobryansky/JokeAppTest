package com.artem.jokeapptest.resource_manager

import androidx.annotation.StringRes

interface ResourceManager {
    fun getString(@StringRes stringResId: Int):String
}
