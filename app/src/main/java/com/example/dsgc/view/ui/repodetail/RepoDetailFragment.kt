package com.example.dsgc.view.ui.repodetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ankit.trendinggit.BR
import com.ankit.trendinggit.databinding.FragmentRepoDetailBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_repo_detail.*
import java.text.DateFormat
import java.text.SimpleDateFormat


class RepoDetailFragment : Fragment() {
    private lateinit var viewDataBinding: FragmentRepoDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //return inflater.inflate(R.layout.fragment_repo_detail, container, false)
        viewDataBinding = FragmentRepoDetailBinding.inflate(inflater, container, false)

        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val itemData = arguments?.let { RepoDetailFragmentArgs.fromBundle(it).item }


        if (itemData != null) {
            viewDataBinding.setVariable(BR.itemData, itemData)
            viewDataBinding.executePendingBindings()
            Picasso.get().load(itemData.performers.get(0).image).into(item_avatar);
            item_time.text = getCreatedAt(itemData.datetime_utc)
        }
    }

    private fun getCreatedAt(data: String):String {
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val createDate = formatter.parse(data)
        val dateFormat: DateFormat = SimpleDateFormat("E, dd MMM yyyy HH:mm:ss a")
        return dateFormat.format(createDate)
    }
}

