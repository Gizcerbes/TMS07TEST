package com.uogames.longProject.HW3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import com.uogames.longProject.R

class MainActivityHW3 : AppCompatActivity() {
    lateinit var viewModel: MainHW3ViewModel
    var rating:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_hw3)
        loadCreast()

        minskView()
        viciebskView()
        hrodnaView()
        brestView()
        homilelView()
        mahiloView()

        viewModel.start()

    }

    fun loadCreast() {
        viewModel = ViewModelProvider(this).get(MainHW3ViewModel::class.java)

        val crestMinsk = findViewById<ImageView>(R.id.hw3_crest_Minsk)
        val crestViciebsk = findViewById<ImageView>(R.id.hw3_crest_Viciebsk)
        val crestHrodna = findViewById<ImageView>(R.id.hw3_crest_Hrodna)
        val crestBrest = findViewById<ImageView>(R.id.hw3_crest_Brest)
        val crestHomiel = findViewById<ImageView>(R.id.hw3_crest_Homiel)
        val crestMahilo = findViewById<ImageView>(R.id.hw3_crest_Mahilo)

        Picasso.get().load(getString(R.string.Link_crest_Minsk)).into(crestMinsk)
        Picasso.get().load(getString(R.string.Link_crest_Viciebsk)).into(crestViciebsk)
        Picasso.get().load(getString(R.string.Link_crest_Hrodna)).into(crestHrodna)
        Picasso.get().load(getString(R.string.Link_crest_Brest)).into(crestBrest)
        Picasso.get().load(getString(R.string.Link_crest_Homiel)).into(crestHomiel)
        Picasso.get().load(getString(R.string.Link_crest_Mahilo)).into(crestMahilo)
    }

    fun minskView() {
        val countCereal = findViewById<TextView>(R.id.hw3_count_cereal_Minsk)
        val progressCereal = findViewById<ProgressBar>(R.id.hw3_progress_cereal_Minsk)
        val countPotatoes = findViewById<TextView>(R.id.hw3_count_potatoes_Minsk)
        val progressPotatoes = findViewById<ProgressBar>(R.id.hw3_progress_potatoes_Minsk)
        val countCabbage = findViewById<TextView>(R.id.hw3_count_cabbage_Minsk)
        val progressCabbage = findViewById<ProgressBar>(R.id.hw3_progress_cabbage_Minsk)
        val countBeet = findViewById<TextView>(R.id.hw3_count_beet_Minsk)
        val progressBeet = findViewById<ProgressBar>(R.id.hw3_progress_beet_Minsk)
        val region = findViewById<TextView>(R.id.hw3_region_Minsk)

        viewModel.countCerealMinsk.observe(this) {
            countCereal.text = "$it/1000"
            progressCereal.progress = it * 100 / 1000
        }

        viewModel.countPotatoesMinsk.observe(this) {
            countPotatoes.text = "$it/1000"
            progressPotatoes.progress = it * 100 / 1000
        }

        viewModel.countCabbageMinsk.observe(this) {
            countCabbage.text = "$it/1000"
            progressCabbage.progress = it * 100 / 1000
        }

        viewModel.countBeetMinsk.observe(this) {
            countBeet.text = "$it/1000"
            progressBeet.progress = it * 100 / 1000
        }

        viewModel.endSowingMinsk.observe(this) {
            if (it) {
                region.text = region.text.toString() + " #" + ++rating
                region.setBackgroundColor(Color.GREEN)
            }
        }
    }

    fun viciebskView() {
        val countCereal = findViewById<TextView>(R.id.hw3_count_cereal_Viciebsk)
        val progressCereal = findViewById<ProgressBar>(R.id.hw3_progress_cereal_Viciebsk)
        val countPotatoes = findViewById<TextView>(R.id.hw3_count_potatoes_Viciebsk)
        val progressPotatoes = findViewById<ProgressBar>(R.id.hw3_progress_potatoes_Viciebsk)
        val countCabbage = findViewById<TextView>(R.id.hw3_count_cabbage_Viciebsk)
        val progressCabbage = findViewById<ProgressBar>(R.id.hw3_progress_cabbage_Viciebsk)
        val countBeet = findViewById<TextView>(R.id.hw3_count_beet_Viciebsk)
        val progressBeet = findViewById<ProgressBar>(R.id.hw3_progress_beet_Vitebsk)
        val region = findViewById<TextView>(R.id.hw3_region_Viciebsk)

        viewModel.countCerealViciebsk.observe(this) {
            countCereal.text = "$it/1000"
            progressCereal.progress = it * 100 / 1000
        }

        viewModel.countPotatoesViciebsk.observe(this) {
            countPotatoes.text = "$it/1000"
            progressPotatoes.progress = it * 100 / 1000
        }

        viewModel.countCabbageViciebsk.observe(this) {
            countCabbage.text = "$it/1000"
            progressCabbage.progress = it * 100 / 1000
        }

        viewModel.countBeetViciebsk.observe(this) {
            countBeet.text = "$it/1000"
            progressBeet.progress = it * 100 / 1000
        }

        viewModel.endSowingViciebsk.observe(this) {
            if (it) {
                region.text = region.text.toString() + " #" + ++rating
                region.setBackgroundColor(Color.GREEN)
            }
        }
    }

    fun hrodnaView() {
        val countCereal = findViewById<TextView>(R.id.hw3_count_cereal_Hrodna)
        val progressCereal = findViewById<ProgressBar>(R.id.hw3_progress_cereal_Hrodna)
        val countPotatoes = findViewById<TextView>(R.id.hw3_count_potatoes_Hrodna)
        val progressPotatoes = findViewById<ProgressBar>(R.id.hw3_progress_potatoes_Hrodna)
        val countCabbage = findViewById<TextView>(R.id.hw3_count_cabbage_Hrodna)
        val progressCabbage = findViewById<ProgressBar>(R.id.hw3_progress_cabbage_Hrodna)
        val countBeet = findViewById<TextView>(R.id.hw3_count_beet_Hrodna)
        val progressBeet = findViewById<ProgressBar>(R.id.hw3_progress_beet_Hrodna)
        val region = findViewById<TextView>(R.id.hw3_region_Hrodna)

        viewModel.countCerealHrodna.observe(this) {
            countCereal.text = "$it/1000"
            progressCereal.progress = it * 100 / 1000
        }

        viewModel.countPotatoesHrodna.observe(this) {
            countPotatoes.text = "$it/1000"
            progressPotatoes.progress = it * 100 / 1000
        }

        viewModel.countCabbageHrodna.observe(this) {
            countCabbage.text = "$it/1000"
            progressCabbage.progress = it * 100 / 1000
        }

        viewModel.countBeetHrodna.observe(this) {
            countBeet.text = "$it/1000"
            progressBeet.progress = it * 100 / 1000
        }

        viewModel.endSowingHrodna.observe(this) {
            if (it) {
                region.text = region.text.toString() + " #" + ++rating
                region.setBackgroundColor(Color.GREEN)
            }
        }
    }

    fun brestView() {
        val countCereal = findViewById<TextView>(R.id.hw3_count_cereal_Brest)
        val progressCereal = findViewById<ProgressBar>(R.id.hw3_progress_cereal_Brest)
        val countPotatoes = findViewById<TextView>(R.id.hw3_count_potatoes_Brest)
        val progressPotatoes = findViewById<ProgressBar>(R.id.hw3_progress_potatoes_Brest)
        val countCabbage = findViewById<TextView>(R.id.hw3_count_cabbage_Brest)
        val progressCabbage = findViewById<ProgressBar>(R.id.hw3_progress_cabbage_Brest)
        val countBeet = findViewById<TextView>(R.id.hw3_count_beet_Brest)
        val progressBeet = findViewById<ProgressBar>(R.id.hw3_progress_beet_Brest)
        val region = findViewById<TextView>(R.id.hw3_region_Brest)

        viewModel.countCerealBrest.observe(this) {
            countCereal.text = "$it/1000"
            progressCereal.progress = it * 100 / 1000
        }

        viewModel.countPotatoesBrest.observe(this) {
            countPotatoes.text = "$it/1000"
            progressPotatoes.progress = it * 100 / 1000
        }

        viewModel.countCabbageBrest.observe(this) {
            countCabbage.text = "$it/1000"
            progressCabbage.progress = it * 100 / 1000
        }

        viewModel.countBeetBrest.observe(this) {
            countBeet.text = "$it/1000"
            progressBeet.progress = it * 100 / 1000
        }

        viewModel.endSowingBrest.observe(this) {
            if (it) {
                region.text = region.text.toString() + " #" + ++rating
                region.setBackgroundColor(Color.GREEN)
            }
        }
    }

    fun homilelView() {
        val countCereal = findViewById<TextView>(R.id.hw3_count_cereal_Homiel)
        val progressCereal = findViewById<ProgressBar>(R.id.hw3_progress_cereal_Homiel)
        val countPotatoes = findViewById<TextView>(R.id.hw3_count_potatoes_Homiel)
        val progressPotatoes = findViewById<ProgressBar>(R.id.hw3_progress_potatoes_Homiel)
        val countCabbage = findViewById<TextView>(R.id.hw3_count_cabbage_Homiel)
        val progressCabbage = findViewById<ProgressBar>(R.id.hw3_progress_cabbage_Homiel)
        val countBeet = findViewById<TextView>(R.id.hw3_count_beet_Homiel)
        val progressBeet = findViewById<ProgressBar>(R.id.hw3_progress_beet_Homiel)
        val region = findViewById<TextView>(R.id.hw3_region_Homiel)

        viewModel.countCerealHomiel.observe(this) {
            countCereal.text = "$it/1000"
            progressCereal.progress = it * 100 / 1000
        }

        viewModel.countPotatoesHomiel.observe(this) {
            countPotatoes.text = "$it/1000"
            progressPotatoes.progress = it * 100 / 1000
        }

        viewModel.countCabbageHomiel.observe(this) {
            countCabbage.text = "$it/1000"
            progressCabbage.progress = it * 100 / 1000
        }

        viewModel.countBeetHomiel.observe(this) {
            countBeet.text = "$it/1000"
            progressBeet.progress = it * 100 / 1000
        }

        viewModel.endSowingHomiel.observe(this) {
            if (it) {
                region.text = region.text.toString() + " #" + ++rating
                region.setBackgroundColor(Color.GREEN)
            }
        }
    }

    fun mahiloView() {
        val countCereal = findViewById<TextView>(R.id.hw3_count_cereal_Mahilo)
        val progressCereal = findViewById<ProgressBar>(R.id.hw3_progress_cereal_Mahilo)
        val countPotatoes = findViewById<TextView>(R.id.hw3_count_potatoes_Mahilo)
        val progressPotatoes = findViewById<ProgressBar>(R.id.hw3_progress_potatoes_Mahilo)
        val countCabbage = findViewById<TextView>(R.id.hw3_count_cabbage_Mahilo)
        val progressCabbage = findViewById<ProgressBar>(R.id.hw3_progress_cabbage_Mahilo)
        val countBeet = findViewById<TextView>(R.id.hw3_count_beet_Mahilo)
        val progressBeet = findViewById<ProgressBar>(R.id.hw3_progress_beet_Mahilo)
        val region = findViewById<TextView>(R.id.hw3_region_Mahilo)

        viewModel.countCerealMahilo.observe(this) {
            countCereal.text = "$it/1000"
            progressCereal.progress = it * 100 / 1000
        }

        viewModel.countPotatoesMahilo.observe(this) {
            countPotatoes.text = "$it/1000"
            progressPotatoes.progress = it * 100 / 1000
        }

        viewModel.countCabbageMahilo.observe(this) {
            countCabbage.text = "$it/1000"
            progressCabbage.progress = it * 100 / 1000
        }

        viewModel.countBeetMahilo.observe(this) {
            countBeet.text = "$it/1000"
            progressBeet.progress = it * 100 / 1000
        }

        viewModel.endSowingMahilo.observe(this) {
            if (it) {
                region.text = region.text.toString() + " #" + ++rating
                region.setBackgroundColor(Color.GREEN)
            }
        }
    }


}