package com.kerumitbsl.netronictest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kerumitbsl.core.bean.models.user.UserModel
import com.kerumitbsl.netronictest.databinding.UserItemBinding
import com.kerumitbsl.netronictest.extensions.loadImage
import java.util.*

class UsersListAdapter : ListAdapter<UserModel, UsersListAdapter.ItemViewHolder>(DiffCallback()), Filterable {

    var onClick: (UserModel) -> Unit = {}
    var contentList: () -> MutableList<UserModel> = { mutableListOf() }

    override fun submitList(list: List<UserModel>?) {
        super.submitList(list)
        notifyDataSetChanged() // because it doesn't update otherwise
    }

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
            loadImage(item.picture.thumbnail, binder.userIconImageView)

            binder.root.setOnClickListener {
                onClick(item)
            }
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString: String = constraint.toString()

                var filteredList = mutableListOf<UserModel>()

                if (charString.isEmpty()) {
                    filteredList = contentList()
                } else {
                    for (item in contentList()) {
                        if ("${item.name.first}${item.name.last}".lowercase(Locale.getDefault()).contains(charString)) {
                            filteredList.add(item)
                        }
                    }
                }

                return FilterResults().apply { values = filteredList }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                submitList(results?.values as List<UserModel>)
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