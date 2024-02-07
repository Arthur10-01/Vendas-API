package com.br.java.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.java.domain.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer > {

    @Query(value = " select u from usuaio u where u.nome like '%:nome%' ", nativeQuery = true)
    List<Usuario> encontrarPorNome( @Param("nome") String nome );
   
    @Query(value = "select u from Usuario u where u.email = :email and u.senha  = :senha ")
    List<Usuario> encontrarPorEmailESenha( @Param("email") String email,@Param("senha") String senha );

    @Query(" select u from Usuario u left join fetch u.pedidos where u.id = :id  ")
    Usuario findUsuarioFetchPedidos( @Param("id") Integer id );


}