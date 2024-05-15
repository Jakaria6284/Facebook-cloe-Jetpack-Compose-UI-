package com.bizlijakaria.kotlinecompose.ui

import com.bizlijakaria.kotlinecompose.R

data class ModelData(

    val Image:Int,
    val name:String,
    val time:String

)

fun getAllData():List<ModelData>
{
    return listOf<ModelData>(

        ModelData(R.drawable.w1,"Jakaria","2h"),
        ModelData(R.drawable.w2,"kamal","5h"),
        ModelData(R.drawable.jk1,"Ripon","3h"),
        ModelData(R.drawable.w3,"Saif","9h"),
        ModelData(R.drawable.w4,"Jamil","12h"),
        ModelData(R.drawable.w5,"Ashik","23h"),
        ModelData(R.drawable.w1,"Maruf","1d"),
        ModelData(R.drawable.w2,"Sakib","22h"),










        )
}




