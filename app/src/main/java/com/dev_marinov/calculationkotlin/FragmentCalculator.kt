package com.dev_marinov.calculationkotlin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class FragmentCalculator : Fragment() {

    var frag: View? = null
    var edt_show: EditText? = null
    var bt_0:Button? = null
    var bt_1:Button? = null
    var bt_2:Button? = null
    var bt_3:Button? = null
    var bt_4:Button? = null
    var bt_5:Button? = null
    var bt_6:Button? = null
    var bt_7:Button? = null
    var bt_8:Button? = null
    var bt_9:Button? = null
    var bt_backSpace: Button? = null
    var bt_clear: Button? = null
    var bt_persent:Button? = null
    var bt_equals:Button? = null
    var bt_division:Button? = null
    var bt_multiplication:Button? = null
    var bt_subtraction:Button? = null
    var bt_comma: Button? = null
    var bt_sum_subtraction:Button? = null
    var bt_sum:Button? = null
    var stringForEditText = ""

    //boolean flag = false;
    var flagPersent = false
    var flagSymbolMinus = 0
    var resultPersentDouble = 0.0
    private var alphaAnim_bt_0: AlphaAnimation? = null
    private  var alphaAnim_bt_1:AlphaAnimation? = null
    private  var alphaAnim_bt_2:AlphaAnimation? = null
    private  var alphaAnim_bt_3:AlphaAnimation? = null
    private  var alphaAnim_bt_4:AlphaAnimation? = null
    private  var alphaAnim_bt_5:AlphaAnimation? = null
    private var alphaAnim_bt_6: AlphaAnimation? = null
    private  var alphaAnim_bt_7:AlphaAnimation? = null
    private  var alphaAnim_bt_8:AlphaAnimation? = null
    private  var alphaAnim_bt_9:AlphaAnimation? = null
    private var alphaAnim_bt_backSpace: AlphaAnimation? = null
    private  var alphaAnim_bt_clear:AlphaAnimation? = null
    private  var alphaAnim_bt_persent:AlphaAnimation? = null
    private  var alphaAnim_bt_equals:AlphaAnimation? = null
    private  var alphaAnim_bt_division:AlphaAnimation? = null
    private var alphaAnim_bt_multiplication: AlphaAnimation? = null
    private  var alphaAnim_bt_subtraction:AlphaAnimation? = null
    private  var alphaAnim_bt_comma:AlphaAnimation? = null
    private  var alphaAnim_bt_sum_subtraction:AlphaAnimation? = null
    private  var alphaAnim_bt_sum:AlphaAnimation? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        frag = inflater.inflate(R.layout.fragment_calculator, container, false)

        animationButtons() // анимация нажатий всех кнопок

        bt_0 = frag!!.findViewById<Button>(R.id.bt_0)
        bt_1 = frag!!.findViewById<Button>(R.id.bt_1)
        bt_2 = frag!!.findViewById<Button>(R.id.bt_2)
        bt_3 = frag!!.findViewById<Button>(R.id.bt_3)
        bt_4 = frag!!.findViewById<Button>(R.id.bt_4)
        bt_5 = frag!!.findViewById<Button>(R.id.bt_5)
        bt_6 = frag!!.findViewById<Button>(R.id.bt_6)
        bt_7 = frag!!.findViewById<Button>(R.id.bt_7)
        bt_8 = frag!!.findViewById<Button>(R.id.bt_8)
        bt_9 = frag!!.findViewById<Button>(R.id.bt_9)
        edt_show = frag!!.findViewById(R.id.edt_show)
        bt_backSpace = frag!!.findViewById(R.id.bt_backSpace)
        bt_clear = frag!!.findViewById<Button>(R.id.bt_clear)
        bt_persent = frag!!.findViewById<Button>(R.id.bt_persent)
        bt_equals = frag!!.findViewById<Button>(R.id.bt_equals)
        bt_division = frag!!.findViewById<Button>(R.id.bt_division)
        bt_multiplication = frag!!.findViewById<Button>(R.id.bt_multiplication)
        bt_subtraction = frag!!.findViewById<Button>(R.id.bt_subtraction)
        bt_comma = frag!!.findViewById(R.id.bt_comma)
        bt_sum_subtraction = frag!!.findViewById<Button>(R.id.bt_sum_subtraction)
        bt_sum = frag!!.findViewById<Button>(R.id.bt_sum)

        buttonsClickNumber() // слушатели кнопок с цифрами

        buttonsClickCalculation() // слушатели кнопок с операциями

        return frag;
    }

    fun animationButtons() // анимация нажатий всех кнопок
    {
        alphaAnim_bt_0 = AlphaAnimation(0.2f, 1.0f)
        alphaAnim_bt_0!!.setDuration(500)
        alphaAnim_bt_1 = AlphaAnimation(0.2f, 1.0f)
        alphaAnim_bt_1!!.setDuration(500)
        alphaAnim_bt_2 = AlphaAnimation(0.2f, 1.0f)
        alphaAnim_bt_2!!.setDuration(500)
        alphaAnim_bt_3 = AlphaAnimation(0.2f, 1.0f)
        alphaAnim_bt_3!!.setDuration(500)
        alphaAnim_bt_4 = AlphaAnimation(0.2f, 1.0f)
        alphaAnim_bt_4!!.setDuration(500)
        alphaAnim_bt_5 = AlphaAnimation(0.2f, 1.0f)
        alphaAnim_bt_5!!.setDuration(500)
        alphaAnim_bt_6 = AlphaAnimation(0.2f, 1.0f)
        alphaAnim_bt_6!!.setDuration(500)
        alphaAnim_bt_7 = AlphaAnimation(0.2f, 1.0f)
        alphaAnim_bt_7!!.setDuration(500)
        alphaAnim_bt_8 = AlphaAnimation(0.2f, 1.0f)
        alphaAnim_bt_8!!.setDuration(500)
        alphaAnim_bt_9 = AlphaAnimation(0.2f, 1.0f)
        alphaAnim_bt_9!!.setDuration(500)
        alphaAnim_bt_backSpace = AlphaAnimation(0.2f, 1.0f)
        alphaAnim_bt_backSpace!!.setDuration(500)
        alphaAnim_bt_clear = AlphaAnimation(0.2f, 1.0f)
        alphaAnim_bt_clear!!.setDuration(500)
        alphaAnim_bt_persent = AlphaAnimation(0.2f, 1.0f)
        alphaAnim_bt_persent!!.setDuration(500)
        alphaAnim_bt_equals = AlphaAnimation(0.2f, 1.0f)
        alphaAnim_bt_equals!!.setDuration(500)
        alphaAnim_bt_division = AlphaAnimation(0.2f, 1.0f)
        alphaAnim_bt_division!!.setDuration(500)
        alphaAnim_bt_multiplication = AlphaAnimation(0.2f, 1.0f)
        alphaAnim_bt_multiplication!!.setDuration(500)
        alphaAnim_bt_subtraction = AlphaAnimation(0.2f, 1.0f)
        alphaAnim_bt_subtraction!!.setDuration(500)
        alphaAnim_bt_comma = AlphaAnimation(0.2f, 1.0f)
        alphaAnim_bt_comma!!.setDuration(500)
        alphaAnim_bt_sum_subtraction = AlphaAnimation(0.2f, 1.0f)
        alphaAnim_bt_sum_subtraction!!.setDuration(500)
        alphaAnim_bt_sum = AlphaAnimation(0.2f, 1.0f)
        alphaAnim_bt_sum!!.setDuration(500)
    }


    fun buttonsClickNumber() // слушатели кнопок с  цифрами
    {
        bt_0!!.setOnClickListener {
            bt_0!!.alpha = 1f // анимания кнопки затухание
            bt_0!!.startAnimation(alphaAnim_bt_0)
            stringForEditText += "0"
            edt_show!!.setText(stringForEditText)
        }
        bt_1!!.setOnClickListener(View.OnClickListener {
            bt_1!!.setAlpha(1f) // анимания кнопки затухание
            bt_1!!.startAnimation(alphaAnim_bt_1)
            stringForEditText += "1"
            edt_show!!.setText(stringForEditText)
        })
        bt_2!!.setOnClickListener(View.OnClickListener {
            bt_2!!.setAlpha(1f) // анимания кнопки затухание
            bt_2!!.startAnimation(alphaAnim_bt_2)
            stringForEditText += "2"
            edt_show!!.setText(stringForEditText)
        })
        bt_3!!.setOnClickListener(View.OnClickListener {
            bt_3!!.setAlpha(1f) // анимания кнопки затухание
            bt_3!!.startAnimation(alphaAnim_bt_3)
            stringForEditText += "3"
            edt_show!!.setText(stringForEditText)
        })
        bt_4!!.setOnClickListener(View.OnClickListener {
            bt_4!!.setAlpha(1f) // анимания кнопки затухание
            bt_4!!.startAnimation(alphaAnim_bt_4)
            stringForEditText += "4"
            edt_show!!.setText(stringForEditText)
        })
        bt_5!!.setOnClickListener(View.OnClickListener {
            bt_5!!.setAlpha(1f) // анимания кнопки затухание
            bt_5!!.startAnimation(alphaAnim_bt_5)
            stringForEditText += "5"
            edt_show!!.setText(stringForEditText)
        })
        bt_6!!.setOnClickListener(View.OnClickListener {
            bt_6!!.setAlpha(1f) // анимания кнопки затухание
            bt_6!!.startAnimation(alphaAnim_bt_6)
            stringForEditText += "6"
            edt_show!!.setText(stringForEditText)
        })
        bt_7!!.setOnClickListener(View.OnClickListener {
            bt_7!!.setAlpha(1f) // анимания кнопки затухание
            bt_7!!.startAnimation(alphaAnim_bt_7)
            stringForEditText += "7"
            edt_show!!.setText(stringForEditText)
        })
        bt_8!!.setOnClickListener(View.OnClickListener {
            bt_8!!.setAlpha(1f) // анимания кнопки затухание
            bt_8!!.startAnimation(alphaAnim_bt_8)
            stringForEditText += "8"
            edt_show!!.setText(stringForEditText)
        })
        bt_9!!.setOnClickListener(View.OnClickListener {
            bt_9!!.setAlpha(1f) // анимания кнопки затухание
            bt_9!!.startAnimation(alphaAnim_bt_9)
            stringForEditText += "9"
            edt_show!!.setText(stringForEditText)
        })
    }

    fun buttonsClickCalculation() // слушатели кнопок с операциями
    {
        bt_backSpace!!.setOnClickListener {
            bt_backSpace!!.alpha = 1f // анимания кнопки затухание
            bt_backSpace!!.startAnimation(alphaAnim_bt_backSpace)
            // Метод indexOf() ищет в строке заданный символ или строку, и их возвращает индекс (т. е. ...
            // возвращает индекс, под которым символ или строка первый раз появляется в строке; возвращает
            // (-1) если символ или строка не найдены.
            if (stringForEditText.indexOf(" ") == stringForEditText.length - 3) {
                stringForEditText = stringForEditText.substring(0, stringForEditText.length - 2)
            }
            if (stringForEditText.length > 0) {
                stringForEditText = stringForEditText.substring(0, stringForEditText.length - 1)
            }
            edt_show!!.setText(stringForEditText)
        }
        bt_clear!!.setOnClickListener(View.OnClickListener {
            bt_clear!!.setAlpha(1f) // анимания кнопки затухание
            bt_clear!!.startAnimation(alphaAnim_bt_clear)
            stringForEditText = ""
            edt_show!!.setText(stringForEditText)
        })
        bt_persent!!.setOnClickListener(View.OnClickListener {
            bt_persent!!.setAlpha(1f) // анимания кнопки затухание
            bt_persent!!.startAnimation(alphaAnim_bt_persent)
            Log.e("frag_calc_click", "click зашел")
            if (stringForEditText.length == 0) {
                Log.e("frag_calc_click", "stringForEditText.length()==0")
                return@OnClickListener
            }
            if (stringForEditText.contains(" ")) {
                if (stringForEditText.indexOf(" ") == stringForEditText.length - 3 || stringForEditText.indexOf(
                        " "
                    ) == stringForEditText.length - 2 || stringForEditText.indexOf(" ") == stringForEditText.length - 1
                ) return@OnClickListener
            }
            getPersentCalculation()
            flagPersent = true
            edt_show!!.setText(stringForEditText)
            Log.e("frag_calc_click ", "stringForEditText in click =$stringForEditText")
        })
        bt_equals!!.setOnClickListener(View.OnClickListener {
            bt_equals!!.setAlpha(1f) // анимания кнопки затухание
            bt_equals!!.startAnimation(alphaAnim_bt_equals)
            getResultCalculation() // метод расчета
        })
        bt_division!!.setOnClickListener(View.OnClickListener {
            bt_division!!.setAlpha(1f) // анимания кнопки затухание
            bt_division!!.startAnimation(alphaAnim_bt_division)
            if (stringForEditText.length == 0) {
                //  break;
                return@OnClickListener
            }
            if (stringForEditText.contains(" ")) {
                if (stringForEditText.indexOf(" ") == stringForEditText.length - 3 || stringForEditText.indexOf(
                        " "
                    ) == stringForEditText.length - 2 || stringForEditText.indexOf(" ") == stringForEditText.length - 1
                ) return@OnClickListener
                getResultCalculation() // метод расчета
            }

            // flag = true;
            stringForEditText += " ÷ " // важен пробел
            edt_show!!.setText(stringForEditText)
        })
        bt_multiplication!!.setOnClickListener(View.OnClickListener {
            bt_multiplication!!.setAlpha(1f) // анимания кнопки затухание
            bt_multiplication!!.startAnimation(alphaAnim_bt_multiplication)
            if (stringForEditText.length == 0) {

                //break;
                return@OnClickListener
            }
            if (stringForEditText.contains(" ")) {
                if (stringForEditText.indexOf(" ") == stringForEditText.length - 3 || stringForEditText.indexOf(
                        " "
                    ) == stringForEditText.length - 2 || stringForEditText.indexOf(" ") == stringForEditText.length - 1
                ) //break;
                    return@OnClickListener
                getResultCalculation() // метод расчета
            }
            //flag = true;
            stringForEditText += " × " // важен пробел
            edt_show!!.setText(stringForEditText)
        })
        bt_subtraction!!.setOnClickListener(View.OnClickListener {
            bt_subtraction!!.setAlpha(1f) // анимания кнопки затухание
            bt_subtraction!!.startAnimation(alphaAnim_bt_subtraction)
            if (stringForEditText.length == 0) {
                //break;
                return@OnClickListener
            }
            if (stringForEditText.contains(" ")) {
                if (stringForEditText.indexOf(" ") == stringForEditText.length - 3 || stringForEditText.indexOf(
                        " "
                    ) == stringForEditText.length - 2 || stringForEditText.indexOf(" ") == stringForEditText.length - 1
                ) return@OnClickListener
                Log.e("блять", "-краш-")
                getResultCalculation() // метод расчета
            }

            //flag = true;
            stringForEditText += " － " // важен пробел
            edt_show!!.setText(stringForEditText)
        })
        bt_comma!!.setOnClickListener(View.OnClickListener {
            bt_comma!!.alpha = 1f // анимания кнопки затухание
            bt_comma!!.startAnimation(alphaAnim_bt_comma)
            if (stringForEditText.length == 0 || stringForEditText.indexOf(" ") == stringForEditText.length - 3 || stringForEditText.lastIndexOf(
                    "."
                ) > stringForEditText.indexOf(" ")
            ) {
                //break;
                return@OnClickListener
            } else {
                stringForEditText += "."
                edt_show!!.setText(stringForEditText)
            }
        })
        bt_sum_subtraction!!.setOnClickListener(View.OnClickListener {
            bt_sum_subtraction!!.setAlpha(1f) // анимания кнопки затухание
            bt_sum_subtraction!!.startAnimation(alphaAnim_bt_sum_subtraction)

            // метод вставки и удаления знака - перед числом для калькуляции отрицательных чисел
            sumSubtractionCalculation()
        })
        bt_sum!!.setOnClickListener(View.OnClickListener {
            bt_sum!!.setAlpha(1f) // анимания кнопки затухание
            bt_sum!!.startAnimation(alphaAnim_bt_sum)
            if (stringForEditText.length == 0) {
                // если на экране нет чисел, то символ + не выведтся и клик завершиться
                return@OnClickListener
            }
            // contains проверит есть ли в stringForEditText пробелы и пусто т.е. (" " и "")
            if (stringForEditText.contains(" ")) {
                if (stringForEditText.indexOf(" ") == stringForEditText.length - 3 || stringForEditText.indexOf(
                        " "
                    ) == stringForEditText.length - 2 || stringForEditText.indexOf(" ") == stringForEditText.length - 1
                ) return@OnClickListener
                getResultCalculation() // метод расчета
            }

            //flag = true;
            stringForEditText += " ＋ " // важен пробел
            edt_show!!.setText(stringForEditText)
        })
    }


    fun getResultCalculation() // метод расчета
    {
        var resultDouble = 0.0
        if (stringForEditText == null || stringForEditText == "") return
        if (!stringForEditText.contains(" ")) // если не содержит пробел, то вернет false
            return

        // как работает substring
        // вернет диапазон символов в строке начиная с 5 символа и до конца вместе с пробелами
        // stringForEditText.substring(stringForEditText.indexOf(5));
        // вернет диапазон символов в строке начиная с 5 символа и до конца вместе с пробелами
        // stringForEditText.substring(stringForEditText.indexOf(5,15));


        // перехватить строку до оператора.
        // stringNumberLeft вернет диапазон символов от первого(с индексом 0) до первого найденого пробела (indexOf(" "))
        // не включая его (т.е. все цифры введенные слева до знака операции)
        val stringNumberLeft = stringForEditText.substring(0, stringForEditText.indexOf(" "))
        Log.e("frag_calc", "-stringNumberLeft-$stringNumberLeft")

        // оператор для перехвата
        // operator вернет диапазон символов от первого пробела, не включая сам пробел (indexOf(" ") + 1)
        // пробел будет считаться нулевым индексом отсчета и до этого же первого пробела (indexOf(" ") + 2) только 2 символа вперед
        // т.е. мы получим знак операции то, что по центру
        val operator = stringForEditText.substring(
            stringForEditText.indexOf(" ") + 1,
            stringForEditText.indexOf(" ") + 2
        )
        Log.e("frag_calc", "-operator-$operator")

        // перехватить строку после оператора
        // stringNumberRight вернет диапазон символов после (первого пробела не включая его (он будет индексом 0) плюс по 3й индекс)
        // т.е. мы получим все цифры справой части после пробела
        val stringNumberRight = stringForEditText.substring(stringForEditText.indexOf(" ") + 3)
        Log.e("frag_calc", "-stringNumberRight-$stringNumberRight")

        // такая конструкция нужна для того чтобы пользовтель не получил ошибку
        // если введет например 50 + (и нажмет равно)
        // т.к. в правой части в stringNumberRight будет пусто и Double.parseDouble вызовет ошибку
        val doubleNumberLeft = stringNumberLeft.toDouble() // приведение типа
        var doubleNumberRight = 0.0 // приведение типа
        if (stringNumberRight != "") {
            doubleNumberRight = stringNumberRight.toDouble() // приведение типа
        }

        // если левая и правая не пустые
        if (stringNumberLeft != "" && stringNumberRight != "") {
            when (operator) {
                "＋" -> resultDouble = doubleNumberLeft + doubleNumberRight
                "－" -> resultDouble = doubleNumberLeft - doubleNumberRight
                "×" -> resultDouble = doubleNumberLeft * doubleNumberRight
                "÷" -> {
                    resultDouble = if (doubleNumberRight == 0.0) {
                        Toast.makeText(context, "Невозможно разделить на ноль", Toast.LENGTH_SHORT)
                            .show()
                        return
                        //break
                    } else {
                        // resultDouble = doubleNumberLeft / doubleNumberRight * 1.0;
                        doubleNumberLeft / doubleNumberRight
                    }
                }
            }
            val resultInt = resultDouble.toInt() // в int
            // если в ходе расчетов мы получили в double числа с нулями после запятой
            // то они будут равны resultInt и вывод на экран будет в виде int, иначе в double
            stringForEditText =
                if (resultInt.toDouble() == resultDouble) // Расчетный результат "результат" является целым числом, фактический результат имеет тип double
                {
                    edt_show!!.setText("" + resultInt)
                    "" + resultInt
                } else  // вычисляемый результат содержит десятичные разряды
                {
                    edt_show!!.setText(resultDouble.toString() + "")
                    "" + resultDouble
                }
        }
    }

    fun getPersentCalculation() {
        Log.e("frag_calc_click", "getPersentCalculation запустился")
        Log.e("frag_calc_click", "stringForEditText =$stringForEditText")
        //        double resultPersentDouble = 0;
        if (!stringForEditText.contains(" ")) {
            val doubleForEditText = stringForEditText.toDouble()
            resultPersentDouble = doubleForEditText / 100
            outputResult()
        } else {
            val stringNumberLeft = stringForEditText.substring(0, stringForEditText.indexOf(" "))
            Log.e("frag_calc", "-stringNumberLeft-$stringNumberLeft")

            // оператор для перехвата
            // operator вернет диапазон символов от первого пробела, не включая сам пробел (indexOf(" ") + 1)
            // пробел будет считаться нулевым индексом отсчета и до этого же первого пробела (indexOf(" ") + 2) только 2 символа вперед
            // т.е. мы получим знак операции то, что по центру
            val operator = stringForEditText.substring(
                stringForEditText.indexOf(" ") + 1,
                stringForEditText.indexOf(" ") + 2
            )
            Log.e("frag_calc", "-operator-$operator")

            // перехватить строку после оператора
            // stringNumberRight вернет диапазон символов после (первого пробела не включая его (он будет индексом 0) плюс по 3й индекс)
            // т.е. мы получим все цифры справой части после пробела
            val stringNumberRight = stringForEditText.substring(stringForEditText.indexOf(" ") + 3)
            Log.e("frag_calc", "-stringNumberRight-$stringNumberRight")
            val doubleNumberLeft = stringNumberLeft.toDouble() // приведение типа
            val doubleNumberRight = stringNumberRight.toDouble() // приведение типа

            // вычислить проценты если только слева будет число (например 50 + 10%)
            if (stringNumberLeft != "" && stringNumberRight == "") {
                if (operator == "%") {
                    resultPersentDouble = doubleNumberLeft / 100
                    val resultInt = resultPersentDouble.toInt() // в int
                    // если в ходе расчетов мы получили в double числа с нулями после запятой
                    // то они будут равны resultInt и вывод на экран будет в виде int, иначе в double
                    stringForEditText = if (resultInt.toDouble() == resultPersentDouble) {
                        edt_show!!.setText("" + resultInt)
                        "" + resultInt
                    } else  // вычисляемый результат содержит десятичные разряды
                    {
                        edt_show!!.setText(resultPersentDouble.toString() + "")
                        "" + resultPersentDouble
                    }
                }
            }

            // вычислить проценты если слева и справа будут числа (например 50 + 10%)
            if (stringNumberLeft != "" && stringNumberRight != "") {
                if (operator == "＋") {
                    resultPersentDouble =
                        doubleNumberLeft + doubleNumberLeft * doubleNumberRight / 100
                    outputResult()
                }
                if (operator == "－") {
                    resultPersentDouble =
                        doubleNumberLeft - doubleNumberLeft * doubleNumberRight / 100
                    outputResult()
                }
                if (operator == "×") {
                    resultPersentDouble = doubleNumberLeft * (doubleNumberRight / 100)
                    outputResult()
                }
                if (operator == "÷") {
                    resultPersentDouble = doubleNumberLeft / (doubleNumberRight / 100)
                    outputResult()
                }
            }
        }
    }

    fun outputResult() {
        val resultInt = resultPersentDouble.toInt() // в int
        // если в ходе расчетов мы получили в double числа с нулями после запятой
        // то они будут равны resultInt и вывод на экран будет в виде int, иначе в double
        stringForEditText = if (resultInt.toDouble() == resultPersentDouble) {
            edt_show!!.setText("" + resultInt)
            "" + resultInt
        } else  // вычисляемый результат содержит десятичные разряды
        {
            edt_show!!.setText(resultPersentDouble.toString() + "")
            "" + resultPersentDouble
        }
    }

    fun sumSubtractionCalculation() {
        Log.e("проверка ", "stringForEditText.length()=" + stringForEditText.length)
        Log.e("проверка ", " flagSymbolMinus в начале = $flagSymbolMinus")

        // если нет знака - влевой части и нет правой части т.е. пробелы
        if (stringForEditText.indexOf("-") == -1 && stringForEditText.indexOf(" ") == -1) {
            // и если строка пустая
            if (stringForEditText.length == 0) {
                stringForEditText += "-" // добвляю знак -
                edt_show!!.setText(stringForEditText)
                Log.e(
                    "проверка ",
                    "небыло одинст числа слева и был знак + я заменил на знак$stringForEditText"
                )
            }
            flagSymbolMinus = 0 // чтобы дальше знак - не удалился в строке
        }

        // если нет знака - в правой части
        // условие если есть пробел, значит будет правая часть
        if (stringForEditText.indexOf(" ") != -1) {
            // получаем последний символ
            val char_temp = stringForEditText[stringForEditText.length - 1]
            val char_temp_1 = '-'
            if (char_temp != char_temp_1) // если был пробел и он не равен -, то устанавливаем -
            {
                stringForEditText = "$stringForEditText-" // то устанавливаем -
                edt_show!!.setText(stringForEditText)
                Log.e(
                    "проверка ",
                    "не было знака в правой части я его поставил$stringForEditText"
                )
                flagSymbolMinus = 0 // чтобы код не ушел в земну - на +
            }
        }

        // тут происходит замена знака - влевой или вправой части (есть операторы +,-,* или / и пробелы)
        if (flagSymbolMinus == 1) {
            // если есть знак влевой и нет правой
            if (stringForEditText.indexOf("-") == 0 && stringForEditText.length == 1) {
                val temp = stringForEditText.replace("-", "")
                stringForEditText = temp
                edt_show!!.setText(stringForEditText)
                Log.e("проверка ", " был знак слева - я его заменил на + ")
            }

            // если есть знак - вправой части
            val newString = stringForEditText.substring(
                stringForEditText.indexOf(" ") + 3,
                stringForEditText.indexOf(" ") + 4
            )
            Log.e("проверка ", " newString=$newString")
            if (newString == "-") {
                // удаляю последний символ - (с помощью ".$",)
                val temp = stringForEditText.replaceFirst(".$".toRegex(), "")
                Log.e("проверка ", " temp ПОСЛЕ=$temp")
                stringForEditText = temp // перезаписываю
                Log.e("проверка ", " stringForEditText ПОСЛЕ=$stringForEditText")
                edt_show!!.setText(stringForEditText)
                Log.e("проверка ", " был знак справа - я его заменил на + ")
            }
        }
        flagSymbolMinus = 1
        Log.e("проверка ", " flagSymbolMinus в конце = $flagSymbolMinus")

    }

}