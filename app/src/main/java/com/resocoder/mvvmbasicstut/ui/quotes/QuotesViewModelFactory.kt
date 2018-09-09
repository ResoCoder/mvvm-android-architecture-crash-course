package com.resocoder.mvvmbasicstut.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.resocoder.mvvmbasicstut.data.QuoteRepository


class QuotesViewModelFactory(private val quoteRepository: QuoteRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepository) as T
    }
}