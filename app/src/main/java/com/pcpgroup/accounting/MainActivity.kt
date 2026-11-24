
package com.pcpgroup.accounting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PCPApp()
        }
    }
}

@Composable
fun PCPApp() {
    MaterialTheme {
        var selected by remember { mutableStateOf("डैशबोर्ड") }

        val menu = listOf(
            "डैशबोर्ड",
            "सदस्य",
            "फसलें",
            "कमाई",
            "खर्च",
            "उधार",
            "मुनाफा",
            "रिपोर्ट"
        )

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("PCP Group हिसाब-किताब") }
                )
            }
        ) { padding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    Text(
                        "स्वागत है PCP Group में!",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                }

                item {
                    Text("समूह के 8 सदस्यों का पूरा हिसाब")
                }

                item {
                    Text("आज का हिसाब", fontWeight = FontWeight.Bold)
                    Card(Modifier.fillMaxWidth()) {
                        Column(Modifier.padding(16.dp)) {
                            Text("कुल कमाई: ₹0")
                            Text("कुल खर्च: ₹0")
                            Text("कुल मुनाफा: ₹0")
                        }
                    }
                }

                items(menu) { item ->
                    Card(
                        onClick = { selected = item },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            item,
                            modifier = Modifier.padding(18.dp),
                            fontWeight = FontWeight.Medium
                        )
                    }
                }

                item {
                    Text(
                        "वर्तमान सेक्शन: $selected",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
