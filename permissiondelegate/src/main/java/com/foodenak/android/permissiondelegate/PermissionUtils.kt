package com.foodenak.android.permissiondelegate

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.support.v4.app.ActivityCompat

/**
 * Created by kukuh on 11/2/15.
 */
fun hasSelfPermissionsAnyOf(context: Context, permissions: Array<String>): Boolean {
    if (!isM()) {
        return true
    }
    permissions.forEach { permission ->
        if (ActivityCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED) return@hasSelfPermissionsAnyOf true
    }
    return false
}

fun hasSelfPermissions(context: Context, permissions: Array<String>): Boolean {
    if (!isM()) {
        return true
    }
    permissions.forEach { permission ->
        if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) return@hasSelfPermissions false
    }
    return true
}

fun verifyPermissions(grandResults: IntArray): Boolean {
    grandResults.forEach { result ->
        if (result != PackageManager.PERMISSION_GRANTED) {
            return@verifyPermissions false
        }
    }
    return true
}

fun shouldShowRationale(activity: Activity, permissions: Array<String>): Boolean {
    if (!isM()) {
        return false
    }
    permissions.forEach { permission ->
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
            return@shouldShowRationale true
        }
    }
    return false
}

private fun isM(): Boolean {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
}