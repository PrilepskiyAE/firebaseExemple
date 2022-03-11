package com.ambrella.firebaseexemple

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Client(var Key:String?=null,var message:String?=null,var name:String?=null)
