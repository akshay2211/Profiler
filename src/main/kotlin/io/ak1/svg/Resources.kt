package io.ak1.svg

import io.ak1.fontImport


fun textContainer(content: () -> String) =
    "<g fill=\"#ffffff\" fill-opacity=\"1\" stroke=\"none\" xml:space=\"preserve\" text-anchor=\"middle\" font-family=\"Poppins\" font-size=\"18\" font-weight=\"100\">${content.invoke()}</g>"

fun text(percent: Int, text: String, fontSize: Int = 18) =
    "<text x=\"67.5%\" y=\"$percent%\" font-size=\"$fontSize\">$text</text>"

fun imageContainer(content: () -> String): String {
    return "<g class=\"icons_container\" fill=\"#00b0ff\" stroke=\"#00b0ff\" fill-opacity=\"1\" xml:space=\"preserve\" stroke-width=\"0\"" + " stroke-linecap=\"round\"" + " stroke-linejoin=\"round\" text-anchor=\"middle\">${content.invoke()}</g>"
}

fun imageBody(x: Double, link: String, content: () -> String) =
    "<svg x=\"$x%\" y=\"65%\" width=\"32\" height=\"32\" stroke-width=\"1\" viewBox=\"0 0 24 24\" fill=\"none\">${content.invoke()}</svg>" + "<a xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns=\"http://www.w3.org/2000/svg\" id=\"anchor\"" + " xlink:href=\"$link\" target=\"_top\">" + "<rect x=\"$x%\" y=\"65%\" width=\"36\" height=\"36\" fill-opacity=\"0\"/></a>"

fun background(color: String = "#00000000") =
    "<g fill=\"$color\" fill-opacity=\"1\" stroke=\"none\" transform=\"matrix(1,0,0,1,0,0)\"><path vector-effect=\"none\" fill-rule=\"evenodd\" d=\"M0,0 L1200,0 L1200,400 L0,400 L0,0\"/></g>"

fun svgDesc(name: String = "Akshay Sharma") = "<desc>$name</desc>"

fun customImage(data: String) =
    "<clipPath id=\"clipCircle\">   <circle r=\"15%\" cx=\"22.5%\" cy=\"50%\"/></clipPath><image x=\"10%\" y=\"12.5%\" width=\"25%\" height=\"75%\" href=\"$data\" clip-path=\"url(#clipCircle)\"/>"

fun clickableArea(link: String) =
    "<a xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns=\"http://www.w3.org/2000/svg\" id=\"anchor\" xlink:href=\"$link\" target=\"_top\"><rect x=\"10%\" y=\"12.5%\" width=\"25%\" height=\"75%\" fill-opacity=\"0\"/></a>"


fun body(content: () -> String) =
    "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"1200\" height=\"400\" version=\"1.2\" baseProfile=\"tiny\">$fontImport${
        background("#0d1117")
    }${content.invoke()}</svg>"
