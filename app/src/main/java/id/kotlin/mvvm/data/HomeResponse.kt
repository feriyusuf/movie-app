package id.kotlin.mvvm.data

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName(value = "page")
    val page: Long? = -1L,

    @SerializedName(value = "total_pages")
    val totalPages: Long? = -1L,

    @SerializedName("results")
    val results: List<Result>? = emptyList()
)

data class Result(
    @SerializedName("title")
    val title: String? = null,

    @SerializedName("overview")
    val overview: String? = null
)
