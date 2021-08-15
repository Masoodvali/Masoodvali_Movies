package com.example.moviesapp.fragments

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches

import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.example.moviesapp.MainActivity
import com.example.moviesapp.R
import com.example.moviesapp.data.datamodels.Movie
import com.example.moviesapp.data.datamodels.link
import com.example.moviesapp.data.datamodels.multimedia
import com.example.moviesapp.data.datamodels.results
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MovieOveriewFragmentTest {
    var response = InstrumentationRegistry.getArguments()
    val targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext()
    val context = InstrumentationRegistry.getInstrumentation().getContext()
    lateinit var movie: Movie
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
        val details = results(
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
        movie = Movie(
            "OK",
            "@copyRight to NYT times 2021",
            10,
            listOf(details)
        )
        val bundle = Bundle()
        bundle.putSerializable("details", details)
        val scenario = launchFragmentInContainer<MovieOveriewFragment>(
            bundle
        )
    }

    @Test
    fun isProgressVisible() {
        onView(withId(R.id.progressBar)).check(matches(isDisplayed()))
    }
    @Test
    fun isRecyclerVisible() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
    }

    @Test
    fun  testClickItem_isDetailFragmentVisible(){
        Thread.sleep(3000);


        /*navigation to DetailsFragment */
        onView(allOf(withId(R.id.movie_name),
            withText(movie.results[0].display_title))).check(matches(isDisplayed())).perform(click())


        onView(Matchers.allOf(withId(R.id.movie_name),
            withText(movie.results[0].byline))).check(matches(isDisplayed()))
//
       /**/
        pressBack();


    }


}