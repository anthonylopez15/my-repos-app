package com.example.myrepos.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.myrepos.R;
import com.example.myrepos.data.ReposDTO;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    final static String TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.toolbar_detalhes));

        Intent i = getIntent();
        final ReposDTO reposDTO = (ReposDTO) i.getSerializableExtra("object");

        TextView tvName = findViewById(R.id.detail_name);
        TextView tvDesciption = findViewById(R.id.detail_description);
        TextView tvLanguage = findViewById(R.id.detail_language);
        TextView tvFav = findViewById(R.id.fav);
        TextView tvforks = findViewById(R.id.forks);
        TextView tvupdate = findViewById(R.id.detail_update_at);


        tvName.setText(reposDTO.getmName());
        tvDesciption.setText(reposDTO.getmDescription());
        tvLanguage.setText(reposDTO.getMlanguage());
        tvFav.setText(numberFormat(reposDTO.getFav()));
        tvforks.setText(numberFormat(reposDTO.getMforks()));

        String dateFormatted = "Update on " + dateFormat(reposDTO.getMupdated());
        tvupdate.setText(dateFormatted);
        Log.i(TAG, dateFormatted);

        AppCompatButton btnLink = findViewById(R.id.btnLink);
        btnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(reposDTO.getUrl()));
                v.getContext().startActivity(intent);
            }
        });
    }

    private String dateFormat(String date) {
        DateFormat dateFormatEntry = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", locale());
        Date dateEntry;
        try {
            dateEntry = dateFormatEntry.parse(date);
            DateFormat dateFormatOut = new SimpleDateFormat("dd MMMM yyyy", locale());
            date = dateFormatOut.format(dateEntry);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    private String numberFormat(String number) {
        Double numberDouble = Double.valueOf(number);
        NumberFormat formatNumber = NumberFormat.getNumberInstance(locale());
        number = formatNumber.format(numberDouble);
        return number;
    }

    private Locale locale() {
        return new Locale("pt", "BR");
    }
}
