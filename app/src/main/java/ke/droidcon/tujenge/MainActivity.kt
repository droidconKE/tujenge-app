package ke.droidcon.tujenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


        }
    }
}

@Composable
fun TujengeApp(
    title: String,
    description: String,
    modifier: Modifier = Modifier
){
    Column (){
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = modifier
                .padding(16.dp)
        )

        Text(
            text = description,
            fontSize = 16.sp,
            modifier = modifier
                .padding(16.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun TujengePreview(){
    TujengeApp(
        title = "Tujenge App",
        description = "Welcome to droidconKe23"
    )
}