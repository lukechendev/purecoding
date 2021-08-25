package com.example.testprotobufclient;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testprotobuf.protos.AddressBook;
import com.example.testprotobuf.protos.Person;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TestProtobuf";

    private final static String PROTO_DATA_NAME = "address_book.proto.data";
    private static String PROTO_DATA_PATH;

    private List<Person> contacts = new ArrayList<Person>();
    private ContactAdapter adtContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adtContact = new ContactAdapter(this, contacts);
        ListView lvContacts = findViewById(R.id.listViewContacts);
        lvContacts.setAdapter(adtContact);

        initProtobuf();
    }

    @Override
    protected void onResume() {
        super.onResume();

        loadProtobuf();
    }

    private void initProtobuf() {
        // Option 1: Internal path in file
        // /data/user/0/com.example.testprotobuf/files/address_book.proto.data
        // PROTO_DATA_PATH = getFilesDir() + "/" + PROTO_DATA_NAME;

        // Option 2: SDCard for sharing
        File sdCard = Environment.getExternalStorageDirectory();
        File dir = new File(sdCard.getAbsolutePath() + "/protos");
        dir.mkdirs();
        File file = new File(dir, PROTO_DATA_NAME);
        PROTO_DATA_PATH = file.getAbsolutePath();

        Log.d(TAG, "Proto data file path: " + PROTO_DATA_PATH);

        loadProtobuf();
    }

    private void loadProtobuf() {
        FileInputStream input;
        try {
            input = new FileInputStream(PROTO_DATA_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        try {
            AddressBook addressBook = AddressBook.parseFrom(input);
            contacts.clear();
            contacts.addAll(addressBook.getPeopleList());

            adtContact.notifyDataSetInvalidated();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (Throwable ignore) {
            }
        }
    }
}