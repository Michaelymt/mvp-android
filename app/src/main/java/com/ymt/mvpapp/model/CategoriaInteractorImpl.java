package com.ymt.mvpapp.model;

import android.util.Log;

import com.ymt.mvpapp.entity.Categoria;
import com.ymt.mvpapp.presenter.CategoriaPresenter;
import com.ymt.mvpapp.rest.HelperWs;
import com.ymt.mvpapp.rest.MethodWs;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriaInteractorImpl implements CategoriaInteractor {

    CategoriaPresenter categoriaPresenter;


    public CategoriaInteractorImpl(CategoriaPresenter categoriaPresenter) {
        this.categoriaPresenter = categoriaPresenter;
    }

    @Override
    public void callApi() {

        // Retrofit
        MethodWs methodWs = HelperWs.getConfiguration().create(MethodWs.class);
        Call<List<Categoria>> response = methodWs.listarTodasLasCategorias();
        response.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                if (response.isSuccessful()) {
                    List<Categoria> lis_result = response.body();
                    // configurarAdaptador(lis_result);
                    categoriaPresenter.recibirLista(lis_result);
                } else {
                    Log.e("michcode", "Hubo un problema: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {
                Log.e("michcode", t.getMessage());
            }
        });
    }
}
