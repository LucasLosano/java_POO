package com.company;

import one.digitalinnovation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Curso cursoJava = new Curso();
        cursoJava.setTitulo("Java Básico");
        cursoJava.setDescricao("Aprenda conceitos...");
        cursoJava.setCargaHoraria(8);

        Curso cursoJavaAvancado = new Curso();
        cursoJavaAvancado.setTitulo("Java Avançado");
        cursoJavaAvancado.setDescricao("Aprenda conceitos...");
        cursoJavaAvancado.setCargaHoraria(8);

        Curso cursoNET = new Curso();
        cursoNET.setTitulo(".NET básico");
        cursoNET.setDescricao("Aprenda conceitos...");
        cursoNET.setCargaHoraria(8);



        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Aprendendo Orientação a Objetos com Java");
        mentoria.setDescricao("Imersão sobre os pilares de Orientação a Objetos");
        mentoria.setData(LocalDateTime.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("GFT START #2 Java");
        bootcamp.setInicio(LocalDate.now());
        bootcamp.setFim(bootcamp.getInicio().plusDays(45));
        List<ConteudoEducacional> conteudoEducacionals = Arrays.asList(cursoJava,cursoNET,cursoJavaAvancado);
        bootcamp.setConteudos(conteudoEducacionals);

        Dev lucas = new Dev();
        lucas.setNome("Lucas Losano");

        Dev losano = new Dev();
        losano.setNome("Lucas Losano");

        lucas.inscrever(cursoJava);
        lucas.inscrever(bootcamp);

        losano.inscrever(bootcamp);

        lucas.progredir();
        losano.progredir();
        lucas.progredir();

        System.out.println(lucas.calcularTotalXP());
        var Ranking = bootcamp.getDevs()
                .stream()
                .sorted((dev1,dev2) -> Double.compare(dev2.calcularTotalXP(), dev1.calcularTotalXP()))
                .collect(Collectors.toList());

        System.out.println(Ranking.stream().findFirst().get().getNome());
    }
}
