package pt.atp.ex1aula5.data.cb

import pt.atp.ex1aula5.data.model.Search

interface DataSearched {

    fun onDataSearchedSuccess(search: List<Search>)

    fun onDataSearchedFailed()
}