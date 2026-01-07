package com.example.androiddemo.ui.screen.profile

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.androiddemo.ui.common.rememberCameraImagePicker
import com.example.androiddemo.ui.common.rememberImagePicker
import com.example.androiddemo.ui.theme.BgGradient


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileView() {

    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    var showBottomSheet by remember { mutableStateOf(false) }

    val openCameraPicker = rememberCameraImagePicker {
        selectedImageUri = it
        showBottomSheet = false
    }

    val openGalleryPicker = rememberImagePicker {
        selectedImageUri = it
        showBottomSheet = false
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .size(150.dp)
                .background(
                    brush = BgGradient,
                    shape = CircleShape
                )
                .clickable {
                    showBottomSheet = true
                },
            contentAlignment = Alignment.Center
        ) {

            selectedImageUri?.let { uri ->
                Image(
                    painter = rememberAsyncImagePainter(uri),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }

    /* ------------------ Bottom Sheet ------------------ */

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                BottomSheetItem(
                    text = "Camera",
                    onClick = { openCameraPicker() }
                )

                BottomSheetItem(
                    text = "Gallery",
                    onClick = { openGalleryPicker() }
                )

                Spacer(Modifier.height(20.dp))
            }
        }
    }
}
@Composable
fun BottomSheetItem(
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 14.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = text,
            fontSize = 16.sp
        )
    }
}
