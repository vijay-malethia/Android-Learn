import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.androiddemo.navigation.Home
import com.example.androiddemo.navigation.Login
import com.example.androiddemo.navigation.Splash
import com.example.androiddemo.ui.screen.auth.LoginView
import com.example.androiddemo.ui.screen.home.HomeScreen
import com.example.androiddemo.ui.screen.splash.SplashScreen


@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Splash,
        modifier = modifier
    ) {
        composable<Splash> {
            SplashScreen(
                navController = navController
            )
        }
        composable<Login> {
            LoginView(navController = navController)
        }
        composable<Home> {
            HomeScreen(navController = navController)
        }
    }
}

