package com.ambrella.firebaseexemple

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {
    private lateinit var dbReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbReference = FirebaseDatabase.getInstance().getReference("Client")

            dbReference.addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (sn in snapshot.children){
                    //var client: Client? =snapshot.getValue(Client::class.java)
                    Log.d("TAG", "onDataChange: $sn")
                }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@MainActivity, "а вот хрен", Toast.LENGTH_SHORT).show()
                }

            })

        }
    }
