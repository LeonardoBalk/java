


# Sistema de Gerenciamento da Entrada de Alunos e Professores no Restaurante Universitário (RU)
Esse programa em Java é um sistema para gerenciar o acesso ao RU que permite verificar se alunos e professores podem almoçar com base em créditos. A ideia é que se imagine que na hora que é escaneado o código de barras na entrada, aconteça o que foi implementado no código.

## Recapitulando conceitos de POO que irão ser usados
-   **Herança**: Herança é um princípio da programação orientada a objetos (POO) que ainda não tínhamos visto em aula, justamente por isso achei interessante usar de exemplo no código. Herança permite que uma classe herde propriedades e métodos de outra. A classe que herda é chamada de "subclasse", a que fornece é chamada de "superclasse". Esse conceito permite reusar o código e criar relações de hierarquia entre as classes.
    
-   **Encapsulamento**: Em POO, encapsulamento serve para ocultar os detalhes internos de uma classe e permite o acesso controlado aos dados por meio de métodos, como get e set por exemplo. Em sistemas grandes isso é importante para proteger dados.
-   **Classes e Objetos**: Conceitos fundamentais de POO. Uma classe define atributos e comportamentos. Um objeto é uma instância de uma classe, uma realização concreta e particular de uma classe.


## Recomendação
Primeiramente, instalar o Java: 
https://www.treinaweb.com.br/blog/como-instalar-o-java-e-nosso-primeiro-exemplo

Depois, baixar e instalar o **IntelliJ IDEA Ultimate**. Provavelmente a IDE mais usada para Java, simples, fácil de usar e muito útil. O que pode ser desvantagem  no início, mas vai acabar sendo muito bom depois, é que a IDE automatiza muito, muitas vezes basta pressionar a tecla **Tab** para completar o código. No início, pode ser ruim se acostumar com esse ambiente "automático", pois, caso seja necessário programar em outro ambiente ou até mesmo no papel, pode ser complicado se adaptar.

### Baixar o IntelliJ IDEA Ultimate

- Primeiro, é necessário acessar https://www.jetbrains.com/shop/eform/students e criar uma conta vinculada com o e-mail acadêmico ou vincular com uma conta estudante do GitHub.
- Depois disso, basta baixar a IDE em https://www.jetbrains.com/idea/download/?section=windows e realizar a instalação.
- Após instalar, crie um projeto e no canto superior selecione a opção **Help** e depois a opção **Register...**.

![{39E983B3-EB63-4ABB-A489-EBC537D885C1}](https://github.com/user-attachments/assets/423374a0-4c58-48d0-b40d-e3aab89630f6)

Abrirá uma tela, selecione o botão para fazer login na sua conta JetBrains. Vai ser redirecionado para a tela de login no navegador, após isso o **IntelliJ IDEA Ultimate** está pronto para ser usado.

![Captura de tela 2024-11-06 224745](https://github.com/user-attachments/assets/b7522659-e064-47b7-8ab7-1f533061047b)

Para criar o projeto basta ir em **File**,  selecionar **New** e depois **Project...**.  Diferença entre as builds: 
-   **Build no IntelliJ**: Compila o código diretamente na IDE, sem necessidade de ferramentas externas. Simples e rápida.
-   **Maven**: Gerencia dependências e build usando um arquivo XML, com convenções e menos flexibilidade. Mais usado em projetos tradicionais.
-   **Gradle**: Mais flexível e rápido, usa Groovy ou Kotlin para configuração, ideal para projetos modernos e builds incrementais.

![{C4058A69-7D82-469F-AAB9-326EF3A1B642}](https://github.com/user-attachments/assets/08e44e69-c6bf-4fa5-b097-817e114af47c)

Tenho o costume de usar Maven, com isso o projeto fica assim:
![image](https://github.com/user-attachments/assets/076a65cb-7c34-44a9-af9b-52ca9f9d79d8)




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


