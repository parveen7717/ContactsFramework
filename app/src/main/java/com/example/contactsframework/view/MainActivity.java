package com.example.contactsframework.view;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.contactsframework.R;
import com.example.contactsframework.adapter.ContactsAdapter;
import com.example.contactsframework.controller.ContactsController;
import com.example.contactsframework.utils.Permission;

import static com.example.contactsframework.utils.Permission.REQUEST_READ_CONTACTS;


public class MainActivity extends AppCompatActivity{
    private ContactsAdapter contactsAdapter;
    private RecyclerView contactsRecycler;
    private Permission permission;
    public ContactsController contactsController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactsController = new ContactsController(this);
        contactsRecycler = findViewById(R.id.contactsRecycler);
        permission = new Permission(this);
        if (!permission.checkContactPermission()) {
            permission.checkContactPermission();
        } else {
            contactsAdapter = new ContactsAdapter(this, contactsController.getContacts(this));
            contactsRecycler.setLayoutManager(new LinearLayoutManager(this));
            contactsRecycler.setAdapter(contactsAdapter);
            contactsAdapter.notifyDataSetChanged();
        }
        contactsRecycler.smoothScrollBy(0,0);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        // Make sure it's our original READ_CONTACTS request
        if (requestCode == REQUEST_READ_CONTACTS) {
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                contactsAdapter = new ContactsAdapter(this, contactsController.getContacts(this));
                contactsRecycler.setLayoutManager(new LinearLayoutManager(this));
                contactsRecycler.setAdapter(contactsAdapter);
                contactsAdapter.notifyDataSetChanged();
                Toast.makeText(this, "Read Contacts permission granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Read Contacts permission denied", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


}


