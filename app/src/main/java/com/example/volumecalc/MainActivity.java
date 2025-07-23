package com.example.volumecalc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    GridView gridView;
    ArrayList<Shape> shapeArrayList;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        shapeArrayList = new ArrayList<>();

        Shape s1 = new Shape(R.drawable.sphere,"Sphere");
        Shape s2 = new Shape(R.drawable.cube,"Cube");
        Shape s3 = new Shape(R.drawable.prism,"Prism");
        Shape s4 = new Shape(R.drawable.cylinder,"Cylinder");

        shapeArrayList.add(s1);
        shapeArrayList.add(s2);
        shapeArrayList.add(s3);
        shapeArrayList.add(s4);


        adapter = new CustomAdapter(getApplicationContext(),shapeArrayList);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Shape clickedShape = shapeArrayList.get(i);
                String shapeName = clickedShape.getShapeName();

                Intent intent;
                switch (shapeName){
                    case "Sphere":
                        intent = new Intent(getApplicationContext(), Sphere.class);
                        break;

                    case "Cube":
                        intent = new Intent(getApplicationContext(), Cube.class);
                        break;

                    case "Prism":
                        intent = new Intent(getApplicationContext(), Prism.class);
                        break;


                    case "Cylinder":
                        intent = new Intent(getApplicationContext(), Cylinder.class);
                        break;
                        
                    default:
                        Toast.makeText(MainActivity.this, "Unknown shape", Toast.LENGTH_SHORT).show();
                        return;
                }
                startActivity(intent);
            }

        });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}