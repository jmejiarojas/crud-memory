package pe.edu.cibertec.crudproveedoresmemory;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class NuevoProveedor extends AppCompatActivity {

    EditText editTextRazonSocial;
    EditText editTextDireccion;
    EditText editTextRuc;
    Spinner spinnerTipoEmpresa;
    Button buttonGrabar;
    CheckBox checkActivoSunat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_proveedor);

        editTextRazonSocial = (EditText) findViewById(R.id.editTextRazonSocial);
        editTextDireccion = (EditText) findViewById(R.id.editTextDireccionNuevo);
        editTextRuc = (EditText) findViewById(R.id.editTextRuc);
        spinnerTipoEmpresa = (Spinner) findViewById(R.id.spinnerTipoEmpresa);
        buttonGrabar = (Button) findViewById(R.id.buttonAgregar);
        checkActivoSunat = (CheckBox) findViewById(R.id.checkActivo);

        cargarEmpresas();

        View.OnClickListener myHandlerGrabar = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("razonSocial", editTextRazonSocial.getText().toString());
                returnIntent.putExtra("direccion", editTextDireccion.getText().toString());
                returnIntent.putExtra("ruc", editTextRuc.getText().toString());
                returnIntent.putExtra("activoSunarp", checkActivoSunat.isChecked());
                returnIntent.putExtra("tipoEmpresa", spinnerTipoEmpresa.getSelectedItem().toString());

                setResult(RESULT_OK, returnIntent);
                finish();
            }
        };

        buttonGrabar.setOnClickListener(myHandlerGrabar);

    }


    private void cargarEmpresas() {
        List<String> empresas = new ArrayList<>();
        empresas.add("Pyme");
        empresas.add("Micro");
        empresas.add("Pequena");
        empresas.add("Mediana");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, empresas);
        spinnerTipoEmpresa.setAdapter(adapter);
    }

}
