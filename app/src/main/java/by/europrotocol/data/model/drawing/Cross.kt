package by.europrotocol.data.model.drawing

class Cross(
    val start: Point, // top left point of cross
    val size: Int = 10
) {
    val end = Point(start.x + size, start.y + size)
}
