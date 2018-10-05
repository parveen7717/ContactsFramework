package com.example.contactsframework.model;

import android.graphics.Bitmap;
import android.net.Uri;

public class ContactModel {
    public String id;
    public String name;
    public String mobileNumber;
    public Bitmap photo;
    public Uri photoURI;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public Uri getPhotoURI() {
        return photoURI;
    }
}
