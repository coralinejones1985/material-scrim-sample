package com.kleymenova.dialogsapp

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.button.MaterialButton

fun AppCompatActivity.bindContentDefault() {
    setContentView(R.layout.ac_main)
    findViewById<MaterialButton>(R.id.btnAlert).setOnClickListener {
        showAlert()
    }
    findViewById<MaterialButton>(R.id.btnBottomSheet).setOnClickListener {
        showBottomSheet()
    }
}

private fun AppCompatActivity.showAlert() {
    AlertDialog.Builder(this)
        .setTitle("Alert Title")
        .setMessage("Alert Message")
        .setPositiveButton("OK") { _, _ -> }
        .setNegativeButton("Cancel") { _, _ -> }
        .show()
}

private fun AppCompatActivity.showBottomSheet() {
    BottomSheetDialogFragment(R.layout.fr_bottom_sheet)
        .show(supportFragmentManager, "BottomSheetDialogFragment")
}