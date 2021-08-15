package com.example.moviesapp.data.datamodels

import java.io.Serializable

data class Movie(
        var status:String,
        var copyright:String,
        var num_results:Int,
        var results: List<results>

        ): Serializable
data class results(
        var display_title:String,
        var mpaa_rating:String,
        var byline:String,
        var headline:String,
        var publication_date:String,
        var opening_date:String,
        var summary_short:String,
        var link:link,
        var multimedia:multimedia,

) : Serializable

data class info(
        var title:String,
        var value:String,
): Serializable

data class link(
        var type:String,
        var url:String,
        var suggested_link_text:String,
): Serializable
data class multimedia(
        var type:String,
        var src:String,
        var height:Int,
        var width:Int,
): Serializable