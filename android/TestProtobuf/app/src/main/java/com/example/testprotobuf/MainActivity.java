package com.example.testprotobuf;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testprotobuf.protos.AddressBook;
import com.example.testprotobuf.protos.Person;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TestProtobuf";

    private final static String PROTO_DATA_NAME = "address_book.proto.data";
    private static String PROTO_DATA_PATH;

    private static final Random rand = new Random();

    private EditText mName;
    private EditText mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initProtobuf();

        mName = findViewById(R.id.editTextTextPersonName);
        mEmail = findViewById(R.id.editTextTextEmailAddress);

        Button btnAdd = findViewById(R.id.buttonAddContact);
        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                addContact(mName.getText().toString(), mEmail.getText().toString());
            }
        });
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
    }

    private void addContact(String name, String email) {
        AddressBook.Builder addressBook = AddressBook.newBuilder();

        // Read the existing address book.
        try {
            FileInputStream input = new FileInputStream(PROTO_DATA_PATH);
            try {
                addressBook.mergeFrom(input);
            } catch (IOException e) {
                e.printStackTrace();
                Log.e(TAG, PROTO_DATA_PATH + ": Failed to merge.");
            } finally {
                try {
                    input.close();
                } catch (Throwable ignore) {
                }
            }
        } catch (FileNotFoundException e) {
            Log.w(TAG, PROTO_DATA_PATH + ": File not found.  Creating a new file.");
        }

        // Add an address.
        try {
            addressBook.addPeople(buildPeople(name, email));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write the new address book back to disk.
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(PROTO_DATA_PATH);
            addressBook.build().writeTo(output);

            Log.d(TAG, "Added the contact: [" + name + ", " + email + "]");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.e(TAG, PROTO_DATA_PATH + ": Failed to write.");
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, PROTO_DATA_PATH + ": Failed to write.");
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (Throwable ignore) {
                }
            }
        }
    }

    static private Person buildPeople(String name, String email) throws IOException {
        Person.Builder person = Person.newBuilder();

        person.setId(rand.nextInt());
        person.setName(Integer.valueOf(name));
        person.setEmail(email);

        return person.build();
    }


}