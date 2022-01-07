package com.dev_marinov.calculationkotlin

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // полный экран
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // переход во fragmentCalculator
        val fragmentCalculator = FragmentCalculator()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(
            R.id.ll_frag_calculation,
            fragmentCalculator,
            "ll_frag_calculation"
        )
        fragmentTransaction.commit()

    }


    // метод только для myAlertDialog();
    override fun onBackPressed() {
        // как только будет ноль (последний экран) выполниться else
        if (supportFragmentManager.backStackEntryCount > 0) {
            Log.e(
                "MAIN_ACT", "getFragmentManager().getBackStackEntryCount()== "
                        + supportFragmentManager.backStackEntryCount
            )
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack() // удаление фрагментов из транзакции
            myAlertDialog() // метод реализации диалога с пользователем закрыть приложение или нет
        }
    }

    // метод реализации диалога с пользователем закрыть приложение или нет
    fun myAlertDialog() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Хотите выйти ?")
        alertDialog.setPositiveButton("Да") { arg0, arg1 -> // finish used for destroyed activity
            finish()
        }
        alertDialog.setNegativeButton(
            "Нет"
        ) { arg0, arg1 ->
            // Nothing will be happened when clicked on no button
            // of Dialog
        }
        alertDialog.show()
    }

}