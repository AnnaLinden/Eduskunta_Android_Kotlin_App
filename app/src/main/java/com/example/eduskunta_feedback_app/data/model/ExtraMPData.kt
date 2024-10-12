package com.example.eduskunta_feedback_app.data.model

// Date: 12.10.2024
// Name: Anna Lindén 2217933
// Description: Data class representing additional information for an MP,
// including Twitter, birth year, and constituency.
data class ExtraMPData(
    val hetekaId: Int,
    val twitter: String?,
    val bornYear: Int?,
    val constituency: String?
)
