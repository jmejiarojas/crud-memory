package pe.edu.cibertec.crudproveedoresmemory;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mejia on 07/06/2017.
 */

public class AdaptadorProveedores extends ArrayAdapter<ProveedorEntity> {

    private ArrayList<ProveedorEntity> proveedores;

    public AdaptadorProveedores(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<ProveedorEntity> objects) {
        super(context, resource, objects);
        proveedores= (ArrayList<ProveedorEntity>) objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View viewItem = convertView;

        if(viewItem == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            viewItem = inflater.inflate(R.layout.item_proveedor,null);
        }

        ProveedorEntity proveedor = proveedores.get(position);

        if(proveedor != null){
            //Vamos a cargar el viewItem con los controles
            TextView editTextRasonSocial = (TextView) viewItem.findViewById(R.id.TVITEM_RazonSocialProveedor);
            TextView editTextRuc = (TextView) viewItem.findViewById(R.id.TVITEM_RucProveedor);
            TextView editTextDireccion = (TextView) viewItem.findViewById(R.id.TVITEM_Direccion);
            editTextRasonSocial.setText(proveedor.getRazonSocial());
            editTextRuc.setText(proveedor.getRuc());
            editTextDireccion.setText(proveedor.getDireccion());
        }

        return viewItem;
    }
}
