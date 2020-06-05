package org.sopt.cldi.data

data class GomshinTalkData(
    val num: Int,
    val title: String,
    val level: String,
    val nick: String,
    val like: Int,
    val comment: Int,
    val rank: String,
    val time: String,
    val image: String?,
    val category: String
)