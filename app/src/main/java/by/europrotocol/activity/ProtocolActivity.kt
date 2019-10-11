package by.europrotocol.activity

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import by.europrotocol.R
import by.europrotocol.data.model.EuroProtocolModel
import by.europrotocol.data.repository.RamEuroProtocol
import by.europrotocol.data.repository.RepositoryEuroProtocolConvertPdf
import by.europrotocol.data.repository.StubRepository
import by.europrotocol.drawing.ProtocolDrawer
import com.itextpdf.text.Document
import com.itextpdf.text.Image
import com.itextpdf.text.pdf.PdfWriter
import kotlinx.android.synthetic.main.activity_protocol.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class ProtocolActivity : AppCompatActivity() {

    val width = 849
    val height = 1200
    val PATH = Environment.getExternalStorageDirectory().path
    val DOCUMENT = "$PATH/protocol.pdf"
    val IMAGE = "$PATH/protocol.jpg"
    lateinit var repository: RepositoryEuroProtocolConvertPdf

    lateinit var protocol: EuroProtocolModel

    private var state: State = State.SIGNATURE_1

    companion object {

        val ARG = "ARG"
        fun newIntent(context: Context): Intent = Intent(context, ProtocolActivity::class.java).apply {
            putExtra(ARG, true)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_protocol)
        if (!isPermissionGranted()) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 100)
        }

        val check: Boolean? = intent.extras?.get(ARG) as Boolean? ?: false

        repository = if (check != null && check){
            StubRepository()
        } else {
            RamEuroProtocol
        }
        protocol = repository.getPdfModel()

        initViews()
        renderState()
    }

    private fun initViews() {
        dw_signature_1.setStrokeWidth(12f)
        dw_signature_2.setStrokeWidth(12f)
        dw_scheme.setStrokeWidth(12f)
        btn_scheme_ok.setOnClickListener {
            if (isPermissionGranted()) {
                GlobalScope.launch {
                    draw()
                    createPdf()
                    showImage()
                }
            }
        }

        btn_signature_1.setOnClickListener { dw_signature_1.clearCanvas() }
        btn_signature_2.setOnClickListener { dw_signature_2.clearCanvas() }
        btn_scheme.setOnClickListener { dw_scheme.clearCanvas() }
        btn_signature_1_ok.setOnClickListener {
            state = State.SIGNATURE_2
            renderState()
        }
        btn_signature_2_ok.setOnClickListener {
            state = State.SCHEME
            renderState()
        }

        btn_pdf.setOnClickListener {
            Toast.makeText(this, "Готово", Toast.LENGTH_SHORT).show()
        }
    }

    private suspend fun draw() = withContext(Dispatchers.IO) {
        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.protocol).copy(Bitmap.Config.ARGB_8888, true)
        bitmap = scaleDown(bitmap)
        protocol.scheme = dw_scheme.getBitmap()
        protocol.roadAccidentParticipantOne.signature = dw_signature_1.getBitmap()
        protocol.roadAccidentParticipantTwo.signature = dw_signature_2.getBitmap()
        val drawer = ProtocolDrawer(bitmap, protocol)
        bitmap = drawer.drawProtocol()
        show(bitmap)
        try {
            val out = FileOutputStream(File(IMAGE))
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private suspend fun createPdf() = withContext(Dispatchers.IO) {
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

    private fun scaleDown(image: Bitmap): Bitmap {
        return Bitmap.createScaledBitmap(image, width, height, true)
    }

    private suspend fun show(bitmap: Bitmap) = withContext(Dispatchers.Main) {
        iv_protocol.setImageDrawable(BitmapDrawable(resources, bitmap))
    }

    private suspend fun showImage() = withContext(Dispatchers.Main) {
        state = State.PROTOCOL
        renderState()
    }

    private fun renderState() {
        when(state) {
            State.SIGNATURE_1 -> {
                ll_signature_1.visibility = View.VISIBLE
                supportActionBar?.title = "Подпись водителя 1"
            }
            State.SIGNATURE_2 -> {
                ll_signature_1.visibility = View.GONE
                ll_signature_2.visibility = View.VISIBLE
                supportActionBar?.title = "Подпись водителя 2"
            }
            State.SCHEME -> {
                ll_signature_2.visibility = View.GONE
                ll_scheme.visibility = View.VISIBLE
                supportActionBar?.title = "Схема ДТП"
            }
            State.PROTOCOL -> {
                ll_scheme.visibility = View.GONE
                iv_protocol.visibility = View.VISIBLE
                btn_pdf.visibility = View.VISIBLE
                supportActionBar?.title = "Экспорт в PDF"
            }
        }
    }



    enum class State {
        SIGNATURE_1,
        SIGNATURE_2,
        SCHEME,
        PROTOCOL
    }
}
