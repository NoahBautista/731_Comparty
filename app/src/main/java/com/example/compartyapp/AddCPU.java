package com.example.compartyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AddCPU extends AppCompatActivity {

    public static final String EXTRA_NAME =
            "com.example.entityrelationtest.EXTRA_NAME";
    public static final String EXTRA_DESCRIPTION =
            "com.example.entityrelationtest.EXTRA_DESCRIPTION";
    public static final String EXTRA_MANUFACTURER =
            "com.example.entityrelationtest.EXTRA_MANUFACTURER";
    public static final String EXTRA_LINK =
            "com.example.entityrelationtest.EXTRA_LINK";
    public static final String EXTRA_PRICE =
            "com.example.entityrelationtest.EXTRA_PRICE";
    public static final String EXTRA_TYPE =
            "com.example.entityrelationtest.EXTRA_TYPE";
    public static final String EXTRA_NUMBERCORES =
            "com.example.entityrelationtest.EXTRA_NUMBERCORES";
    public static final String EXTRA_NUMBERTHREADS =
            "com.example.entityrelationtest.EXTRA_NUMBERTHREADS";
    public static final String EXTRA_BASEC =
            "com.example.entityrelationtest.EXTRA_BASEC";
    public static final String EXTRA_BOOSTC =
            "com.example.entityrelationtest.EXTRA_BOOSTC";

    private EditText editName;
    private EditText editDescription;
    private EditText editManufacturer;
    private EditText editLink;
    private EditText editPrice;
    private EditText editProductType;
    private EditText editNumberOfCores;
    private EditText editNumberOfThreads;
    private EditText editBaseClock;
    private EditText editBoostClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_c_p_u);

        editName = findViewById(R.id.edit_text_name);
        editDescription = findViewById(R.id.edit_text_description);
        editManufacturer = findViewById(R.id.edit_text_manufacturer);
        editLink = findViewById(R.id.edit_text_link);
        editPrice = findViewById(R.id.editTextPrice);
        editProductType = findViewById(R.id.edit_text_productType);
        editNumberOfCores = findViewById(R.id.editNumberOfCores);
        editNumberOfThreads = findViewById(R.id.editNumberOfThreads);
        editBaseClock = findViewById(R.id.edit_text_baseClock);
        editBoostClock = findViewById(R.id.edit_text_boostClock);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add CPU");
    }

    private void saveCPU()
    {
        String name = editName.getText().toString();
        String description = editDescription.getText().toString();
        String manufacturer = editManufacturer.getText().toString();
        String link = editLink.getText().toString();
        Double price = Double.parseDouble(editPrice.getText().toString());
        String productType = editProductType.getText().toString();
        Integer numberOfCores = Integer.parseInt(editNumberOfCores.getText().toString());
        Integer numberOfThreads = Integer.parseInt(editNumberOfThreads.getText().toString());
        String baseClock = editBaseClock.getText().toString();
        String boostClock = editBoostClock.getText().toString();

        if(name.trim().isEmpty() || description.trim().isEmpty() || manufacturer.trim().isEmpty() || link.trim().isEmpty() || price == null || productType.trim().isEmpty() || numberOfCores == null || numberOfThreads == null || baseClock.trim().isEmpty() || boostClock.trim().isEmpty())
        {
            Toast.makeText(this, "Please insert data into all fields.", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_NAME, name);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_MANUFACTURER, manufacturer);
        data.putExtra(EXTRA_LINK, link);
        data.putExtra(EXTRA_PRICE, price);
        data.putExtra(EXTRA_TYPE, productType);
        data.putExtra(EXTRA_NUMBERCORES, numberOfCores);
        data.putExtra(EXTRA_NUMBERTHREADS, numberOfThreads);
        data.putExtra(EXTRA_BASEC, baseClock);
        data.putExtra(EXTRA_BOOSTC, boostClock);

        setResult(RESULT_OK,data);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_cpu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.save_cpu:
                saveCPU();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}