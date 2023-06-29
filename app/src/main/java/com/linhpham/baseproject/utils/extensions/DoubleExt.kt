package com.linhpham.baseproject.utils.extensions

import java.text.DecimalFormat

fun Double.currencyFormat(): String =
    DecimalFormat("#.##").format(this)
