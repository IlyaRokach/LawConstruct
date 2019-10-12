package by.europrotocol.drawing

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.core.graphics.scale
import by.europrotocol.data.model.drawing.Cross
import by.europrotocol.data.model.drawing.Line
import by.europrotocol.data.model.drawing.Point

class Drawer(
    private val bitmap: Bitmap,
    private val canvas: Canvas = Canvas(bitmap)
) {

    fun drawCross(cross: Cross) {
        canvas.drawLine(cross.start.x, cross.start.y, cross.end.x, cross.end.y, PaintProvider.linePaint)
        canvas.drawLine(cross.start.x, cross.end.y, cross.end.x, cross.start.y, PaintProvider.linePaint)
    }

    fun drawText(point: Point, text: String) {
        canvas.drawText(text, point.x, point.y, PaintProvider.textPaint)
    }

    fun drawSignature(point: Point, bitmap: Bitmap) {
        setTransparentBackground(bitmap)
        canvas.drawBitmap(bitmap.scale(100, 70, true), point.x, point.y, Paint())
    }

    fun drawScheme(point: Point, bitmap: Bitmap) {
        setTransparentBackground(bitmap)
        canvas.drawBitmap(bitmap.scale(474, 223, true), point.x, point.y, Paint())
    }

    fun drawLine(line: Line) {
        canvas.drawLine(line.start.x, line.start.y, line.end.x, line.end.y, PaintProvider.linePaint)
    }

    private fun setTransparentBackground(bitmap: Bitmap) {
        val color = Color.parseColor("#01579B")
        for (x in 0 until bitmap.width) {
            for (y in 0 until bitmap.height) {
                if (bitmap.getPixel(x,y) == color || bitmap.getPixel(x,y) == Color.WHITE) {
                    bitmap.setPixel(x,y, Color.TRANSPARENT)
                }
            }
        }

    }
}