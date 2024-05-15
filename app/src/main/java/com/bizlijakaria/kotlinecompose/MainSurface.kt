package com.bizlijakaria.kotlinecompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.runtime.*

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bizlijakaria.kotlinecompose.ui.ModelData
import com.bizlijakaria.kotlinecompose.ui.getAllData


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp()
{
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {


           facebookHeadingEliment()
            LazyRow()
            LazyCloumn()

        }


    }



}

@Composable
fun LazyRow()
{
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(210.dp)
    ) {
        val mylist= getAllData()
        itemsIndexed(mylist, itemContent = {index, item ->
            LazyRowItem(item = item)
        })



    }
}

@Composable
fun LazyRowItem(item:ModelData)
{
    Row() {
        Image(painter = painterResource(id =item.Image),
            contentDescription ="family",
            modifier = Modifier
                .size(120.dp, 200.dp)
                .clip(RoundedCornerShape(20.dp))
                .border(width = 2.dp, Color.Gray, shape = RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop
            )
    }
    Box(modifier = Modifier.width(5.dp))

}


@Composable
fun LazyCloumn()
{
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()

            .offset(x = 5.dp, y = 0.dp)
    ) {
        val mylist= getAllData()
        itemsIndexed(mylist, itemContent = {index, item ->
            LazyClmItem(item = item)
        })



    }
}

@Composable
fun LazyClmItem(item:ModelData)
{

       Column() {
           Row {
               Image(painter = painterResource(id =item.Image),
                   contentDescription ="family",
                   modifier = Modifier
                       .size(60.dp)
                       .clip(RoundedCornerShape(20.dp))
                       .border(width = 2.dp, Color.Gray, shape = RoundedCornerShape(20.dp)),
                   contentScale = ContentScale.Crop
               )

              Column {
                  Text(text = "${item.name}",
                      modifier = Modifier.offset(x = 12.dp, y = 0.dp),
                      color = Color.Black

                  )
                  Box(modifier = Modifier.height(5.dp))

                  Text(text = "${item.time}",
                      modifier = Modifier.offset(x = 12.dp, y = 0.dp),
                      color = Color.Black

                  )


              }




           }

           Box(modifier = Modifier.height(10.dp))

           Image(painter = painterResource(id = item.Image),
               contentDescription ="family",
               modifier = Modifier
                   .size(400.dp, 380.dp)
                   .clip(RoundedCornerShape(20.dp)),
               contentScale = ContentScale.FillWidth
           )
           
           Row(
               Modifier.padding(10.dp)
           ) {
               val (isClicked, setIsClicked) = remember { mutableStateOf(false) }

               // Determine which icon to display based on the click state
               val icon =
                 if (isClicked) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder


               // Determine the icon color based on the click state
               val iconColor =
                 if (isClicked) Color.Red else Color.Black




             IconButton(onClick = { setIsClicked(!isClicked)}) {
              Icon(icon, contentDescription ="favorit",tint=iconColor)

             }

               Box(modifier = Modifier.weight(1f))

               IconButton(onClick = { /*TODO*/ }) {
                   Icon(Icons.Filled.Send, contentDescription ="send" , tint = Color.Black)

               }
               Box(modifier = Modifier.weight(1f))

               IconButton(onClick = { /*TODO*/ }) {
                   Icon(Icons.Filled.Share, contentDescription ="favorit", tint = Color.Black )

               }


           }
       }

    Box(modifier = Modifier.height(20.dp))

}

@Composable
fun facebookHeadingEliment()
{
    Column {
        Row(modifier = Modifier
            .padding(12.dp)
            .height(30.dp)
            ) {
            Text(text = "facebook",
                style = TextStyle(
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 25.sp,
                    color = Color.Black

                )
                )

                Box(modifier = Modifier.weight(1f))
                IconButton(onClick = { /*TODO*/ }) {

                    Icon(Icons.Filled.AddCircle, contentDescription ="add", tint = Color.Black )

                }
                        IconButton(onClick = { /*TODO*/ }) {

                    Icon(Icons.Filled.Search, contentDescription ="search" , tint = Color.Black)

                }
           Image(painter = painterResource(id = R.drawable.messenger), contentDescription ="messenger",
               modifier = Modifier.size(25.dp,25.dp))



        }
        Row(modifier = Modifier
            .padding(10.dp)
            .height(30.dp)) {
            IconButton(onClick = { /*TODO*/ }) {

                Icon(Icons.Filled.Home, contentDescription ="add", tint = Color.Black, modifier =Modifier.size(40.dp,35.dp)  )

            }
            Box(modifier = Modifier.weight(1f))
            IconButton(onClick = { /*TODO*/ }) {

                Icon(painter = painterResource(id = R.drawable.video), contentDescription ="add", tint = Color.Black, modifier =Modifier.size(40.dp,35.dp)  )

            }
            Box(modifier = Modifier.weight(1f))
            IconButton(onClick = { /*TODO*/ }) {

                Icon(Icons.Filled.Person, contentDescription ="add", tint = Color.Black, modifier =Modifier.size(40.dp,35.dp)  )

            }
            Box(modifier = Modifier.weight(1f))
            IconButton(onClick = { /*TODO*/ }) {

                Icon(Icons.Filled.Notifications, contentDescription ="add", tint = Color.Black, modifier =Modifier.size(40.dp,35.dp)  )

            }


        }

       Row(modifier = Modifier
           .padding(10.dp)
           .height(60.dp)) {
          var whatsyourmind= rememberSaveable {
              mutableStateOf("")
          }

           Image(painter = painterResource(id = R.drawable.w1), contentDescription ="small profile",
               modifier = Modifier
                   .size(60.dp, 60.dp)
                   .clip(CircleShape),
               contentScale = ContentScale.Crop

               )
          Box(modifier = Modifier.weight(1f))


           OutlinedTextField(value = whatsyourmind.value, onValueChange = {
                   whatsyourmind.value = it
               }, label = {
                   Text(text = "What's your mind", fontWeight = FontWeight.Bold)
               }, placeholder = {
                   Text(text = "Enter your password", fontWeight = FontWeight.Bold)
               }, modifier = Modifier.size(260.dp,60.dp), shape = RoundedCornerShape(25.dp), textStyle = LocalTextStyle.current)
           Box(modifier = Modifier.weight(1f))

           Image(painter = painterResource(id = R.drawable.image_gallery), contentDescription ="messenger",
               modifier = Modifier.size(40.dp,50.dp))

           }

       }


    }



