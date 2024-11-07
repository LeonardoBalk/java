
# Sistema de Gerenciamento da Entrada de Alunos e Professores no Restaurante Universitário (RU)
Esse programa em Java é um sistema para gerenciar o acesso ao RU que permite verificar se alunos e professores podem almoçar com base em créditos. A ideia é que se imagine que na hora que é escaneado o código de barras na entrada, aconteça o que foi implementado no código.

## Recapitulando conceitos de POO que irão ser usados
-   **Herança**: Herança é um princípio da programação orientada a objetos (POO) que ainda não tínhamos visto em aula, justamente por isso achei interessante usar de exemplo no código. Herança permite que uma classe herde propriedades e métodos de outra. A classe que herda é chamada de "subclasse", a que fornece é chamada de "superclasse". Esse conceito permite reusar o código e criar relações de hierarquia entre as classes.
    
-   **Encapsulamento**: Em POO, encapsulamento serve para ocultar os detalhes internos de uma classe e permite o acesso controlado aos dados por meio de métodos, como get e set por exemplo. Em sistemas grandes isso é importante para proteger dados.
-   **Classes e Objetos**: Conceitos fundamentais de POO. Uma classe define atributos e comportamentos. Um objeto é uma instância de uma classe, uma realização concreta e particular de uma classe.


## Classes e Código

### Classe `Pessoa`

A classe `Pessoa` é a [superclasse](https://www.inf.pucrs.br/flash/lapro2/lapro2_heranca.pdf) e possui os atributos gerais de pessoa no contexto da universidade: nome, se possui agendamento, quantos créditos tem e se possui BSE (Benefício Sócio Econômico).

```java
package org.example;

public class Pessoa {
    public String nome;
    public boolean temAgendamento;
    public boolean temBSE;
    public float creditos;

    public Pessoa(String nome, boolean temAgendamento, float creditos, boolean temBSE) {
        this.nome = nome;
        this.temAgendamento = temAgendamento;
        this.temBSE = temBSE;
        this.creditos = creditos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getTemAgendamento() {
        return temAgendamento;
    }

    public void setTemAgendamento(boolean temAgendamento) {
        this.temAgendamento = temAgendamento;
    }

    public boolean getTemBSE() {
        return temBSE;
    }

    public void setTemBSE(boolean temBSE) {
        this.temBSE = temBSE;
    }

    public float getCreditos() {
        return creditos;
    }

    public void setCreditos(float creditos) {
        this.creditos = creditos;
    }

    public void exibirInformacoesPessoa() {
        System.out.println("Nome: " + getNome());
        System.out.println("Tem Agendamento: " + getTemAgendamento());
        System.out.println("Créditos: " + getCreditos());
        System.out.println("Possui BSE: " + getTemBSE());
    }
}
```


