package com.example.bankaccountingproject.ui.theme



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DebitScreen(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "Debit Account Dashboard",
             style = MaterialTheme.typography.headlineMedium,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 24.dp),
            fontStyle = androidx.compose.ui.text.font.FontStyle.Italic

            )

        Text(text = "$10000.00",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 24.dp),

        )

        Spacer(modifier = Modifier.weight(1f))

        Button(onClick = onBack,
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color(0xFF0459A1)
            )) {
            Text("Back to Homepage")

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DebitScreenPreview() {
    BankAccountingProjectTheme {
        DebitScreen(
            onBack = {}
        )
    }
}