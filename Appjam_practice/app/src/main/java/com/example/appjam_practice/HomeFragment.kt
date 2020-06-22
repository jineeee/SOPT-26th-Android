package com.example.appjam_practice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.journeyapps.barcodescanner.BarcodeEncoder
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    fun newInstance(): HomeFragment {
        val args = Bundle()
        val frag = HomeFragment()
        frag.arguments = args

        return frag
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val button : Button = view.findViewById(R.id.button)
        button.setOnClickListener {
            createQR()
        }

        return view
    }

    fun createQR(){
        val text = "https://jinee0717.tistory.com/"
        val multiFormatWriter = MultiFormatWriter()
        try {
            val bitMatrix =
                multiFormatWriter.encode(text, BarcodeFormat.QR_CODE, 500, 500)
            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.createBitmap(bitMatrix)
            qrcode.setImageBitmap(bitmap)
        } catch (e: Exception) {
        }
    }
}
