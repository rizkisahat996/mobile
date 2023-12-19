package com.example.tubesss.ui.home

import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tubesss.R
import com.example.tubesss.data.Data
import com.example.tubesss.data.Task
import com.example.tubesss.data.Tasks
import com.example.tubesss.rest.API
import com.example.tubesss.rest.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://127.0.0.1:8000/api/task"

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CustomAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerview_tasks)
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager

        getTasks()
    }


    private fun getTasks(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(API::class.java)

        val retrofitData = retrofitBuilder.getTasks()

        retrofitData.enqueue(object: Callback<List<Data>> {

//            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
//                val taskList = response.body()!!
//
//                adapter = CustomAdapter(requireContext(), taskList)
//                recyclerView.adapter = adapter
//            }
            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {

                val dataList = response.body()!!

                val taskList = dataList.map { data ->
                    Task(
                        id = data.id,
                        title = data.title,
                        description = data.description,
                        status = data.status,
                        deadline = data.deadline,
                        user_id = data.user_id,
                    )
                }

                adapter = CustomAdapter(requireContext(), taskList)
                recyclerView.adapter = adapter

            }
            override fun onFailure(call: Call<List<Data>?>, t: Throwable) {
                d("HomeFragment", "onFailure: " + t.message)
            }
        })
    }


//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)

        // Use view from Fragment instead of findViewById
//        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
//        recyclerView.layoutManager = LinearLayoutManager(context)
//        getTasks()

//        val data = List<HomeViewModel>()
//
//        for (i in 1..20) {
//            data.add(HomeViewModel("Item $i", "Item $i", "Item $i", "Item $i"))
//        }

//        val adapter = CustomAdapter(data)
//        recyclerView.adapter = adapter
//    }

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
//    }

}