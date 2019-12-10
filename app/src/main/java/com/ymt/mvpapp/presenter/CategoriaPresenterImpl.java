package com.ymt.mvpapp.presenter;

import com.ymt.mvpapp.entity.Categoria;
import com.ymt.mvpapp.model.CategoriaInteractor;
import com.ymt.mvpapp.model.CategoriaInteractorImpl;
import com.ymt.mvpapp.view.CategoryView;

import java.util.List;

public class CategoriaPresenterImpl implements CategoriaPresenter {

    CategoryView categoryView;
    CategoriaInteractor categoriaInteractor;

    public CategoriaPresenterImpl(CategoryView categoryView) {

        this.categoryView = categoryView;
        categoriaInteractor = new CategoriaInteractorImpl(this);
    }

    @Override
    public void pedirCategorias() {
        categoriaInteractor.callApi();
    }

    @Override
    public void recibirLista(List<Categoria> list_categoria) {
        categoryView.showCategorias(list_categoria);
    }
}
