package com.resocoder.mvvmbasicstut.utilities

import com.resocoder.mvvmbasicstut.data.FakeDatabase
import com.resocoder.mvvmbasicstut.data.QuoteRepository
import com.resocoder.mvvmbasicstut.ui.quotes.QuotesViewModelFactory


object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}