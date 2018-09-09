package com.resocoder.mvvmbasicstut.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.resocoder.mvvmbasicstut.R
import com.resocoder.mvvmbasicstut.data.Quote
import com.resocoder.mvvmbasicstut.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*

class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
                .get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach{ quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })

        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}
