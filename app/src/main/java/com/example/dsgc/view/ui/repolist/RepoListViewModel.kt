package com.example.dsgc.view.ui.repolist

import androidx.lifecycle.MutableLiveData
import com.example.dsgc.model.Item
import com.example.dsgc.model.RepoRepository
import com.example.dsgc.view.base.BaseViewModel

class RepoListViewModel : BaseViewModel() {
    val repoListLive = MutableLiveData<List<Item>>()

    fun fetchRepoList(query: String) {
        dataLoading.value = true
        RepoRepository.getInstance().getRepoList(query) { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                repoListLive.value = response?.events
                empty.value = false
            } else {
                empty.value = true
            }
        }
    }
}