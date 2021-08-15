# Masoodvali_Movies

Movie Application which showcases Movies and Their Details

Application Contains two Sreens
  1. MovieOverviewScreen
  2. MovieDetailScreen

MovieOverviewScreen:

   Screen Contains a recyclerview which displays the Movies thumbanail and title.
  
  
MovieDetatilScreen:

   Screen Contains a recyclerview which displays the Movies details like Rating, Upload Date, Summary
   
   
Langauge and Tools Used:

  1. Kotlin Programming Language
  2. Naivgation Architecture Component
  3. DataBinding
  4. Mvvm Design Pattern
  5. Retrofit for Network Calls
  6. Espresso for UI testing
  7. Fragments
  8. Recyclerview
  9. Glide For Image Loading


For API URl and JSON data of Movies:

 https://developer.nytimes.com/docs/movie-reviews-api/1/overview (New York Times Movie Reviews: You may have to register to create a free API key to access the API calls)
  
  
  
  
  Navigation.XMl
  
  <img width="1146" alt="Screenshot 2021-08-15 at 2 57 31 PM" src="https://user-images.githubusercontent.com/34739879/129473901-36500d6e-7496-4a91-965d-d5a8c7768cd5.png">
  
  Navigation Command:
  
  
        binding.rvMovies.setOnClickListener {
            this.findNavController()
                .navigate(R.id.action_movieOveriewFragment_to_movieDetailFragment)
        }

                
                
   Navigation BackPress:
   
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostfragment)
        return  navController.navigateUp()
    }
 
  
  Databinding:(Build.gradle)
  
  
    dataBinding {
        enabled true
    }
 MVVM Design Pattern:
 
 ![500px-MVVMPattern](https://user-images.githubusercontent.com/34739879/129474287-5c02bec5-7426-4819-8c5b-71a42a79c2d4.png)


Screens:

![MovieOverviewScreen](https://user-images.githubusercontent.com/34739879/129474344-89e387c1-e112-4d32-9087-572ab0ca2dae.jpeg) ![Details Screen](https://user-images.githubusercontent.com/34739879/129474348-33440597-9612-4183-99c8-bae12fe78d1a.jpeg)







