package com.nitip.therealnitip;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by Jabal Logian on 11/01/2018.
 */

public class FirebaseHelper {

    DatabaseReference database;
    Boolean saved = null;
    ArrayList<BarangInHome> dataBarangInHomes = new ArrayList<>();

    public FirebaseHelper(DatabaseReference db){
        this.database = database;
    }

    public Boolean save(BarangInHome dataBarangInHome){

        if (dataBarangInHome == null){
            saved = false;
        }
        else {
            try{
                database.child("Barang").push().setValue(dataBarangInHome);
                saved = true;
            }
            catch (DatabaseException e){
                e.printStackTrace();
                saved = false;
            }
        }

        return saved;
    }

    private void fetchData (DataSnapshot dataSnapshot){

        dataBarangInHomes.clear();

        for (DataSnapshot ds : dataSnapshot.getChildren()){
            BarangInHome dataBarangInHome = ds.getValue(BarangInHome.class);
            dataBarangInHomes.add(dataBarangInHome);
        }
    }

    public ArrayList<BarangInHome> retrieve(){

        database.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return dataBarangInHomes;
    }
}
