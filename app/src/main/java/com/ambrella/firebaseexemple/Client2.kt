package com.ambrella.firebaseexemple

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class ClientList(
    val Client: List<Client>
)