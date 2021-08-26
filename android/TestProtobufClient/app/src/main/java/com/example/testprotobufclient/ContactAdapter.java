package com.example.testprotobufclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.testprotobuf.protos.Person;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Person> {
    public ContactAdapter(Context context, List<Person> contacts) {
        super(context, 0, contacts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Person contact = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_contact, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.textViewName);
        TextView tvEmail = (TextView) convertView.findViewById(R.id.textViewEmail);
        // Populate the data into the template view using the data object
        tvName.setText(contact.getName());
//        tvEmail.setText(contact.getEmail());
        // Return the completed view to render on screen
        return convertView;
    }
}