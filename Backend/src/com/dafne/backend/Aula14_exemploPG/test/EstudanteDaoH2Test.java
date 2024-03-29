package com.dafne.backend.Aula14_exemploPG.test;

import com.dafne.backend.Aula14_exemploPG.dao.ConfiguracaoJDBC;
import com.dafne.backend.Aula14_exemploPG.dao.IDao;
import com.dafne.backend.Aula14_exemploPG.dao.impl.EstudanteDaoH2;
import com.dafne.backend.Aula14_exemploPG.model.Estudante;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
@RunWith(JUnit4.class)
public class EstudanteDaoH2Test {
    private  static IDao<Estudante> estudanteDao = new EstudanteDaoH2(new ConfiguracaoJDBC());

    @BeforeClass
    public static void carregarEstudantes() {
        estudanteDao.salvar(new Estudante("1", "EstudanteUm", "SobrenomeUm"));
        estudanteDao.salvar(new Estudante("2", "EstudanteDois", "SobrenomeDois"));
        estudanteDao.salvar(new Estudante("3", "EstudanteTrês", "SobrenomeTrês"));
        estudanteDao.salvar(new Estudante("4", "EstudanteQuatro", "SobrenomeQuatro"));
    }

    @Test
    public  void salvarEBuscarEstudantesTest() {
        estudanteDao.salvar(new Estudante("5", "Carlos", "Pereira"));
        Estudante estudante = estudanteDao.buscar("5");
        Assert.assertNotNull(estudante);
        Assert.assertEquals(estudante.getNome(), "Carlos");

    }

    @Test
    public  void buscarTodosOsEstudantesTest() {
        List<Estudante> estudantes = estudanteDao.buscarTodos();
        Assert.assertEquals(estudantes.size(), 4);
    }

    @Test
    public void eliminarEstudanteTest() {
        estudanteDao.eliminar("1");
        Assert.assertEquals(estudanteDao.buscar("1"),null);


    }


}
