package com.w4eret1ckrtb1tch.moviereviews.data.dto

import com.google.gson.annotations.SerializedName

data class LinkDto(
    @field:SerializedName("type") val type: String?,
    @field:SerializedName("url") val urlPage: String?,
    @field:SerializedName("suggested_link_text") val suggestedLinkText: String?
)