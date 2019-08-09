package br.com.dhnews.view.autenticacao;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import br.com.dhnews.R;
import br.com.dhnews.view.MainActivity;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsuarioFragment extends Fragment {
    CircleImageView circleImageViewUser;
    TextView nomeCompletoText;
    TextView  btnLogout;

    private FirebaseAuth mAuth;
    public UsuarioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mAuth = FirebaseAuth.getInstance();

        View view = inflater.inflate(R.layout.fragment_usuario, container, false);

        circleImageViewUser = view.findViewById(R.id.circleImageViewUser);
        nomeCompletoText = view.findViewById(R.id.nomeCompletoText);
        btnLogout = view.findViewById(R.id.btnDesconectarConta);

        FirebaseUser user = mAuth.getCurrentUser();

        if(user != null){
            nomeCompletoText.setText(user.getDisplayName());

        }

        btnLogout.setOnClickListener(v->{
            mAuth.signOut();
            ((MainActivity) getActivity()).replaceFragment(new LoginFragment());
        });
        return view;
    }



}