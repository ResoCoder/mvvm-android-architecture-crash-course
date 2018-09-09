package com.resocoder.mvvmbasicstut.ui.quotes

import androidx.lifecycle.ViewModel
import com.resocoder.mvvmbasicstut.data.Quote
import com.resocoder.mvvmbasicstut.data.QuoteRepository


class QuotesViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}