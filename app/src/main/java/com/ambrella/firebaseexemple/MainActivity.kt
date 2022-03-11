package com.ambrella.firebaseexemple

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {
    private lateinit var dbReference: DatabaseReference
    private lateinit var button: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var recycler:RecyclerView
    private var userId: String = ""
    private val itemAdapter = AdapterItem()
    private var clientList:MutableList<Client> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button=findViewById(R.id.button2)
        button2=findViewById(R.id.button)
        button3=findViewById(R.id.button3)
        recycler=findViewById(R.id.rcview)

        recycler.adapter=itemAdapter

        button2.setOnClickListener {
        dbReference.removeValue()
        }

        button3.setOnClickListener {

        }

        //add
        button.setOnClickListener {
            userId = dbReference.push().key.toString()

            val client = Client("keytest","messagetest","nametest")
            dbReference.child(userId).setValue(client)

        }
        dbReference = FirebaseDatabase.getInstance().getReference("Client")

            dbReference.addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (sn in snapshot.children){
                    var client: Client? =sn.getValue(Client::class.java)
                    Log.d("TAG", "onDataChange: $client")
                        if (client != null) {
                            clientList.add(client)
                        }


                }
                    Log.d("TAG", "onDataChange:${clientList} ")
                    itemAdapter.setNote(clientList)
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@MainActivity, "а вот хрен", Toast.LENGTH_SHORT).show()
                }

            })

        }


    }
