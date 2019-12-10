package com.ymt.mvpapp.view;

import com.ymt.mvpapp.entity.Categoria;

import java.util.List;

public interface CategoryView {

    void showProgress();

    void hideProgress();

    void pedirCategorias();

    void showCategorias(List<Categoria> list_categorias);


}
