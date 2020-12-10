package pt.atp.bobi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pt.atp.bobi.data.DogsAPIClient
import pt.atp.bobi.data.cb.DataRetriever
import pt.atp.bobi.data.model.Breed
private const val TAG="ListActivity"
class ListActivity : AppCompatActivity(), DataRetriever {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        findViewById<RecyclerView>(R.id.rv_breeds).apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(applicationContext)
            adapter = BreedsAdapter()
        }
        DogsAPIClient.getListOfBreeds(this)
    }

    override fun onDataFetchedSuccess(breeds: List<Breed>) {
        Log.d(TAG,"onDataFetchedSuccess")
        val adapter: BreedsAdapter = findViewById<RecyclerView>(R.id.rv_breeds).adapter as BreedsAdapter
        adapter.submitList(breeds)
    }

    override fun onDataFetchedFailed() {
        Log.d(TAG,"onDataFetchedFailed")
    }
}