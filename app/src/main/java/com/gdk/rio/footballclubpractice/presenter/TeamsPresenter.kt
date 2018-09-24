package com.gdk.rio.footballclubpractice.presenter

import com.gdk.rio.footballclubpractice.api.ApiRepository
import com.gdk.rio.footballclubpractice.view.TeamsView
import com.gdk.rio.footballclubpractice.api.TheSportDBApi
import com.gdk.rio.footballclubpractice.model.TeamResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamsPresenter (private val view: TeamsView,
                      private val apiRepository: ApiRepository,
                      private val gson: Gson) {

    fun getTeamList(league: String?){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(
                    apiRepository.doRequest(TheSportDBApi.getTeam(league)),
                    TeamResponse::class.java)

            uiThread{
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }
}