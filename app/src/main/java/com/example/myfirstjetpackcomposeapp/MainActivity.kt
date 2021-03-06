package com.example.myfirstjetpackcomposeapp

//import java.lang.reflect.Modifier
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstjetpackcomposeapp.alertdialog.listForCard1
import com.example.myfirstjetpackcomposeapp.alertdialog.listForCard2
import com.example.myfirstjetpackcomposeapp.ui.theme.listOfData

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Surface(color = MaterialTheme.colors.background){
//                call the method for UI
//                LoadUi()
                AlertDialogComponent()
            }



//            MyFirstJetPackComposeAppTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.background) {
//                    Greeting("Android")
////                }
//            }
        }
    }
}


@Composable
fun AlertDialogComponent(){

    val isDialogOpen = remember{ mutableStateOf(false)}
    val context = LocalContext.current

    if (!isDialogOpen.value){
        AlertDialog(onDismissRequest = {isDialogOpen.value = true },
            title = { Text(text ="Some thoughts about the Marvel Cinematic Universe")},

            text = {
                   Row (modifier = Modifier.padding(5.dp).horizontalScroll(rememberScrollState())){

                       Card(modifier = Modifier.padding(10.dp).fillMaxWidth().shadow(2.dp), backgroundColor = Color(0xFFe57373)) {

                          Column(modifier = Modifier.padding(5.dp)) {
                              listForCard1().forEach {
                                  Row(Modifier.width(230.dp)) {
                                      Image(painter = painterResource(id = R.drawable.ic_baseline_warning_24), contentDescription = "warning image")
                                      Text(text = it, color= Color.White)


                                  }
                              }
                          }

                       }

                       Card(modifier = Modifier.padding(10.dp).fillMaxWidth().shadow(2.dp), backgroundColor = Color(0xFFe57373)) {

                           Column(modifier = Modifier.padding(5.dp)) {
                               listForCard2().forEach {
                                   Row(Modifier.width(230.dp)) {
                                       Image(painter = painterResource(id = R.drawable.ic_baseline_warning_24), contentDescription = "warning image")
                                       Text(text = it, color= Color.White)


                                   }
                               }
                           }

                       }

                   }
            },

            confirmButton = {
                Button(onClick = {isDialogOpen.value = true
                Toast.makeText(context, "Yep! Tony Stark is the Gratest!", Toast.LENGTH_LONG).show()
                }) {
                    Text(text ="I Agree")

                }
            },
            dismissButton = {
                TextButton(onClick = { isDialogOpen.value = true
                    Toast.makeText(context, "I'm i right or I'm i right lol!", Toast.LENGTH_LONG).show()}) {
                    Text(text = "i don't agree")
                }
            }

        )
    }

}







//@Preview
//@Composable
//fun LoadUi(){
//
//    Column (modifier = Modifier.padding(5.dp)){
//
//        Column(modifier = Modifier
//            .padding(5.dp)
//            .verticalScroll(rememberScrollState())) {
//
//            listOfData().forEach{ userData->
//
//                loadMemoryCard(memoryData = userData)
//            }
//
//
//        }



//        Card(modifier = Modifier.padding(10.dp).fillMaxWidth().shadow(5.dp)) {
//
//            Image(painter = painterResource(id = R.drawable.ic_eye), contentDescription = "Lion" )
//
//        }
//        Text(text = "Thinker app logo",
//            modifier = Modifier.padding(5.dp),
//            color = Color.Black,
//            fontSize = 20.sp
//
//        )
//
//
//        Card(modifier = Modifier.padding(10.dp).fillMaxWidth().shadow(5.dp)) {
//
//            Image(painter = painterResource(id = R.drawable.ic_git_branch), contentDescription = "Gmail icon" )
//        }
//        Text(text = "This is git branch icon",
//            modifier = Modifier.padding(5.dp),
//            color = Color.Black,
//            fontSize = 20.sp
//
//        )
//
//        Card(modifier = Modifier.padding(10.dp).fillMaxWidth().shadow(5.dp)) {
//
//            Image(painter = painterResource(id = R.drawable.ic_twitter), contentDescription = "Lion 2" )
//
//
//        }
//        Text(text = "This is twitter icon",
//            modifier = Modifier.padding(5.dp),
//            color = Color.Black,
//            fontSize = 20.sp
//
//        )


//    }
//}







//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MyFirstJetPackComposeAppTheme {
//        Greeting("Android")
//    }
//}