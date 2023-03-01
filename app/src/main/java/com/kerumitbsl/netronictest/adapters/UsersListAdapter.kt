package com.kerumitbsl.netronictest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kerumitbsl.core.bean.models.user.UserModel
import com.kerumitbsl.netronictest.databinding.UserItemBinding

class UsersListAdapter(private val onClick: (UserModel) -> Unit) : ListAdapter<UserModel, UsersListAdapter.ItemViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(
            UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)
    }

    class ItemViewHolder(private val binder: UserItemBinding) : RecyclerView.ViewHolder(binder.root) {
        fun bind(item: UserModel, onClick: (UserModel) -> Unit) = with(binder) {

            binder.userNameTextView.text = "${item.name.first} ${item.name.last}"
            binder.userNationalityTextView.text = item.nat

            binder.root.setOnClickListener {
                onClick(item)
            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<UserModel>() {
    override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
        return oldItem == newItem
    }
}