package com.example.dsgc.view.adapter.viewHolders

import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ankit.trendinggit.BR
import com.ankit.trendinggit.R
import com.example.dsgc.model.Item
import com.example.dsgc.view.ui.repolist.RepoListViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_repo_list_item.view.*
import org.jetbrains.anko.bundleOf
import org.jetbrains.anko.sdk27.coroutines.onClick
import java.text.DateFormat
import java.text.SimpleDateFormat

class RepoListViewHolder constructor(private val dataBinding: ViewDataBinding, private val repoListViewModel: RepoListViewModel)
    : RecyclerView.ViewHolder(dataBinding.root) {

    val avatarImage = itemView.item_avatar
    val dateTime = itemView.item_time
    fun setup(itemData: Item) {
        dataBinding.setVariable(BR.itemData, itemData)
        dataBinding.executePendingBindings()

        Picasso.get().load(itemData.performers.get(0).image).into(avatarImage);
        dateTime.text =  getCreatedAt(itemData.datetime_utc)

        itemView.onClick {
            val bundle = bundleOf("item" to itemData)
            itemView.findNavController().navigate(R.id.action_repoListFragment_to_repoDetailFragment, bundle)
        }
    }

    private fun getCreatedAt(data: String):String {
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val createDate = formatter.parse(data)
        val dateFormat: DateFormat = SimpleDateFormat("E, dd MMM yyyy HH:mm:ss a")
        return dateFormat.format(createDate)
    }
}