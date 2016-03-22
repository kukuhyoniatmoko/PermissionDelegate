package com.foodenak.android.permissiondelegate

/**
 * Created by kukuh on 11/3/15.
 */
abstract class AbstractPermissionDelegate(private val requestCode: Int, private val callback: PermissionCallback) : PermissionDelegate {

    override fun onPermissionResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (this.requestCode == requestCode) {
            if (verifyPermissions(grantResults)) {
                callback.onPermissionGranted()
            } else {
                callback.onPermissionDenied()
            }
        }
    }
}