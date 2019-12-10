package com.ymt.mvpapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.ymt.mvpapp.R;
import com.ymt.mvpapp.adapter.CategoriaAdapter;
import com.ymt.mvpapp.entity.Categoria;
import com.ymt.mvpapp.presenter.CategoriaPresenter;
import com.ymt.mvpapp.presenter.CategoriaPresenterImpl;
import com.ymt.mvpapp.rest.HelperWs;
import com.ymt.mvpapp.rest.MethodWs;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements CategoryView {

    @BindView(R.id.recycler_categoria)
    RecyclerView recycler_categoria;

    CategoriaPresenter categoriaPresenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
        pedirCategorias();
        // callApi();
    }

    private void init() {
        categoriaPresenter = new CategoriaPresenterImpl(this);
    }

    private void callApi() {

    }

    private void configurarAdaptador(List<Categoria> lis_result) {
        recycler_categoria.setAdapter(new CategoriaAdapter(this, lis_result));
        recycler_categoria.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void pedirCategorias() {
        // api ya noooo
        categoriaPresenter.pedirCategorias();
    }

    @Override
    public void showCategorias(List<Categoria> list_categorias) {
        configurarAdaptador(list_categorias);
    }
}
