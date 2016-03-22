package com.foodenak.android.permissiondelegate

/**
 * Created by kukuh on 15/11/27.
 */
interface PermissionRequestHandler {
    fun requestPermissions(permissions: Array<String>, requestCode: Int);
}
