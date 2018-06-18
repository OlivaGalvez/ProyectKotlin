package com.galvez.oliva.gangame

/**
 * Created by Oliva on 18/06/2018.
 */

/*Definir los dos modelos de datos*/

data class Deal (var title:String,
                 var salePrice:Float,
                 var normalPrice:Float,
                 var metacriticScore:Int,
                 var steamRating: Int,
                 var thumb:String)

data class TopGame (var title: String,
                    var owners:String,
                    var steamRating: Int,
                    var publisher: String,
                    var price: Float,
                    var position: Int,
                    var thumb: String)