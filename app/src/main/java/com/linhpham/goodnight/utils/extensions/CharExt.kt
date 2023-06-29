package com.linhpham.goodnight.utils.extensions


fun Char.isArithmeticOperator(): Boolean {
    return when (this) {
        '+', '-', 'x', '÷', '=' -> true
        else -> false
    }
}
