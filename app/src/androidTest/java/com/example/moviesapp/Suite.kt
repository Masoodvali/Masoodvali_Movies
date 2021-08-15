package com.example.moviesapp

import com.example.moviesapp.fragments.MovieDetailFragmentTest
import com.example.moviesapp.fragments.MovieOveriewFragmentTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MovieOveriewFragmentTest::class,
    MovieDetailFragmentTest::class,
)
class Suite