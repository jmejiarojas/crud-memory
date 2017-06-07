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

        proveedores = new ArrayList<>();

        proveedores.add(proveedor1);
        proveedores.add(proveedor2);
        proveedores.add(proveedor3);

        adaptadorProveedores = new AdaptadorProveedores(getBaseContext(), R.layout.activity_main, proveedores);

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


















