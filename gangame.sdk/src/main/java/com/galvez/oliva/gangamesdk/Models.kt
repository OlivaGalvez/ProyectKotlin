package com.galvez.oliva.gangamesdk

import com.google.gson.annotations.SerializedName

/**
 * Created by Oliva on 21/06/2018.
 */

data class Deal (var title: String,
                 var salePrice: Float,
                 var normalPrice: Float,
                 var metacriticScore: Int,
                 @SerializedName("steamRatingPercent") var steamRating: Int,
                 var thumb: String)

data class TopGame (@SerializedName("name") var title: String,
                    var publisher: String,
                    var steamRating: Int,
                    var owners: Int,
                    var price: Float,
                    var thumb: String)