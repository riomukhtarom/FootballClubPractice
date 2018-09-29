package com.gdk.rio.footballclubpractice.view.home

import com.gdk.rio.footballclubpractice.model.Team

interface TeamsView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}