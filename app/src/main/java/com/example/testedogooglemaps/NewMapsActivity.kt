package com.example.testedogooglemaps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.testedogooglemaps.databinding.ActivityNewMapsBinding

class NewMapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityNewMapsBinding

    val pulcinella = LatLng(-3.7309379231012016, -38.49907823747698)
    val emporioDelitalia = LatLng(-3.7306067283432953, -38.49644149140438)
    val padariaCostaMendes = LatLng(-3.730845924569872, -38.50540274029445)
    val vignoliFortaleza = LatLng(-3.7269267781922597, -38.49137082588017)
    val carneiroDoOrdones = LatLng(-3.73233629959148, -38.489508508724)

    var locationArrayList: ArrayList<LatLng>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        locationArrayList = ArrayList()

        locationArrayList!!.add(pulcinella)
        locationArrayList!!.add(emporioDelitalia)
        locationArrayList!!.add(padariaCostaMendes)
        locationArrayList!!.add(vignoliFortaleza)
        locationArrayList!!.add(carneiroDoOrdones)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        for (location in locationArrayList!!.indices) {
            mMap.addMarker(MarkerOptions().position(locationArrayList!![location]).title("Marcador"))
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(locationArrayList!![location], 15f))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(locationArrayList!![location]))
        }

    }
}