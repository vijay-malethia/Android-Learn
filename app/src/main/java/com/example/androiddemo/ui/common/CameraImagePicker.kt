package com.example.androiddemo.ui.common

import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.FileProvider
import java.io.File

@Composable
fun rememberCameraImagePicker(
    onImageCaptured: (Uri) -> Unit
): () -> Unit {

    val context = LocalContext.current

    // Create temp Uri
    val imageUri = remember {
        createImageUri(context)
    }

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) { success ->
        if (success) {
            onImageCaptured(imageUri)
        }
    }

    return {
        cameraLauncher.launch(imageUri)
    }
}

private fun createImageUri(context: Context): Uri {
    val imageFile = File.createTempFile(
        "camera_image_",
        ".jpg",
        context.cacheDir
    )

    return FileProvider.getUriForFile(
        context,
        "${context.packageName}.provider",
        imageFile
    )
}
