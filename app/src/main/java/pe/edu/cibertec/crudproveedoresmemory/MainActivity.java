package pe.edu.cibertec.crudproveedoresmemory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AdaptadorProveedores adaptadorProveedores;
    private ArrayList<ProveedorEntity> proveedores;

    ListView listViewProveedores;
    Button buttonNuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewProveedores = (ListView) findViewById(R.id.listViewProveedores);
        buttonNuevo = (Button) findViewById(R.id.buttonNuevo);


        ProveedorEntity proveedor1 = new ProveedorEntity(1, "Cibertec Max", "Av. Zarumilla 100", "123456");
        ProveedorEntity proveedor2 = new ProveedorEntity(2, "Ripley Max", "Av. Zarumilla 100", "123456");
        ProveedorEntity proveedor3 = new ProveedorEntity(3, "Max Max", "Av. Zarumilla 100", "123456");
        ProveedorEntity proveedor4 = new ProveedorEntity(4, "Cibertec Max", "Av. Zarumilla 100", "123456");
        ProveedorEntity proveedor5 = new ProveedorEntity(5, "Ripley Max", "Av. Zarumilla 100", "123456");
        ProveedorEntity proveedor6 = new ProveedorEntity(6, "Max Max", "Av. Zarumilla 100", "123456");
        ProveedorEntity proveedor7 = new ProveedorEntity(7, "Cibertec Max", "Av. Zarumilla 100", "123456");
        ProveedorEntity proveedor8 = new ProveedorEntity(8, "Ripley Max", "Av. Zarumilla 100", "123456");
        ProveedorEntity proveedor9 = new ProveedorEntity(9, "Max Max", "Av. Zarumilla 100", "123456");
        ProveedorEntity proveedor10 = new ProveedorEntity(10, "Cibertec Max", "Av. Zarumilla 100", "123456");
        ProveedorEntity proveedor11 = new ProveedorEntity(11, "Ripley Max", "Av. Zarumilla 100", "123456");
        ProveedorEntity proveedor12 = new ProveedorEntity(12, "Max Max", "Av. Zarumilla 100", "123456");
        ProveedorEntity proveedor13 = new ProveedorEntity(13, "Ripley Max", "Av. Zarumilla 100", "123456");
        ProveedorEntity proveedor14 = new ProveedorEntity(14, "Max Max", "Av. Zarumilla 100", "123456");


        proveedores = new ArrayList<>();

        proveedores.add(proveedor1);
        proveedores.add(proveedor2);
        proveedores.add(proveedor3);
        proveedores.add(proveedor4);
        proveedores.add(proveedor5);
        proveedores.add(proveedor6);
        proveedores.add(proveedor7);
        proveedores.add(proveedor8);
        proveedores.add(proveedor9);
        proveedores.add(proveedor10);
        proveedores.add(proveedor11);
        proveedores.add(proveedor12);
        proveedores.add(proveedor13);
        proveedores.add(proveedor14);

        adaptadorProveedores = new AdaptadorProveedores(getBaseContext(), R.layout.item_proveedor, proveedores);

        listViewProveedores.setAdapter(adaptadorProveedores);

        listViewProveedores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "Item #" + position, Toast.LENGTH_LONG).show();
            }
        });

        buttonNuevo.setOnClickListener(myHandlerNuevo);

    }

    private View.OnClickListener myHandlerNuevo = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(), NuevoProveedor.class);
            startActivityForResult(intent, 1);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                String razonSocial = data.getStringExtra("razonSocial");
                String direccion = data.getStringExtra("direccion");
                String ruc = data.getStringExtra("ruc");
                String activoSunarp = data.getStringExtra("activoSunarp");
                String tipoEmpresa = data.getStringExtra("tipoEmpresa");

                ProveedorEntity proveedor = new ProveedorEntity(proveedores.size(), razonSocial, direccion, ruc);
                proveedores.add(proveedor);
                listViewProveedores.setAdapter(adaptadorProveedores);

            }

            if(resultCode == RESULT_CANCELED){
                Toast.makeText(getBaseContext(),"Ud. cancelo el registro", Toast.LENGTH_LONG).show();
            }
        }
    }
}


















