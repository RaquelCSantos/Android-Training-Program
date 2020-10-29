package pt.atp.ex3_aula2

import android.app.AlertDialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.buttonAlert).setOnClickListener {
            val builder = AlertDialog.Builder(this)
            //set title for alert dialog
            builder.setTitle(R.string.dialogTitle)
            //set message for alert dialog
            builder.setMessage(R.string.dialogMessage)

            //performing positive action
            builder.setPositiveButton("Ok"){dialogInterface, which ->
                Toast.makeText(applicationContext,"clicked ok",Toast.LENGTH_LONG).show()
            }
            //performing cancel action
            builder.setNegativeButton("Cancel"){dialogInterface , which ->
                Toast.makeText(applicationContext,"clicked cancel\n operation cancel",Toast.LENGTH_LONG).show()
            }
            // Create the AlertDialog
            val alertDialog: AlertDialog = builder.create()
            // Set other dialog properties
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
        findViewById<Button>(R.id.buttonSnackBar).setOnClickListener {
            val snackBar = Snackbar.make(
                it, R.string.dialogMessage,
                Snackbar.LENGTH_LONG
            )
            snackBar.setAction(R.string.tks, View.OnClickListener() {

                    Log.e("TAG", "Done")
                })
            snackBar.setActionTextColor(Color.CYAN)
            val snackBarView = snackBar.view
            snackBarView.setBackgroundColor(Color.DKGRAY)
            val textView = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
            textView.setTextColor(Color.WHITE)
            snackBar.show()
        }
    }

}