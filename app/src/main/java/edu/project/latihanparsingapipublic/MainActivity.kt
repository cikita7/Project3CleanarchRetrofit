package edu.project.latihanparsingapipublic

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import edu.project.latihanparsingapipublic.adapter.UserAdapter
import edu.project.latihanparsingapipublic.data.remote.DataItem
import edu.project.latihanparsingapipublic.presentation.main.MainViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var adapter: UserAdapter
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        adapter = UserAdapter(mutableListOf())

        val recyclerView = findViewById<RecyclerView>(R.id.rv_users)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        mainViewModel.getUsers()

        mainViewModel.users.observe(this) { responseUser ->
            if (responseUser != null) {
                val dataArray = responseUser.data as List<DataItem>
                adapter.clearUsers()
                for (data in dataArray) {
                    adapter.addUser(data)
                }
            } else {
                Toast.makeText(this, "Failed to fetch users", Toast.LENGTH_SHORT).show()
            }
        }

        mainViewModel.isLoading.observe(this) { isLoading ->
            progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
    }
}

//NIM: 10122233
//NAMA: Cikita Meydilvira
//KELAS: PAndroid3