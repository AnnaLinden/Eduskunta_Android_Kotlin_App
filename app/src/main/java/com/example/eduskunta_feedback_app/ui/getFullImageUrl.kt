package com.example.eduskunta_feedback_app.ui

fun getFullImageUrl(relativeUrl: String?): String {
    return if (!relativeUrl.isNullOrEmpty()) {
        "https://avoindata.eduskunta.fi/$relativeUrl"
    } else {
        ""
    }
}