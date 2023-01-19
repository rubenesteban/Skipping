package com.example.skipping

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.skipping.ui.theme.SkippingTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SkippingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AlignYourBodyRow()
                }
            }
        }
    }
}

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(item.drawable, item.text)
        }
    }
}

@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(333.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(text)
        )
    }
}

private  val alignYourBodyData = listOf(
    R.drawable.beisbol to R.string.lesve,
    R.drawable.beisbol to R.string.lesve1,
    R.drawable.beisbol to R.string.lesve2,
    R.drawable.beisbol to R.string.lesve3,
    R.drawable.beisbol to R.string.lesve4,
    R.drawable.beisbol to R.string.lesve5,
    R.drawable.beisbol to R.string.lesve,
    R.drawable.beisbol to R.string.lesve1,
    R.drawable.beisbol to R.string.lesve2,
    R.drawable.beisbol to R.string.lesve3,
    R.drawable.beisbol to R.string.lesve4,
    R.drawable.beisbol to R.string.lesve5,
    R.drawable.beisbol to R.string.lesve,
    R.drawable.beisbol to R.string.lesve1,
    R.drawable.beisbol to R.string.lesve2,
    R.drawable.beisbol to R.string.lesve3,
    R.drawable.beisbol to R.string.lesve4,
    R.drawable.beisbol to R.string.lesve5
).map { DrawableStringPair(it.first, it.second)}

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SkippingTheme {
        AlignYourBodyRow()
    }
}