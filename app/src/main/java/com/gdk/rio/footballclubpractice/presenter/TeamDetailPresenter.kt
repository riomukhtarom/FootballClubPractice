package com.gdk.rio.footballclubpractice.presenter

import com.gdk.rio.footballclubpractice.api.ApiRepository
import com.gdk.rio.footballclubpractice.api.TheSportDBApi
import com.gdk.rio.footballclubpractice.model.TeamResponse
import com.gdk.rio.footballclubpractice.view.teamdetail.TeamDetailView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamDetailPresenter(private val view: TeamDetailView,
                          private val apiRepository: ApiRepository,
                          private val gson: Gson) {

    fun getTeamDetail(teamId: String) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getTeamDetail(teamId)),
                    TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamDetail(data.teams)
            }
        }
    }
}