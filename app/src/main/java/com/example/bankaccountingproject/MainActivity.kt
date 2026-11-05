package com.example.bankaccountingproject


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankaccountingproject.ui.theme.BankAccountingProjectTheme
import com.example.bankaccountingproject.model.AccountType
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BankAccountingProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

//Ui Part of the First page

@Composable
fun Greeting (modifier: Modifier = Modifier) {

    var accountType by remember { mutableStateOf<AccountType?>(null) }
    val selected = accountType

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF2F4F8))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

        //Below is the first welcome text that will be displayed using box.
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 12.dp, shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .background(
                    color = Color(0xFF2157BB),
                    shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .padding(horizontal = 24.dp, vertical = 32.dp),
                contentAlignment = Alignment.Center



        ) {
            Text(
                text = "Welcome to your banking system.",
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineLarge,

                )
        }
        Spacer(modifier = Modifier.height(24.dp))

        //Below is the second text that will be displayed using column
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 12.dp, shape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
            .background(Color.White, shape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        )

    {
        Text(
            text = "What type of account would you like to create?",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,

            )

        Spacer(modifier = Modifier.height(60.dp))

        //Following are three options for account creation.

        //Using buttons to make that functionable

        AccountButton("Debit Account") {accountType = AccountType.DEBIT }

        Spacer(modifier = Modifier.height(12.dp))

        AccountButton("Credit Account") { accountType = AccountType.CREDIT }

        Spacer(modifier = Modifier.height(12.dp))

        AccountButton("Checking Account") { accountType = AccountType.CHECKING }
    }



    }
}


@Composable
fun AccountButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp),
        shape = RoundedCornerShape(26.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF0459A1),
            contentColor = Color.White
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 6.dp,
            pressedElevation = 2.dp
        )
    ) {
        Text(text)
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BankAccountingProjectTheme {
    Greeting()
    }
}