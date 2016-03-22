package com.foodenak.android.permissiondelegate

/**
 * Created by kukuh on 11/2/15.
 */
interface PermissionCallback {

    fun onPermissionGranted();

    fun onShowRationale();

    fun onPermissionDenied();
}