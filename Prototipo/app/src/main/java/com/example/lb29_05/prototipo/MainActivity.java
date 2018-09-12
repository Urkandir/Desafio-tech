package com.example.lb29_05.prototipo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    final ImageDbHelper ImageDbHelper = new ImageDbHelper(this);
    ImageView iv1;
    Button bt1;
    Switch sw1;
    TextView tv1;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    String codigo;
    int duracao = Toast.LENGTH_LONG;
    List<Imagem> imagens = new ArrayList<Imagem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Atribuindo o ID do imageView da tela principal (content_main)
        iv1 = (ImageView)findViewById(R.id.imageView1);

        //Atribuindo o ID do button da tela principal (content_main)
        bt1 = (Button)findViewById(R.id.button1);

        //Atribuindo o ID do switch da tela principal (content_main)
        sw1 = (Switch)findViewById(R.id.switch1);

        tv1 = (TextView)findViewById(R.id.textView1);

        //Quando o botão for apertado ele abrirá a galeria chamando a função "openGallery()" e também irá tornar o switch1 visível após escolher a imagem
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
                sw1.setVisibility(View.VISIBLE);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //Função para abrir a galeria
    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    //Função para pedir o código da foto e retornar o resultado com os dados pedidos
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult (requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            iv1.setImageURI(imageUri);

            codigo = imageUri.toString(); //Este código pega o que será usado como "ID da imagem"
            Imagem img = new Imagem(); //Instância um objeto da classe imagem
            img.setId_imagem(codigo); //Define o ID_imagem deste objeto como o código que foi pego
            Rotulo r = new Rotulo(); //Instancia um novo rótulo
            r.setNome_rotulo(sw1.getText().toString()); // Define o nome do rótulo como o nome que está no Switch, ou seja, o Switch é a pergunta, esta pergunta é o nome dado ao rótulo(Ou poderiamos chamar o rótulo de pergunta em outra palavras)

            r.setAplicavel(sw1.isChecked()); // Adiciona a boolean se o rótulo é aplicável ou não

            img.rotulos.add(r); //Poderia ser usado para interagir com os rótulos da imagem também, porém é apenas a ideia - EDIT: Adiciona o rótulo criado na ArrayList da classe Imagem

            imagens.add(img);

            String teste = sw1.getText().toString();

            tv1.setText(codigo);

            Toast toast = Toast.makeText(getApplicationContext(), teste, duracao);
            toast.show();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
