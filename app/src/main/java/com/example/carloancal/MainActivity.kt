package com.example.carloancal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttoncalculate.setOnClickListener{
            calculateLoan()
        }
    }
    private fun calculateLoan(){
        //getting input data from user
        val car_price =editTextCarPrice.text.toString().toInt()
        val downPayment =editTextdownpayment.text.toString().toInt()
        val loanPeriod =editTextloanPeriod.text.toString().toInt()
        val interestRate =editTextInterestRate.text.toString().toInt()

        val carLoan = car_price-downPayment
        val inetrest = carLoan*interestRate*loanPeriod
        val montlyRepayment = (carLoan+interestRate)/loanPeriod/12


        textViewcarloan.text=getString(R.string.loan)+": ${carLoan}"
        textViewinterest.text=getString(R.string.interest)+": ${inetrest}"
        textViewinterestmonthlyrepayment.text=getString(R.string.montly_repayment)+": ${montlyRepayment}"

    }

    fun resetInput(view: View){
        editTextCarPrice.text=null
        editTextdownpayment.text=null
        editTextloanPeriod.text=null
        editTextInterestRate.text=null


        textViewcarloan.text=getString(R.string.loan)
        textViewinterest.text=getString(R.string.interest)
        textViewinterestmonthlyrepayment.text=getString(R.string.montly_repayment)
    }
}
