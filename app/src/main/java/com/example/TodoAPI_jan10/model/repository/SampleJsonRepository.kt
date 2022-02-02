package com.example.TodoAPI_jan10.model.repository

import com.example.TodoAPI_jan10.model.network.ApiManager
import com.example.TodoAPI_jan10.model.network.models.Todo
import com.example.TodoAPI_jan10.utils.Resource

class SampleJsonRepository(
    private val apiManager: ApiManager
) {
    suspend fun getTodos(): Resource<List<Todo>> {
        return try {
            val response = apiManager.getTodos()
            if (response.isSuccessful && response.body() != null) {
                Resource.Success(response.body()!!)
            } else {
                Resource.Error("Failed to get Todos.")
            }
        } catch (ex: Exception) {
            Resource.Error("unexpected error")
        }
    }
}
