package com.kleymenova.dialogsapp

import android.app.Activity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kleymenova.dialogsapp.ui.theme.DialogsAppTheme

@Composable
fun bindContentComposable() {
    DialogsAppTheme {
        val openAlert = remember { mutableStateOf(false) }
        val openBottomSheet = remember { mutableStateOf(false) }
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Buttons(
                onAlertSelected = { openAlert.value = true },
                onBottomSheetSelected = { openBottomSheet.value = true }
            )

            if (openAlert.value) {
                ShowAlert(
                    onDismiss = { openAlert.value = false },
                    onConfirm = { openAlert.value = false }
                )
            }

            if (openBottomSheet.value) {
                ShowBottomSheet {
                    openBottomSheet.value = false
                }
            }
        }
    }
}

@Composable
fun Buttons(onAlertSelected: () -> Unit, onBottomSheetSelected: () -> Unit) {
    Column(
        modifier = Modifier
            .wrapContentWidth()
            .padding(bottom = 16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { onAlertSelected() }
        ) {
            Text(
                text = "Alert"
            )
        }
        Button(
            onClick = { onBottomSheetSelected() }
        ) {
            Text(
                text = "BottomSheet"
            )
        }
    }
}

@Composable
fun ShowAlert(onDismiss: () -> Unit, onConfirm: () -> Unit) {
    AlertDialog(
        title = {
            Text(
                text = "Alert Title"
            )
        },
        text = {
            Text(
                text = "Alert Message"
            )
        },
        confirmButton = {
            Button(
                onClick = { onConfirm() }
            ) {
                Text(
                    text = "OK"
                )
            }
        },
        dismissButton = {
            Button(
                onClick = { onDismiss() }
            ) {
                Text(
                    text = "Cancel"
                )
            }
        },
        onDismissRequest = { onDismiss() }
    )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ShowBottomSheet(onDismiss: () -> Unit) {
    ModalBottomSheet(onDismissRequest = { onDismiss() }) {}
}