package com.example.baitapso2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmailValidatorScreen()
        }
    }
}

@Composable
fun EmailValidatorScreen() {
    var email by remember { mutableStateOf("") }
    var validationResult by remember { mutableStateOf("") }
    var resultColor by remember { mutableStateOf(Color.Black) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally, // Căn giữa theo chiều ngang
        verticalArrangement = Arrangement.Center // Căn giữa theo chiều dọc
    ) {
        // Tiêu đề
        Text(
            text = "Thực hành 02",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp)) // Tạo khoảng trống

        // Ô nhập liệu cho Email
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (validationResult.isNotEmpty()) {
            Text(
                text = validationResult,
                color = resultColor,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Nút bấm "Kiểm tra"
        Button(
            onClick = {
                val emailInput = email.trim() // Lấy email và xóa khoảng trắng thừa

                if (emailInput.isBlank()) {
                    validationResult = "Email không hợp lệ"
                    resultColor = Color.Red
                } else if (!emailInput.contains("@")) {
                    validationResult = "Email không đúng định dạng"
                    resultColor = Color.Red
                } else {
                    validationResult = "Bạn đã nhập email hợp lệ"
                    resultColor = Color(0xFF00C853) // Màu xanh lá cây
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Kiểm tra", fontSize = 18.sp)
        }
    }
}