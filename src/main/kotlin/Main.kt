import gui.JFrameImage
import open.OpenImage
import java.awt.Color

fun main(){
    val imageOriginal = OpenImage.openImage()
    val auxOriginal = imageOriginal?.let { JFrameImage(it) }
    val auxBuffer = imageOriginal?.let { OpenImage.toBufferedImage(it) }
    if (imageOriginal != null && auxBuffer != null) {
        var rgb: Int
        var auxColor: Color
        var r: Int
        var g: Int
        var b: Int
        var p: Int
        for(x in 0 until imageOriginal.getWidth(null)){
            for(y in 0 until imageOriginal.getHeight(null)){
                rgb = auxBuffer.getRGB(x, y)
                auxColor = Color(rgb)
                r = auxColor.red
                g = auxColor.green
                b = auxColor.blue
                p = (r+g+b)/3
                auxColor = Color(p, p, p)
                auxBuffer.setRGB(x, y, auxColor.rgb)
            }
        }
    }
    val imageResult = auxBuffer?.let { OpenImage.toImage(it) }
    val auxResult = imageResult?.let { JFrameImage(it) }
}