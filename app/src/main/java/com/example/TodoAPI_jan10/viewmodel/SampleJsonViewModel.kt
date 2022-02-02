package com.example.TodoAPI_jan10.viewmodel

import androidx.lifecycle.*
import com.example.TodoAPI_jan10.model.repository.SampleJsonRepository
import com.example.TodoAPI_jan10.utils.Resource
import com.example.TodoAPI_jan10.utils.SelectedData
import kotlinx.coroutines.launch
import java.lang.RuntimeException

class SampleJsonViewModel(
    private val sampleJsonRepository: SampleJsonRepository
) : ViewModel() {

    private var _data: MutableLiveData<Resource<List<Any>>> = MutableLiveData()
    val data: LiveData<Resource<List<Any>>> = _data

    init {
        getTodos()
    }

    var selectedDataType = SelectedData.TODOS
        set(value) {
            when (value) {
                SelectedData.TODOS -> getTodos()
            }
            field = value
        }

    private fun getTodos() {
        _data.value = Resource.Loading
        viewModelScope.launch {
            val response = sampleJsonRepository.getTodos()
            _data.postValue(response)
        }
    }

    class Factory(
        private val sampleJsonRepository: SampleJsonRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SampleJsonViewModel::class.java)) {
                return SampleJsonViewModel(sampleJsonRepository) as T
            } else {
                throw RuntimeException("Could not create instance of TodoViewModel")
            }
        }

    }
}