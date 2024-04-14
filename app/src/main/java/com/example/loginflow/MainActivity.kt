package com.example.loginflow

import android.os.Bundle
import android.util.Log
import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginflow.navigation.RootNavigation
import com.example.loginflow.navigation.RootRoutesEnums
import com.example.loginflow.ui.theme.LoginFlowTheme
import com.example.loginflow.utils.GenericResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LoginFlowTheme {

                var isReady by remember { mutableStateOf(false) }

                val viewModel:RootViewModel= viewModel()
                val userDataState by viewModel.userData.collectAsState()
                var startDestination by remember { mutableStateOf(RootRoutesEnums.Authentication.route) }

                LaunchedEffect(userDataState) {
                    when (userDataState) {
                        is GenericResult.Success -> {
                            val data = (userDataState as GenericResult.Success).data
                            if (data != null) {
                                isReady = true
                                startDestination = RootRoutesEnums.Authenticated.route
                            }
                        }
                        is GenericResult.Loading -> {
                            isReady = false
                        }
                        is GenericResult.Error -> {
                            isReady = false
                        }
                    }
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val rootView = LocalView.current // Get the localView

                    rootView.viewTreeObserver.addOnPreDrawListener(
                        object : ViewTreeObserver.OnPreDrawListener {
                            override fun onPreDraw(): Boolean {
                                // Check whether the initial data is ready.
                                return if (isReady) {
                                    rootView.viewTreeObserver.removeOnPreDrawListener(this)
                                    true
                                } else {
                                    false
                                }
                            }
                        }
                    )
                    if(isReady){
                        RootNavigation(startDestination)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginFlowTheme {
        Greeting("Android")
    }
}