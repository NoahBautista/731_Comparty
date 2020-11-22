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

public class AddGPU extends AppCompatActivity {

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
    public static final String EXTRA_VRAM =
            "com.example.entityrelationtest.EXTRA_VRAM";
    public static final String EXTRA_BASEC =
            "com.example.entityrelationtest.EXTRA_BASEC";
    public static final String EXTRA_BOOSTC =
            "com.example.entityrelationtest.EXTRA_BOOSTC";
    public static final String EXTRA_PCIE =
            "com.example.entityrelationtest.EXTRA_PCIE";


    private EditText editName;
    private EditText editDescription;
    private EditText editManufacturer;
    private EditText editLink;
    private EditText editPrice;
    private EditText editProductType;
    private EditText editCores;
    private EditText editVRAM;
    private EditText editgpuBaseClock;
    private EditText editgpuBoostClock;
    private EditText editPCIEVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_g_p_u);

        editName = findViewById(R.id.edit_text_name);
        editDescription = findViewById(R.id.edit_text_description);
        editManufacturer = findViewById(R.id.edit_text_manufacturer);
        editLink = findViewById(R.id.edit_text_link);
        editPrice = findViewById(R.id.editTextPrice);
        editProductType = findViewById(R.id.edit_text_productType);
        editCores = findViewById(R.id.editCores);
        editVRAM = findViewById(R.id.editVRAM);
        editgpuBaseClock = findViewById(R.id.edit_text_gpubaseClock);
        editgpuBoostClock = findViewById(R.id.edit_text_gpuboostClock);
        editPCIEVersion = findViewById(R.id.edit_text_pcieVersion);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add GPU");
    }

    private void saveGPU()
    {
        String name = editName.getText().toString();
        String description = editDescription.getText().toString();
        String manufacturer = editManufacturer.getText().toString();
        String link = editLink.getText().toString();
        Double price = Double.parseDouble(editPrice.getText().toString());
        String productType = editProductType.getText().toString();
        Integer cores = Integer.parseInt(editCores.getText().toString());
        Integer vram = Integer.parseInt(editVRAM.getText().toString());
        String gpuBaseClock = editgpuBaseClock.getText().toString();
        String gpuBoostClock = editgpuBoostClock.getText().toString();
        String pcieVersion = editPCIEVersion.getText().toString();

        if(name.trim().isEmpty() || description.trim().isEmpty() || manufacturer.trim().isEmpty() || link.trim().isEmpty() || price == null || productType.trim().isEmpty() || cores == null || vram == null || gpuBaseClock.trim().isEmpty() || gpuBoostClock.trim().isEmpty() || pcieVersion.trim().isEmpty())
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
        data.putExtra(EXTRA_NUMBERCORES, cores);
        data.putExtra(EXTRA_VRAM, vram);
        data.putExtra(EXTRA_BASEC, gpuBaseClock);
        data.putExtra(EXTRA_BOOSTC, gpuBoostClock);
        data.putExtra(EXTRA_PCIE,pcieVersion);

        setResult(RESULT_OK,data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_gpu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.save_gpu:
                saveGPU();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}


