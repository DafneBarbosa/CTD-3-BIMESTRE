package com.dafne.backend.Aula14_exemploPG.service;

import com.dafne.backend.Aula14_exemploPG.dao.IDao;
import com.dafne.backend.Aula14_exemploPG.model.Estudante;

import java.util.List;

public class EstudanteService {

    private IDao<Estudante> estudanteDao;

    public EstudanteService() {

    }

    public EstudanteService(IDao<Estudante> estudanteDao) {
        this.estudanteDao = estudanteDao;
    }

    public void setEstudanteDao( IDao<Estudante> estudanteDao) {
        this.estudanteDao = estudanteDao;
    }

    public Estudante salvarEstudante(Estudante estudante){
        estudanteDao.salvar(estudante);
        return estudante;
    }
    public List<Estudante> buscarTodos(){
        return estudanteDao.buscarTodos();
    }

    public Estudante buscar(String id){
        return estudanteDao.buscar(id);
    }

}
