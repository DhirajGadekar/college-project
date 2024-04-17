package com.pollutionmonitor.service;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.*;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirebaseToMySQLService {

    @Autowired
    private FirebaseApp firebaseApp;

    @Autowired
    private AirQualityService airQualityService;

    public void fetchDataAndStoreInMySQL() {
        DatabaseReference database = FirebaseDatabase.getInstance(firebaseApp).getReference();
        database.child("Data").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                DataSnapshot firstChild = null;

                Iterator<DataSnapshot> iterator = children.iterator();
                if (iterator.hasNext()) {

                    firstChild = iterator.next();
                    Object value = firstChild.getValue();
                    int airQuality = Integer.parseInt(value.toString());
                    airQualityService.addAirQuality(airQuality);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                if (databaseError != null) {
                    System.out.println("Database error occurred: " + databaseError.getMessage());
                } else {
                    System.out.println("Listener was cancelled");
                }
            }
        });
    }
}
