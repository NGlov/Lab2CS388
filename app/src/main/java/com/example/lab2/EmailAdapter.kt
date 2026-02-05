package com.example.lab2

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val senderTextView: TextView = itemView.findViewById(R.id.senderTv)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTv)
        val summaryTextView: TextView = itemView.findViewById(R.id.summaryTv)
        val dateTextView: TextView = itemView.findViewById(R.id.dateTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.email_item, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val email = emails[position]
        holder.senderTextView.text = email.sender
        holder.titleTextView.text = email.title
        holder.summaryTextView.text = email.summary
        holder.dateTextView.text = email.date

        if (!email.isRead) {
            holder.senderTextView.setTypeface(null, Typeface.BOLD)
            holder.titleTextView.setTypeface(null, Typeface.BOLD)
        } else {
            holder.senderTextView.setTypeface(null, Typeface.NORMAL)
            holder.titleTextView.setTypeface(null, Typeface.NORMAL)
        }
    }

    override fun getItemCount(): Int {
        return emails.size
    }
}