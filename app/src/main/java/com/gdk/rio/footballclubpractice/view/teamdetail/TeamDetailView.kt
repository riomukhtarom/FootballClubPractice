package com.gdk.rio.footballclubpractice.view.teamdetail

import com.gdk.rio.footballclubpractice.model.Team

interface TeamDetailView {
    fun showLoading()
    fun hideLoading()
    fun showTeamDetail(data: List<Team>)
}