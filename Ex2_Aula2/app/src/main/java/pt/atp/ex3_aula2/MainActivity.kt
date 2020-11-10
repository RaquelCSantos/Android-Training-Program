package pt.atp.ex3_aula2

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

private const val REQUEST_IMAGE_CAPTURE = 100

class MainActivity : AppCompatActivity() {

    private lateinit var timer: CountDownTimer
    private var untilFinished = 10000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonOpenCamera).setOnClickListener {
            openNativeCamera()
        }

        findViewById<Button>(R.id.buttonOpenDetails).setOnClickListener {
            openDetailsActivity()
        }

        findViewById<Button>(R.id.buttonAlert).setOnClickListener {
            showAppDialog()
        }
        findViewById<Button>(R.id.buttonSnackBar).setOnClickListener {
            showSnackBar()
        }

    }

    override fun onResume() {
        super.onResume()
        startCountDownTimer(untilFinished)
    }

    override fun onPause() {
        super.onPause()
        timer.cancel()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            findViewById<ImageView>(R.id.imageView).setImageBitmap(imageBitmap)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun openNativeCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
        //startActivity(intent)
    }

    private fun openDetailsActivity() {
        val intent = Intent(this, DetailsActivity::class.java)
        startActivity(intent)
    }

    private fun showAppDialog() {
        val builder = AlertDialog.Builder(this)
        //set title for alert dialog
        builder.setTitle(R.string.dialogTitle)
        //set message for alert dialog
        builder.setMessage(R.string.dialogMessage)

        //performing positive action
        builder.setPositiveButton(R.string.positiveButton) { dialogInterface, which ->
            Toast.makeText(this@MainActivity, R.string.selectedOk, Toast.LENGTH_LONG).show()
        }
        //performing cancel action
        builder.setNegativeButton(R.string.negativeButton) { dialogInterface, which ->
            Toast.makeText(this@MainActivity, R.string.selectedCancel, Toast.LENGTH_LONG).show()
        }
        // Create the AlertDialog
        //val alertDialog: AlertDialog = builder.create()
        // Set other dialog properties
        //alertDialog.setCancelable(false)
        //alertDialog.show()
        builder.create().show()
    }

    private fun showSnackBar(){
        findViewById<Button>(R.id.buttonSnackBar).setOnClickListener {
            val snackBar = Snackbar.make(
                it, R.string.dialogMessage,
                Snackbar.LENGTH_LONG
            )
            snackBar.setAction(R.string.tks, View.OnClickListener() {
                Toast.makeText(this@MainActivity, R.string.selectedTks, Toast.LENGTH_LONG).show()

            })
            snackBar.setActionTextColor(Color.CYAN)
            val snackBarView = snackBar.view
            snackBarView.setBackgroundColor(Color.DKGRAY)
            val textView = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
            textView.setTextColor(Color.WHITE)
            snackBar.show()
        }
    }

    private fun startCountDownTimer(time: Long) {
        timer = object : CountDownTimer(time, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                untilFinished = millisUntilFinished
                findViewById<TextView>(R.id.countDown).text = "Seconds remaining: ${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                findViewById<TextView>(R.id.countDown).text = "Done!"
            }
        }
        timer.start()
    }

}