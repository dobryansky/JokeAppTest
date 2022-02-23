package com.artem.jokeapptest.resource_manager

import android.content.Context

class BaseResourceManager(private val context: Context) : ResourceManager {
    override fun getString(stringResId: Int): String {
        return context.getString(stringResId)
    }
}