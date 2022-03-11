package com.ambrella.firebaseexemple

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterItem: RecyclerView.Adapter<ListViewHolder>() {
    private var client: List<Client> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val quote=client.get(position)
        holder.init(quote)
    }

    override fun getItemCount(): Int {
        return client.size
    }

    fun setNote(t: List<Client>) {
        this.client = t
        notifyDataSetChanged()
    }

}

class ListViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private var mText1: TextView? = null
    private var mText2: TextView? = null
    private var mText3: TextView? = null

    init {
        mText1=itemView.findViewById(R.id.textView)
        mText2=itemView.findViewById(R.id.textView2)
        mText3=itemView.findViewById(R.id.textView3)
    }

    fun init(currentClient: Client){
       mText1?.text=currentClient.name
        mText2?.text=currentClient.Key
        mText3?.text=currentClient.message
    }
}
