package com.example.mvvm.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvm.R
import com.example.mvvm.model.Siswa

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilData(
    statusUiSiswa: Siswa,
    onBackBtnClick:()->Unit
){
    val items = listOf(
        Pair(first = stringResource(id = R.string.nama_lengkap), second = statusUiSiswa.nama),
        Pair(first = stringResource(id = R.string.jenis_kelamin), second = statusUiSiswa.gender),
        Pair(first = stringResource(id = R.string.alamat), second = statusUiSiswa.alamat)
    )
    Scaffold (modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id=R.string.tampil),
                        color = Color.White
                    )},
                colors = TopAppBarDefaults
                    .mediumTopAppBarColors(colorResource
                        (id = R.color.purple_500)
                    )
            )
        }){     isiRuang->
        Column(
            modifier = Modifier.padding(isiRuang),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.padding(dimensionResource(id=R.dimen.padding_medium)),
                verticalArrangement = Arrangement.spacedBy(dimensionResource
                    (R.dimen.padding_small))
            ) {
                items.forEach { item ->
                    Column {
                        Text(text = item.first.uppercase(),
                            fontSize = 16.sp)
                        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
                        Text(text = item.second,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Cursive, fontSize = 22.sp)
                    }
                    Divider(thickness = dimensionResource(R.dimen.thickness_divider))
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onBackBtnClick
                ) {
                    Text(text = stringResource(id=R.string.back))
                }
            }
        }

    }
}