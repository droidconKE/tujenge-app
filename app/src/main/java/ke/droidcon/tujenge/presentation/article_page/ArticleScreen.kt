package ke.droidcon.tujenge.presentation.article_page

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleScreen(){
    Scaffold(
        topBar = { TopAppBar(
            title = { Text("Tujenge DroidCon News", color = Color.White)},
            modifier = Modifier.background(Color(0xff0f9d58))
        )},
        content = { MyContent() }
    )

}

@Composable
fun MyContent(){

    val articleUrl = "https://www.geeksforgeeks.org"


    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            loadUrl(articleUrl)
        }
    }, update = {
        it.loadUrl(articleUrl)
    })
}