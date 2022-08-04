package ru.wkns37.worldskills.features.room.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RoomScreen(viewModel: RoomViewModel) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val state by viewModel.currentState()
        if (state.loading) {
            CircularProgressIndicator()
        } else if (state.users.isEmpty()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Users list is empty")
                Spacer(Modifier.height(12.dp))
                Button(onClick = { viewModel.updateList() }) {
                    Text("Update")
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                contentPadding = PaddingValues(4.dp)
            ) {
                items(state.users) { UserCard(it) }
            }
        }
    }
}

@Composable
fun UserCard(userUi: UserUi) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable {}
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Column {
                Text(
                    text = userUi.name,
                    style = MaterialTheme.typography.h6
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = userUi.id.toString(),
                    style = MaterialTheme.typography.body2
                )
            }
            Text(
                text = "${userUi.age} y.o.",
                style = MaterialTheme.typography.body2
            )
        }
    }
}