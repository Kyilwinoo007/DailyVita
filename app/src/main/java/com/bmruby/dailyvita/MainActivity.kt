package com.bmruby.dailyvita

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.bmruby.dailyvita.screens.AllergicScreen
import com.bmruby.dailyvita.screens.DietScreen
import com.bmruby.dailyvita.screens.FinalScreen
import com.bmruby.dailyvita.screens.HealthConcern
import com.bmruby.dailyvita.screens.WelcomeScreen
import com.bmruby.dailyvita.ui.theme.DailyVitaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DailyVitaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val controller = rememberNavController()
                    NavHost(navController = controller,
                        route = MyGraph.Root,
                        startDestination = MyGraph.HOME){
                        composable(route = MyGraph.HOME){
                            WelcomeScreen{
                                controller.navigate(MyGraph.HEALTH)
                            }
                        }
                        composable(route = MyGraph.HEALTH){
                            HealthConcern{
                                controller.navigate(MyGraph.DIET)
                            }
                        }
                        composable(route = MyGraph.DIET){
                            DietScreen()
                        }
                        composable(route = MyGraph.ALLERGIC){
                            AllergicScreen()
                        }
                        composable(route = MyGraph.FINAL){
                            FinalScreen()
                        }

                    }
                }
            }
        }
    }
}

object MyGraph{
    const val Root = "root_graph"
    const val HOME = "welcome"
    const val HEALTH = "health_concern"
    const val DIET = "diet"
    const val ALLERGIC = "allergic"
    const val FINAL = "final"

}