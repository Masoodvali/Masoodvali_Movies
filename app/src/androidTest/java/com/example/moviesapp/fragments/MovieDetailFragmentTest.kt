package com.example.moviesapp.fragments

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.moviesapp.MainActivity
import com.example.moviesapp.R
import com.example.moviesapp.data.datamodels.link
import com.example.moviesapp.data.datamodels.multimedia
import com.example.moviesapp.data.datamodels.results
import org.hamcrest.Matchers.allOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MovieDetailFragmentTest {
    lateinit var details: results

    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup() {
        val link = link(
            "article",
            "https://www.nytimes.com/2021/06/01/movies/port-authority-review.html",
            "Read the New York Times Review of Port Authority"
        )
        val multimedia = multimedia("", "", 0, 0)
        details = results(
            "Port Authority",
            "R",
            "Kyle Turner",

            "2021-05-28",
            "2021-06-01",
            "2021-06-01",
            "‘Port Authority’ Review: Two Outsiders Searching for a Place",
            link,
            multimedia,
        )
        val bundle = Bundle()
        bundle.putSerializable("details", details)
        val scenario = launchFragmentInContainer<MovieDetailFragment>(
            bundle
        )
    }

    @Test
    fun isDisplayTitleValueIsVisible(){
        onView(allOf(withId(R.id.value), withText(details.display_title))).check(matches(isDisplayed()))
    }

    @Test
    fun isByLineVisible(){
        onView(allOf(withId(R.id.value), withText(details.byline))).check(matches(isDisplayed()))
    }
    @Test
    fun isSummaryShortVisible(){
        onView(allOf(withId(R.id.value), withText(details.summary_short))).check(matches(isDisplayed()))
    }

    @Test
    fun isRatingVisible(){
        onView(allOf(withId(R.id.value), withText(details.mpaa_rating))).check(matches(isDisplayed()))
    }

}