package io.ak1.svg

import io.ak1.svgImage

fun generate(
    title: String, desc1: String?, desc2: String?, image: String?, url: String?, icons: HashMap<String, String?>
) = body {
    val newImage = if (image !== null) customImage(image) else svgImage
    svgDesc() + newImage + url?.let { clickableArea(it) } + textContainer {
        var percent = 50
        text(40, title, 48) + desc1?.let {
            text(percent, it).also {
                percent += 5
            }
        } + desc2?.let { text(percent, desc2) }
    } + imageContainer {
        iconPresenter(icons)
    }
}