package com.dev_marinov.calculationkotlin

import android.app.AlertDialog
import android.content.DialogInterface
import android.app.ActivityOptions
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide() // скрыть экшенбар
        setWindow()
        hideSystemUI() // сетинг для фул скрин по соответствующему сдк

        // переход во fragmentCalculator
        val fragmentCalculator = FragmentCalculator()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.ll_frag_calculation, fragmentCalculator, "ll_frag_calculation")
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


    fun setWindow() {
        val window = window
        // FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS Флаг, указывающий, что это Окно отвечает за отрисовку фона для системных полос.
        // Если установлено, системные панели отображаются с прозрачным фоном, а соответствующие области в этом окне заполняются
        // цветами, указанными в Window#getStatusBarColor()и Window#getNavigationBarColor().
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent); // прозрачный статус бар
        window.navigationBarColor  = ContextCompat.getColor(this, android.R.color.black); // черный бар навигации
    }

    private fun hideSystemUI() {
        // если сдк устройства больше или равно сдк приложения
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
            window.insetsController?.let {
                it.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                it.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else { // иначе
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    //or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    //or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    // Hide the nav bar and status bar
                    //or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    //or View.SYSTEM_UI_FLAG_FULLSCREEN
                    )
        }
    }
}