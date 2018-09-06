package com.gdk.rio.footballclubpractice.view

import com.gdk.rio.footballclubpractice.model.Team

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}