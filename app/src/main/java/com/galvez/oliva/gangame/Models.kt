package com.galvez.oliva.gangame

import java.text.Format

/**
 * Created by Oliva on 18/06/2018.
 */

object PriceFormatted {
    val FORMAT_PRICE = "$%.2f"

    fun priceFormatted (price: Float) = String.format(FORMAT_PRICE, price)
}

/*Definir los dos modelos de datos*/

data class Deal (var title:String,
                 var salePrice:Float,
                 var normalPrice:Float,
                 var metacriticScore:Int,
                 var steamRating: Int,
                 var thumb:String){

    val salePriceFormatted: String
        get() = PriceFormatted.priceFormatted(salePrice)

    val normalPriceFormatted: String
        get() = PriceFormatted.priceFormatted(normalPrice)
}

data class TopGame (var title: String,
                    var owners:Int,
                    var steamRating: Int,
                    var publisher: String,
                    var price: Float,
                    var position: Int,
                    var thumb: String){

    val priceFormatted: String
        get() = PriceFormatted.priceFormatted(price)
}