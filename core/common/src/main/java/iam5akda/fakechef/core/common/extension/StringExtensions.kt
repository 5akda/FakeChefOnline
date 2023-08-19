package iam5akda.fakechef.core.common.extension

import android.net.Uri

fun String?.uriEncode(): String {
    return this?.let {
        Uri.encode(this)
    } ?: ""
}

fun String?.uriDecode(): String {
    return this?.let {
        Uri.decode(this)
    } ?: ""
}

fun String.limitLength(length: Int = 15): String {
    val limitedString = this.take(length)
    return "$limitedString\u200b"
}

fun String.onlyDigits(): String {
    return this.filter { it.isDigit() }
}