package pt.atp.ex1aula5.data.cb

import pt.atp.ex1aula5.data.model.Breed

interface DataRetrieved {

    fun onDataFetchedSuccess(breeds: List<Breed>)

    fun onDataFetchedFailed()
}