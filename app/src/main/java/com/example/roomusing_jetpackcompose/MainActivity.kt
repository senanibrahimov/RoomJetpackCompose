package com.example.roomusing_jetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.roomusing_jetpackcompose.ui.theme.Roomusing_JetpackComposeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Roomusing_JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Page()
                }
            }
        }
    }
}

@Composable
fun Page() {
val context= LocalContext.current
    val db=RoomDatabase.acsessdatabase(context)!!

    LaunchedEffect(key1 = true ){
       counter(db)
    }


}
fun allperson(db:RoomDatabase){

    CoroutineScope(Dispatchers.Main).launch {
        var list=  db.kisilerdao().randomandlimit()

        for (i in list){
            Log.e("id","${i.personID}")
            Log.e("name",i.personName)
            Log.e("phone",i.personPHONE)

        }
    }
}

fun save(db:RoomDatabase){

    CoroutineScope(Dispatchers.Main).launch{

        db.kisilerdao().savepeople(People(0,"Nicat","0559008976"))

    }

}

fun ranandlim(db:RoomDatabase){
    CoroutineScope(Dispatchers.Main).launch{
      val list=  db.kisilerdao().randomandlimit()

        for (i in list){

            Log.e("message","${i.personID}  ${i.personName} ${i.personPHONE}")
        }

    }
}

fun search(db:RoomDatabase){
    CoroutineScope(Dispatchers.Main).launch{
        val list=  db.kisilerdao().search("s")

        for (i in list){

            Log.e("my","${i.personID}  ${i.personName} ${i.personPHONE}")
        }

    }
}
fun valueNAme(db:RoomDatabase){
    CoroutineScope(Dispatchers.Main).launch{
        val i=  db.kisilerdao().valuename(3)

            Log.e("my","${i.personID}  ${i.personName} ${i.personPHONE}")


    }
}
fun updateData(db:RoomDatabase){
    CoroutineScope(Dispatchers.Main).launch{

    db.kisilerdao().updatePeople(People(2,"ttttttt","tttttttttttttttt"))
}
    }

fun delete(db:RoomDatabase){

    CoroutineScope(Dispatchers.Main).launch{
        db.kisilerdao().deletedata(People(2,"",""))

    }


}
fun counter(db:RoomDatabase){

    CoroutineScope(Dispatchers.Main).launch{
     val list=   db.kisilerdao().counter()

        Log.e("cout","$list")

       /* for (i in list){

            Log.e("my","${i.personID}  ${i.personName} ${i.personPHONE}")
        }*/
    }


}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Roomusing_JetpackComposeTheme {
       Page()
    }
}