package com.example.todolist_.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import kotlin.text.Typography


@Composable
fun TodoListInput(
    text: String,
    onChange: (String) -> Unit,
    modifier: Modifier,
    maxLine: Int = 1,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    //textStyle: TextStyle = Typography.smallUbuntuBlack,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        focusedIndicatorColor = MaterialTheme.colors.onSecondary,
        unfocusedIndicatorColor = MaterialTheme.colors.onSecondary,
        trailingIconColor = MaterialTheme.colors.onSecondary,
        errorIndicatorColor = MaterialTheme.colors.onError,
        cursorColor = MaterialTheme.colors.onSecondary,
        errorCursorColor = MaterialTheme.colors.onError,
        backgroundColor = MaterialTheme.colors.surface
    ),
    singleLine: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    errorMessage: String? = null,
    maxCharacter: Int? = null,
    label: String,
    //labelStyle: TextStyle = MaterialTheme.typography.,
    placeHolder: String,
    //placeHolderStyle: TextStyle = MaterialTheme.typography.smallUbuntuTransparent
) {
    Column {
        OutlinedTextField(
            modifier = modifier,
            value = text,
            onValueChange = { str ->
                maxCharacter?.let {
                    if (str.length <= it) {
                        onChange(str)
                    }
                } ?: run {
                    onChange(str)
                }
            },
            isError = errorMessage?.let {
                it.isNullOrEmpty().not()
            } ?: false,
            readOnly = readOnly,
            enabled = enabled,
            singleLine = singleLine,
            visualTransformation = visualTransformation,
            maxLines = maxLine,
            label = {
                Text(text = label)
            },
            trailingIcon = {
                when (errorMessage?.isNullOrEmpty()?.not() ?: false) {
                    true -> {
                        Icon(
                            Icons.Filled.Add, contentDescription = errorMessage,
                            tint = MaterialTheme.colors.onError
                        )
                    }
                    false -> {
                        trailingIcon?.let {
                            trailingIcon()
                        }
                    }
                }
            },
            leadingIcon = leadingIcon,
            placeholder = {
                Text(text = placeHolder)
            },
            colors = colors,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions
        )

        if (errorMessage?.isNullOrEmpty()?.not() == true) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                text = errorMessage?:""
            )
        }
    }
}