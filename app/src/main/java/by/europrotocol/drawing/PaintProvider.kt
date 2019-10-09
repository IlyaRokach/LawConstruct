package by.europrotocol.drawing

import android.graphics.Color
import android.graphics.Paint

class PaintProvider {
    companion object {
        val textPaint = Paint().apply {
            color = Color.BLACK
            textSize = 12f
            isFakeBoldText = true
        }
        val linePaint = Paint().apply {
            color = Color.BLACK
            strokeWidth = 2f
        }
    }
}