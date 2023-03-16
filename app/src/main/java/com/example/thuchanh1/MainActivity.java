package com.example.thuchanh1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.thuchanh1.model.ObAdapter;
import com.example.thuchanh1.model.Object;
import com.example.thuchanh1.model.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements ObAdapter.ObItemListener {
    public Spinner spinner;
    private int[] imgs = {R.drawable.a, R.drawable.b};
    private RecyclerView recyclerView;
    private ObAdapter obAdapter;
    private EditText txtName, txtPrice, txtDes;
    private Button btnAdd, btnUpdate;
    private int positionCurrent;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        obAdapter = new ObAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(obAdapter);
        obAdapter.setClickListener(this);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object object = new Object();
                String i = spinner.getSelectedItem().toString();
                String name = txtName.getText().toString();
                String des = txtDes.getText().toString();
                String price = txtPrice.getText().toString();
                int img = R.drawable.a;
                double p = 0;
                try {
                    img = imgs[Integer.parseInt(i)];
                    p = Double.parseDouble(price);
                } catch (NumberFormatException e) {

                }
                object.setImg(img);
                object.setDes(des);
                object.setPrice(p);
                object.setName(name);
                obAdapter.add(object);
            }

        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object object = new Object();
                String i = spinner.getSelectedItem().toString();
                String name = txtName.getText().toString();
                String des = txtDes.getText().toString();
                String price = txtPrice.getText().toString();
                int img = R.drawable.a;
                double p = 0;
                try {
                    img = imgs[Integer.parseInt(i)];
                    p = Double.parseDouble(price);
                } catch (NumberFormatException e) {

                }
                object.setImg(img);
                object.setDes(des);
                object.setPrice(p);
                object.setName(name);
                obAdapter.Update(positionCurrent,object);
                btnAdd.setEnabled(true);
                btnUpdate.setEnabled(false);
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                List<Object> filterlist= new ArrayList<>();
                for (Object i:obAdapter.getBackUp()){
                    if (i.getName().toUpperCase().contains(s.toUpperCase())){
                        filterlist.add(i);

                    }
                    if (filterlist.isEmpty()){
                        Toast.makeText(MainActivity.this,"No data found",Toast.LENGTH_LONG).show();
                    }else {
                        obAdapter.filterList(filterlist);
                    }
                }
                return false;
            }
        });
    }


    private void initView() {
        spinner = findViewById(R.id.img);
        SpinnerAdapter adapter = new SpinnerAdapter(this);
        spinner.setAdapter(adapter);
        recyclerView = findViewById(R.id.recyclerview);
        txtName = findViewById(R.id.txtName);
        txtPrice = findViewById(R.id.txtPrice);
        txtDes = findViewById(R.id.txtDes);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnUpdate.setEnabled(false);
        searchView=findViewById(R.id.btnSearch);
    }

    @Override
    public void onItemClick(View view, int position) {
        btnAdd.setEnabled(false);
        btnUpdate.setEnabled(true);
        positionCurrent = position;
        Object object = obAdapter.getItem(position);
        int img = object.getImg();
        int p = 0;
        for (int i = 0; i < imgs.length; i++) {
            if (img == imgs[i]) {
                p = i;
                break;
            }
        }
        spinner.setSelection(p);
        txtName.setText(object.getName());
        txtDes.setText(object.getDes());
        txtPrice.setText(object.getPrice() + "");
    }
}