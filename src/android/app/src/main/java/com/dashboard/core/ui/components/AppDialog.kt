package com.dashboard.core.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import com.dashboard.core.ui.theme.Dimens

@Composable
fun AppDialog(
    title: String,
    message: String,
    onDismiss: () -> Unit,
    confirmText: String = "Confirm",
    onConfirm: () -> Unit,
    dismissText: String? = "Cancel",
    onDismissClick: (() -> Unit)? = null
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            shape = RoundedCornerShape(Dimens.radiusLarge),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(Dimens.space24),
                verticalArrangement = Arrangement.spacedBy(Dimens.space16)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineSmall
                )
                
                Text(
                    text = message,
                    style = MaterialTheme.typography.bodyMedium
                )
                
                Spacer(modifier = Modifier.height(Dimens.space8))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(Dimens.space12)
                ) {
                    if (dismissText != null) {
                        AppButton(
                            text = dismissText,
                            onClick = onDismissClick ?: onDismiss,
                            variant = AppButtonVariant.SECONDARY,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    
                    AppButton(
                        text = confirmText,
                        onClick = {
                            onConfirm()
                            onDismiss()
                        },
                        variant = AppButtonVariant.PRIMARY,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}
