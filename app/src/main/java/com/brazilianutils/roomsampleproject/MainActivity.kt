package com.brazilianutils.roomsampleproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mViewModel: NoteViewModel by viewModel()

    private val adapter by lazy {
        NoteListAdapter(this, mViewModel::delete)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mViewModel.allNotes.observe(this, Observer {
            adapter.notes = it
        })
        fab.setOnClickListener { view ->
            mViewModel.insert(Note("new"))
        }

        recyclerview.apply {
            adapter = this@MainActivity.adapter
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_clean -> {
                mViewModel.deleteAll()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
