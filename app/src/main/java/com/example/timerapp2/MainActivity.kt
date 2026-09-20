package com.example.timerapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timerapp2.ui.theme.TimerApp2Theme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TimerApp2Theme {
                TimerScreen()
            }
        }
    }
}

@Composable
fun TimerScreen() {

    var timeLeft by remember { mutableStateOf(25 * 60) }
    var totalTime by remember { mutableStateOf(25 * 60) }
    var isRunning by remember { mutableStateOf(false) }

    val backgroundColor = Color(0xFF0F1115)
    val cardColor = Color(0xFF191C22)
    val primaryColor = Color(0xFF8B5CF6)
    val secondaryText = Color(0xFF9CA3AF)

    LaunchedEffect(isRunning) {
        while (isRunning && timeLeft > 0) {
            delay(1000)
            timeLeft--
        }

        if (timeLeft == 0) {
            isRunning = false
        }
    }

    val minutes = timeLeft / 60
    val seconds = timeLeft % 60

    val timeText = String.format(
        "%02d:%02d",
        minutes,
        seconds
    )

    val progress = timeLeft / totalTime.toFloat()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Focus Timer",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = if (isRunning) {
                "Stay focused..."
            } else {
                "Ready to focus?"
            },
            color = secondaryText,
            fontSize = 15.sp
        )

        Spacer(modifier = Modifier.height(45.dp))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(300.dp)
        ) {

            CircularProgressIndicator(
                progress = { 1f },
                modifier = Modifier.size(270.dp),
                color = cardColor,
                strokeWidth = 14.dp
            )

            CircularProgressIndicator(
                progress = { progress },
                modifier = Modifier.size(270.dp),
                color = primaryColor,
                strokeWidth = 14.dp
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = timeText,
                    color = Color.White,
                    fontSize = 52.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = if (isRunning) "RUNNING" else "READY",
                    color = secondaryText,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(45.dp))

        Button(
            onClick = {
                isRunning = !isRunning
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = primaryColor
            )
        ) {

            Text(
                text = if (isRunning) {
                    "PAUSE TIMER"
                } else {
                    "START TIMER"
                },
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedButton(
            onClick = {
                timeLeft = totalTime
                isRunning = false
            },
            modifier = Modifier
                .width(150.dp)
                .height(50.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.White
            )
        ) {

            Text(
                text = "RESET",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = "Quick Duration",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            DurationButton(
                text = "5 MIN",
                onClick = {
                    totalTime = 5 * 60
                    timeLeft = 5 * 60
                    isRunning = false
                }
            )

            DurationButton(
                text = "15 MIN",
                onClick = {
                    totalTime = 15 * 60
                    timeLeft = 15 * 60
                    isRunning = false
                }
            )

            DurationButton(
                text = "25 MIN",
                onClick = {
                    totalTime = 25 * 60
                    timeLeft = 25 * 60
                    isRunning = false
                }
            )
        }
    }
}

@Composable
fun DurationButton(
    text: String,
    onClick: () -> Unit
) {

    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .width(95.dp)
            .height(48.dp),
        shape = RoundedCornerShape(14.dp)
    ) {

        Text(
            text = text,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}