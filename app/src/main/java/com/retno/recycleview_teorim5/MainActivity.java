package com.retno.recycleview_teorim5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements KontakAdapter.OnContactClickListener{

    public RecyclerView rv;
    public KontakAdapter contactAdapter;
    public RecyclerView.LayoutManager layoutManager;
    public List<Kontak> listContact = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rvContact);

        listContact.add(new Kontak("Iron Man",
                "081312700100",
                "https://cdn4.iconfinder.com/data/icons/famous-characters-add-on-vol-1-flat/48/Famous_Character_-_Add_On_1-14-512.png"));

        listContact.add(new Kontak("Bat Man",
                "089606941238",
                "https://cdn4.iconfinder.com/data/icons/famous-characters-add-on-vol-1-flat/48/Famous_Character_-_Add_On_1-22-512.png"));

        listContact.add(new Kontak("Groot",
                "08988798768",
                "https://cdn4.iconfinder.com/data/icons/famous-characters-add-on-vol-1-flat/48/Famous_Character_-_Add_On_1-21-512.png"));

        listContact.add(new Kontak("Sonic",
                "08766588798",
                "https://cdn4.iconfinder.com/data/icons/famous-characters-add-on-vol-1-flat/48/Famous_Character_-_Add_On_1-26-512.png"));
        listContact.add(new Kontak(
                "Suo Hayato",
                "085597224500",
                "https://static.animecorner.me/2023/10/1697631345-63317-768x432.png"));
        listContact.add(new Kontak(
                "Sakura Haruka",
                "085224678922",
                "https://m.media-amazon.com/images/I/61KhYY8oqAL._AC_UF894,1000_QL80_.jpg"));
        listContact.add(new Kontak(
                "Ren Kaji",
                "083822567890",
                "https://i.pinimg.com/736x/4c/ac/b0/4cacb015b52c79d5e8a866ffde884800.jpg"));



        contactAdapter = new KontakAdapter(listContact);
        contactAdapter.setListener(this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setAdapter(contactAdapter);
        rv.setLayoutManager(layoutManager);
    }
    @Override
    public void onClick(View view, int position) {
        Kontak kontak = listContact.get(position);
        Toast.makeText(this, kontak.getNama(), Toast.LENGTH_LONG)
                .show();

        // Mendapatkan nomor telepon dari kontak
        String nomorTelepon = kontak.getTelepon();

        // Membuat Intent untuk melakukan panggilan
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + nomorTelepon));

        // Memulai aktivitas Intent
        startActivity(intent);
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}