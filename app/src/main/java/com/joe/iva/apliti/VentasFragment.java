package com.joe.iva.apliti;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class VentasFragment extends Fragment implements View.OnClickListener {
    Button btnAdmin;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myFragmentView = inflater.inflate(R.layout.fragment_ventas, container, false);

        btnAdmin= (Button)myFragmentView.findViewById(R.id.btnadmin);
        btnAdmin.setOnClickListener(this);

        return myFragmentView;
    }

    @Override
    public void onClick(View v) {
        Intent opePro = new Intent(getActivity(),OpePro.class);
startActivity(opePro);
    }
}
