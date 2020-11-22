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

public class AddMotherboard extends AppCompatActivity {

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
    public static final String EXTRA_SIZE =
            "com.example.entityrelationtest.EXTRA_SIZE";
    public static final String EXTRA_SOCKET =
            "com.example.entityrelationtest.EXTRA_SOCKET";
    public static final String EXTRA_RAMSUP =
            "com.example.entityrelationtest.EXTRA_RAMSUP";
    public static final String EXTRA_PCIESUP =
            "com.example.entityrelationtest.EXTRA_PCIESUP";


    private EditText editName;
    private EditText editDescription;
    private EditText editManufacturer;
    private EditText editLink;
    private EditText editPrice;
    private EditText editProductType;
    private EditText editSize;
    private EditText editSocket;
    private EditText editRamSup;
    private EditText editPCIESup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_motherboard);
        editName = findViewById(R.id.edit_text_name);
        editDescription = findViewById(R.id.edit_text_description);
        editManufacturer = findViewById(R.id.edit_text_manufacturer);
        editLink = findViewById(R.id.edit_text_link);
        editPrice = findViewById(R.id.editTextPrice);
        editProductType = findViewById(R.id.edit_text_productType);
        editSize = findViewById(R.id.edit_text_size);
        editSocket = findViewById(R.id.edit_text_socket);
        editRamSup = findViewById(R.id.edit_text_ramSupport);
        editPCIESup = findViewById(R.id.edit_text_pcieSupport);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Motherboard");
    }

    private void saveMotherboard() {
        String name = editName.getText().toString();
        String description = editDescription.getText().toString();
        String manufacturer = editManufacturer.getText().toString();
        String link = editLink.getText().toString();
        Double price = Double.parseDouble(editPrice.getText().toString());
        String productType = editProductType.getText().toString();
        String size = editSize.getText().toString();
        String socket = editSocket.getText().toString();
        String ramSupp = editRamSup.getText().toString();
        String pcieSupp = editPCIESup.getText().toString();

        if (name.trim().isEmpty() || description.trim().isEmpty() || manufacturer.trim().isEmpty() || link.trim().isEmpty() || price == null || productType.trim().isEmpty() || size.trim().isEmpty()|| socket.trim().isEmpty()|| ramSupp.trim().isEmpty() || pcieSupp.trim().isEmpty()) {
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
        data.putExtra(EXTRA_SIZE, size);
        data.putExtra(EXTRA_SOCKET, socket);
        data.putExtra(EXTRA_RAMSUP, ramSupp);
        data.putExtra(EXTRA_PCIESUP, pcieSupp);
        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_motherboard_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_motherboard:
                saveMotherboard();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
