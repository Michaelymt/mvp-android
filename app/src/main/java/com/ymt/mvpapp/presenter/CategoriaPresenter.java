package com.ymt.mvpapp.presenter;

import com.ymt.mvpapp.entity.Categoria;

import java.util.List;

public interface CategoriaPresenter {

    void pedirCategorias();

    void recibirLista(List<Categoria> list_categoria);
}
