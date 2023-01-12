package com.learn.countries.viewModel


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.learn.countries.model.Country
import com.learn.countries.repository.CRepository
import com.learn.countries.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject


@HiltViewModel
class FirstScreenViewModel@Inject constructor(
    private val cRepository: CRepository,
): ViewModel(){
    private var job : Job? = null
    val countryList = mutableStateOf<List<Country>>(listOf())


    private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Resource.Error(throwable.localizedMessage ?: "error!",data = true)
    }


    init {
        getAll()
    }


    fun getAll(){
     job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
         val result = cRepository.getData()
         withContext(Dispatchers.Main){
             result.data?.let {
                 when(result){
                     is Resource.Success -> {
                         countryList.value = it
                     }

                 }

             }
         }
     }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()

    }

}