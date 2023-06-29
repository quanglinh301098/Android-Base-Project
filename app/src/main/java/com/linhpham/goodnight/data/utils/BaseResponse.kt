package com.linhpham.goodnight.data.utils


class BaseResponse<T>(val data:T)

data class Pagination(
    var total: Int,
    var pages: Int,
    var page: Int,
    var limit: Int,
    var links: PageLinks = PageLinks()
)

data class PageLinks(
    val previous: String? = null,
    val current: String? = null,
    var next: String? = null
)
