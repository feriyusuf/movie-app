package id.kotlin.mvvm.domain

/**
 * Digunakan untuk normalisasi dari object response
 * pada layer data
 */
data class HomeEntity(
    val page: Long,
    val totalPages: Long,
    val results: MutableList<Result>
) {
    /**
     * Beda dengan response, bertujuan untuk membersihkan
     * nullable yang sudah diproses pada data layer
     */
    data class Result(
        val title: String,
        val overview: String
    )
}
