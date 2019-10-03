package by.europrotocol.activity

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import androidx.core.app.ActivityCompat
import by.europrotocol.R
import com.itextpdf.text.Document
import com.itextpdf.text.Image
import com.itextpdf.text.pdf.PdfWriter
import kotlinx.android.synthetic.main.activity_protocol.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class ProtocolActivity : AppCompatActivity() {

    val PATH = Environment.getExternalStorageDirectory().path
    val DOCUMENT = "$PATH/protocol.pdf"
    val IMAGE = "$PATH/protocol.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_protocol)
        if (!isPermissionGranted()) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 100)
        }
        btn_pdf.setOnClickListener {
            if (isPermissionGranted()) {
                draw()
                createPdf()
            }
        }
    }

    private fun draw() {
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.protocol).copy(Bitmap.Config.ARGB_8888, true)
        val canvas = Canvas(bitmap)
        canvas.drawBitmap(bitmap, 0f, 0f, null)
        canvas.drawText("EuroProtocol", 100f, 200f, Paint().apply {
            color = Color.BLACK
            textSize = 100f
        })
        iv_protocol.setImageDrawable(BitmapDrawable(resources, bitmap))
        try {
            val out = FileOutputStream(File(IMAGE))
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun createPdf() {
        val document = Document()
        PdfWriter.getInstance(document, FileOutputStream(File(DOCUMENT)))
        document.open()
        val image = Image.getInstance(IMAGE)
        val scaler = ((document.pageSize.width - document.leftMargin() - document.rightMargin())/ image.width) * 110
        image.scalePercent(scaler)
        image.alignment = Image.ALIGN_CENTER or Image.ALIGN_TOP
        document.add(image)
        document.close()
    }

    private fun isPermissionGranted(): Boolean {
        return checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
    }
}
