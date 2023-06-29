package com.linhpham.goodnight.utils.extensions

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.linhpham.goodnight.R

/**
 * Created by Linh on 8/17/2022.
 */
@Suppress("unused")
fun Fragment.showToast(any: Any?, time: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(requireContext().applicationContext, any.toString(), time).show()
}
@Suppress("unused")
fun Activity.showToast(any: Any?, time: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this.applicationContext, any.toString(), time).show()
}


@Suppress("unused")
fun Fragment.delay(delayMillis: Long, action: () -> Unit) {
    Handler(Looper.getMainLooper()).postDelayed({
        action.invoke()
    }, delayMillis)
}

@Suppress("unused")
fun Fragment.showAlertDialog(
    context: Context, title: Int, message: String,
    action: () -> Unit
) {
    AlertDialog.Builder(context)
        .setMessage(message)
        .setTitle(title)
        .setPositiveButton(R.string.ok) { _, _ -> action() }
        .setNegativeButton(R.string.msg_cancel, null)
        .create()
        .show()
}


