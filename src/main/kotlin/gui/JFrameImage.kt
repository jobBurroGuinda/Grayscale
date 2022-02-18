package gui

import java.awt.Image
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JLabel

class JFrameImage() : JFrame() {

    private val label: JLabel = JLabel()


    constructor(imageOriginal:Image):this(){
        label.icon = ImageIcon(imageOriginal)
        setSize(imageOriginal.getWidth(null), imageOriginal.getHeight(null))
    }

    init {
        //setSize(700,600)
        add(label)
        isVisible = true
        setLocationRelativeTo(null)
    }

}