package com.dashboard.core.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.dashboard.core.ui.theme.Dimens
import com.dashboard.core.ui.theme.Error
import com.dashboard.core.ui.theme.Primary

enum class AppButtonVariant {
    PRIMARY,
    SECONDARY,
    DESTRUCTIVE,
    GHOST
}

@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: AppButtonVariant = AppButtonVariant.PRIMARY,
    icon: ImageVector? = null,
    isLoading: Boolean = false,
    enabled: Boolean = true,
    fullWidth: Boolean = false
) {
    val buttonModifier = if (fullWidth) {
        modifier.fillMaxWidth().height(Dimens.buttonHeightMedium)
    } else {
        modifier.height(Dimens.buttonHeightMedium)
    }
    
    when (variant) {
        AppButtonVariant.PRIMARY -> {
            Button(
                onClick = onClick,
                modifier = buttonModifier,
                enabled = enabled && !isLoading,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Primary,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(Dimens.radiusMedium),
                contentPadding = PaddingValues(horizontal = Dimens.space16)
            ) {
                ButtonContent(text, icon, isLoading)
            }
        }
        
        AppButtonVariant.SECONDARY -> {
            OutlinedButton(
                onClick = onClick,
                modifier = buttonModifier,
                enabled = enabled && !isLoading,
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Primary
                ),
                shape = RoundedCornerShape(Dimens.radiusMedium),
                contentPadding = PaddingValues(horizontal = Dimens.space16)
            ) {
                ButtonContent(text, icon, isLoading)
            }
        }
        
        AppButtonVariant.DESTRUCTIVE -> {
            Button(
                onClick = onClick,
                modifier = buttonModifier,
                enabled = enabled && !isLoading,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Error,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(Dimens.radiusMedium),
                contentPadding = PaddingValues(horizontal = Dimens.space16)
            ) {
                ButtonContent(text, icon, isLoading)
            }
        }
        
        AppButtonVariant.GHOST -> {
            TextButton(
                onClick = onClick,
                modifier = buttonModifier,
                enabled = enabled && !isLoading,
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Primary
                ),
                shape = RoundedCornerShape(Dimens.radiusMedium),
                contentPadding = PaddingValues(horizontal = Dimens.space16)
            ) {
                ButtonContent(text, icon, isLoading)
            }
        }
    }
}

@Composable
private fun ButtonContent(
    text: String,
    icon: ImageVector?,
    isLoading: Boolean
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(Dimens.iconSmall),
                strokeWidth = 2.dp,
                color = Color.White
            )
            Spacer(modifier = Modifier.width(Dimens.space8))
        } else if (icon != null) {
            androidx.compose.material3.Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(Dimens.iconMedium)
            )
            Spacer(modifier = Modifier.width(Dimens.space8))
        }
        Text(text)
    }
}
