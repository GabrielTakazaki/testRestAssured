/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.testrest.testrestassured;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import io.restassured.http.ContentType;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import org.junit.Test;

/**
 *
 * @author Minoru
 */
public class Exercicio18Test {    
    @Test
    public void testLivroInfo() {
        when().
                get("http://localhost:3000/livros/{id}", 1234).
        then()
                .statusCode(200).
                body("titulo", is("Codigo da Vinci"));
    } 
    @Test
    public void testNovoLivro() {
        Map<String,String> livro = new HashMap<>();
        livro.put("titulo", "TOTS-Atividade18");
        livro.put("autor", "Andre Endo");
        livro.put("ano", "2018");
        livro.put("preco", "100000.00");
        
        given().
                contentType(ContentType.JSON).
                body(livro).
        when().
                post("http://localhost:3000/livros").
        then()
                .statusCode(200).
                body("codigo", is(not("")));
    }     
}
