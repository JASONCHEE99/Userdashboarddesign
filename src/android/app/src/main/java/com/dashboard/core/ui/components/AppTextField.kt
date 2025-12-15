package com.dashboard.core.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.dashboard.core.ui.theme.Dimens
import com.dashboard.core.ui.theme.Error
import com.dashboard.core.ui.theme.Gray200
import com.dashboard.core.ui.theme.Gray500
import com.dashboard.core.ui.theme.Gray900
import com.dashboard.core.ui.theme.Primary

enum class AppTextFieldType {
    TEXT,
    PASSWORD,
    NUMBER,
    EMAIL
}

@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String? = null,
    leadingIcon: ImageVector? = null,
    type: AppTextFieldType = AppTextFieldType.TEXT,
    enabled: Boolean = true,
    isError: Boolean = false,
    errorMessage: String? = null,
    maxLines: Int = 1,
    singleLine: Boolean = true
) {
    var passwordVisible by remember { mutableStateOf(false) }
    
    val keyboardOptions = when (type) {
        AppTextFieldType.PASSWORD -> KeyboardOptions(keyboardType = KeyboardType.Password)
        AppTextFieldType.NUMBER -> KeyboardOptions(keyboardType = KeyboardType.Number)
        AppTextFieldType.EMAIL -> KeyboardOptions(keyboardType = KeyboardType.Email)
        else -> KeyboardOptions.Default
    }
    
    val visualTransformation = when (type) {
        AppTextFieldType.PASSWORD -> {
            if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
        }
        else -> VisualTransformation.None
    }
    
    Column(modifier = modifier) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            label = label?.let { { Text(it) } },
            placeholder = placeholder?.let { { Text(it) } },
            leadingIcon = leadingIcon?.let {
                {
                    Icon(
                        imageVector = it,
                        contentDescription = null
                    )
                }
            },
            trailingIcon = if (type == AppTextFieldType.PASSWORD) {
                {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = if (passwordVisible) "Hide password" else "Show password"
                        )
                    }
                }
            } else null,
            enabled = enabled,
            isError = isError,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            maxLines = maxLines,
            singleLine = singleLine,
            shape = RoundedCornerShape(Dimens.radiusMedium),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Primary,
                unfocusedBorderColor = Gray200,
                errorBorderColor = Error,
                focusedTextColor = Gray900,
                unfocusedTextColor = Gray900,
                disabledTextColor = Gray500,
                focusedLabelColor = Primary,
                unfocusedLabelColor = Gray500
            )
        )
        
        if (isError && errorMessage != null) {
            Spacer(modifier = Modifier.height(Dimens.space4))
            Text(
                text = errorMessage,
                color = Error,
                style = androidx.compose.material3.MaterialTheme.typography.bodySmall
            )
        }
    }
}
