package com.example.TodoAPI_jan10.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.TodoAPI_jan10.databinding.RowItemTodoBinding
import com.example.TodoAPI_jan10.model.network.models.Todo

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    private val todosList = mutableListOf<Todo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            RowItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todosList[position])
    }

    override fun getItemCount(): Int {
        return todosList.size
    }

    fun submitList(todos: List<Todo>) {
        todosList.clear()
        todosList.addAll(todos)
        notifyDataSetChanged()
    }

    class TodoViewHolder(
        private val binding: RowItemTodoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: Todo) = with(binding) {
            userIdTv.text = todo.userId.toString()
            idTv.text = todo.id.toString()
            titleTv.text = todo.title
            completedTv.text = todo.completed.toString()
        }
    }
}