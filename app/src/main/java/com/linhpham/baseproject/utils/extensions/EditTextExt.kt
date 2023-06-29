package com.linhpham.baseproject.utils.extensions

import android.widget.EditText

internal fun EditText.hideSoftInputOnFocus(){
    this.showSoftInputOnFocus = false
}

internal fun EditText.setTextAndMoveCursorToEnd(textToSet: String){
    setText(textToSet)
    setSelection(text.toString().length)
}
