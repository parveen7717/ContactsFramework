package com.example.contactsframework.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

public class Permission {
    private Activity activity;
    public static final int REQUEST_READ_CONTACTS = 79;

    public Permission(Activity activity) {
        this.activity = activity;
    }
    public boolean checkContactPermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(activity.checkSelfPermission(Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED
                    || activity.checkSelfPermission(Manifest.permission.WRITE_CONTACTS)!=PackageManager.PERMISSION_GRANTED)
            {
                activity.requestPermissions(new String[]{
                        Manifest.permission.READ_CONTACTS
                        ,Manifest.permission.WRITE_CONTACTS},REQUEST_READ_CONTACTS);
                return false;
            }
            else {
                return true;
            }
        }else {
            return true;
        }
    }

}
