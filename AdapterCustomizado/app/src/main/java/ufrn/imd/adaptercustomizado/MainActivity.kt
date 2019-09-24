package ufrn.imd.adaptercustomizado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {


    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val (modelo, ano) = veiculos[p2]

        Toast.makeText(this,
            "$modelo  - $ano",
            Toast.LENGTH_SHORT).show()

        veiculos.remove(veiculos[p2])
        adapter.notifyDataSetChanged()

    }

    lateinit var adapter:VeiculoAdapter

    val veiculos = mutableListOf(
        Veiculo("Onix",2018,1,true, true),
        Veiculo("Uno",2007,2,true, false),
        Veiculo("Del Rey",1998,3,false, true),
        Veiculo("Gol",2014,0,true, true),
        Veiculo("Onix",2018,1,true, true),
        Veiculo("Uno",2007,2,true, false),
        Veiculo("Del Rey",1998,3,false, true),
        Veiculo("Gol",2014,0,true, true),
        Veiculo("Onix",2018,1,true, true),
        Veiculo("Uno",2007,2,true, false),
        Veiculo("Del Rey",1998,3,false, true),
        Veiculo("Gol",2014,0,true, true),
        Veiculo("Onix",2018,1,true, true),
        Veiculo("Uno",2007,2,true, false),
        Veiculo("Del Rey",1998,3,false, true),
        Veiculo("Gol",2014,0,true, true)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val listView = ListView(this)
        setContentView(listView)

        adapter = VeiculoAdapter(this,veiculos)

        listView.adapter = adapter

        listView.setOnItemClickListener(this)

    }
}
