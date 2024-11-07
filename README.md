



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




## Vamos para o código...

### Classe `Pessoa`

A classe `Pessoa` é a [superclasse](https://www.inf.pucrs.br/flash/lapro2/lapro2_heranca.pdf) e possui os atributos gerais de pessoa no contexto da universidade: nome, se possui agendamento, quantos créditos tem e se possui BSE (Benefício Sócio Econômico).

```java
package org.example;

public class Pessoa {
    public String nome;
    public boolean temAgendamento;
    public boolean temBSE;
    public float creditos;

	//construtor
    public Pessoa(String nome, boolean temAgendamento, float creditos, boolean temBSE) {
        this.nome = nome;
        this.temAgendamento = temAgendamento;
        this.temBSE = temBSE;
        this.creditos = creditos;
    }
    
	//getters e setters
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
    
	//método para exibir informações das pessoas
    public void exibirInformacoesPessoa() {
        System.out.println("Nome: " + getNome());
        System.out.println("Tem Agendamento: " + getTemAgendamento());
        System.out.println("Créditos: " + getCreditos());
        System.out.println("Possui BSE: " + getTemBSE());
    }
}
```

### Classe `Aluno`

A classe `Aluno` é uma subclasse da classe `Pessoa`. A classe `Aluno` adiciona os atributos matrícula e curso. Além disso, define os métodos que definem se o aluno pode ou não almoçar.

```java
package org.example;  
  
public class Aluno extends Pessoa {  
    private String matricula;  
    private String curso;  
  
  //construtor
    public Aluno(String nome, String matricula, String curso, boolean temAgendamento, float creditos, boolean temBSE) {  
        super(nome, temAgendamento, creditos, temBSE);  
        this.matricula = matricula;  
        this.curso = curso;  
    }  
  
	 //getters e setters
    public String getMatricula() {  
        return matricula;  
    }  
  
    public void setMatricula(String matricula) {  
        this.matricula = matricula;  
    }  
  
    public String getCurso() {  
        return curso;  
    }  
  
    public void setCurso(String curso) {  
        this.curso = curso;  
    }  
  
	//métodos que definem se o aluno pode almoçar  
    private boolean temCreditos (float credito){  
        if(credito >= 2.50){  
            return true;  
        }  
  
        return false;  
    }  
  
    public boolean podeAlmocar(float n){  
        if(temAgendamento && (temBSE || temCreditos(n))){  
            return true;  
        }  
        return false;  
    }  
  
    public void almocou(boolean podeAlmocar) {  
        if(podeAlmocar) {  
            if(!temBSE) {  
                creditos -= 2.5;  
            }  
            System.out.println("Almocou!");  
            this.temAgendamento = false;  
        }  
        else {  
            if(!temCreditos(creditos) && temAgendamento) {  
                System.out.println("Não foi possível almoçar, aluno (a) " + " não tem créditos.");  
            }  
            if(!temCreditos(creditos) && !temAgendamento) {  
                System.out.println("Não foi possível almoçar, aluno (a) " + " não tem agendamento e créditos.");  
            }  
            if(temCreditos(creditos) && !temAgendamento) {  
                System.out.println("Não foi possível almoçar, aluno (a) " + " não tem agendamento.");  
            }  
        }  
    }  
  
	  //exibe as informações do aluno
    public void exibirInformacoes() {  
        System.out.println("Curso: " + getCurso());  
        System.out.println("Matricula: " + getMatricula());  
        System.out.println("\n");  
    }  
}
```
package org.example;  
  
public class Professor extends Pessoa {  
    private String departamento;  
    private String siape;  
  
    public Professor(String nome, boolean temAgendamento, float creditos, boolean temBSE, String departamento, String siape) {  
        super(nome, temAgendamento, creditos, temBSE);  
        this.departamento = departamento;  
        this.siape = siape;  
        this.temBSE = false;  // Professor não tem BSE  
  }  
  
    private String getDepartamento() {  
        return departamento;  
    }  
  
    public void setDepartamento(String departamento) {  
        this.departamento = departamento;  
    }  
  
    public String getSiape() {  
        return siape;  
    }  
  
    public void setSiape(String siape) {  
        this.siape = siape;  
    }  
  
    private boolean temCreditos(float credito) {  
        if(credito >= 14) {  
            return true;  
        }  
        return false;  
    }  
  
    public boolean podeAlmocar(float n) {  
        if(temAgendamento && (temBSE || temCreditos(n))) {  
            return true;  
        }  
        return false;  
    }  
  
    public void almocou(boolean podeAlmocar) {  
        if(podeAlmocar) {  
            System.out.println("Almocou!");  
                creditos -= 14;  
            }  
         else {  
             if(!temCreditos(creditos) && temAgendamento) {  
                 System.out.println("Não foi possível almoçar, professor (a) " + " não tem créditos.");  
             }  
            if(!temCreditos(creditos) && !temAgendamento) {  
                System.out.println("Não foi possível almoçar, professor (a) " + " não tem agendamento e créditos.");  
            }  
            if(temCreditos(creditos) && !temAgendamento) {  
                System.out.println("Não foi possível almoçar, professor (a) " + " não tem agendamento.");  
            }  
        }  
    }  
  
    public void exibirInformacoes() {  
        System.out.println("Departamento: " + getDepartamento());  
        System.out.println("SIAPE: " + getSiape());  
        System.out.println("\n");  
    }  
### Classe `Professor`

A classe `Professor` também estende `Pessoa` e inclui os atributos departamento e número SIAPE (matrícula dos professores). As regras para almoçar são diferentes pois professor não possui BSE e o valor para almoçar é diferente (no código supus ser R$14,00).

```java
package org.example;  
  
public class Professor extends Pessoa {  
    private String departamento;  
    private String siape;  
    
  //construtor
    public Professor(String nome, boolean temAgendamento, float creditos, boolean temBSE, String departamento, String siape) {  
        super(nome, temAgendamento, creditos, temBSE);  
        this.departamento = departamento;  
        this.siape = siape;  
        this.temBSE = false;  // Professor não tem BSE  
  }  
  
	//getters e setters
    private String getDepartamento() {  
        return departamento;  
    }  
  
    public void setDepartamento(String departamento) {  
        this.departamento = departamento;  
    }  
  
    public String getSiape() {  
        return siape;  
    }  
  
    public void setSiape(String siape) {  
        this.siape = siape;  
    }  
  
	  //métodos para definir se o professor pode almoçar
    private boolean temCreditos(float credito) {  
        if(credito >= 14) {  
            return true;  
        }  
        return false;  
    }  
  
    public boolean podeAlmocar(float n) {  
        if(temAgendamento && (temBSE || temCreditos(n))) {  
            return true;  
        }  
        return false;  
    }  
  
    public void almocou(boolean podeAlmocar) {  
        if(podeAlmocar) {  
            System.out.println("Almocou!");  
                creditos -= 14;  
            }  
         else {  
             if(!temCreditos(creditos) && temAgendamento) {  
                 System.out.println("Não foi possível almoçar, professor (a) " + " não tem créditos.");  
             }  
            if(!temCreditos(creditos) && !temAgendamento) {  
                System.out.println("Não foi possível almoçar, professor (a) " + " não tem agendamento e créditos.");  
            }  
            if(temCreditos(creditos) && !temAgendamento) {  
                System.out.println("Não foi possível almoçar, professor (a) " + " não tem agendamento.");  
            }  
        }  
    }  
  
	 //exibe as informações do professor
    public void exibirInformacoes() {  
        System.out.println("Departamento: " + getDepartamento());  
        System.out.println("SIAPE: " + getSiape());  
        System.out.println("\n");  
    }  
}
```
### Classe `TestMain`

A classe `TestMain` é onde está a main, onde irá rodar tudo. A classe instância as classes alunos e professores, exibindo suas informações e verificando se podem almoçar.
### Exemplo de main e como se comporta:

```java
package org.example;

public class TestMain {
    public static void main(String[] args) {
        //cria instâncias de Aluno
        Aluno aluno1 = new Aluno("Neymar Jr", "1010101010", "Sistemas de Informação", true, 4.0f, false);
        Aluno aluno2 = new Aluno("Joao Silva", "2020202020", "Engenharia Civil", false, 3.5f, true);
        Aluno aluno3 = new Aluno("Gabriel Oliveira", "30303030", "Arquitetura e Urbanismo", true, 2.0f, true);

        //exibe as informações e verifica se o aluno pode almoçar (Aluno 1)
        System.out.println("Informações do Aluno (a) 1:");
        aluno1.exibirInformacoesPessoa(); // Exibe as informações básicas da pessoa
        aluno1.exibirInformacoes(); // Exibe informações específicas do aluno
        System.out.println("Aluno (a) " + aluno1.nome + " pode almoçar? " + aluno1.podeAlmocar(3.0f)); // Verifica se o aluno pode almoçar
        aluno1.almocou(aluno1.podeAlmocar(aluno1.creditos)); // Processa o almoço do aluno
        System.out.println("Créditos: R$" + aluno1.creditos); // Exibe os créditos restantes
        System.out.println("\n");

        //exibe as informações e verifica se o aluno pode almoçar (Aluno 2)
        System.out.println("Informações do Aluno (a) 2:");
        aluno2.exibirInformacoesPessoa();
        aluno2.exibirInformacoes();
        System.out.println("Aluno (a) " + aluno2.nome + " pode almoçar? " + aluno2.podeAlmocar(3.0f));
        aluno2.almocou(aluno2.podeAlmocar(aluno2.creditos));
        System.out.println("Créditos: R$" + aluno2.creditos);
        System.out.println("\n");

        //exibe as informações e verifica se o aluno pode almoçar (Aluno 3)
        System.out.println("Informações do Aluno (a) 3:");
        aluno3.exibirInformacoesPessoa();
        aluno3.exibirInformacoes();
        System.out.println("Aluno (a) " + aluno3.nome + " pode almoçar? " + aluno3.podeAlmocar(3.0f));
        aluno3.almocou(aluno3.podeAlmocar(aluno3.creditos));
        System.out.println("Créditos: R$" + aluno3.creditos);
        System.out.println("\n");

        //cria instâncias de Professor
        Professor professor1 = new Professor("Andrea Schwertner Charão", true, 6.0f, true, "Departamento de Linguagens e Sistemas de Computação", "2424252");
        Professor professor2 = new Professor("Gilnei Costa", false, 5.0f, false, "Departamento de Matemática", "3187543");
        Professor professor3 = new Professor("Luciana Almeida", true, 50.0f, true, "Departamento de Engenharia Elétrica", "8425639");

        //exibe as informações e verifica se o professor pode almoçar (Professor 1)
        System.out.println("Informações do Professor (a) 1:");
        professor1.exibirInformacoesPessoa(); // Exibe as informações básicas do professor
        professor1.exibirInformacoes(); // Exibe informações específicas do professor
        System.out.println("Professor (a) " + professor1.nome + " pode almoçar? " + professor1.podeAlmocar(professor1.creditos)); // Verifica se o professor pode almoçar
        professor1.almocou(professor1.podeAlmocar(professor1.creditos)); // Processa o almoço do professor
        System.out.println("Créditos: R$" + professor1.creditos); // Exibe os créditos restantes
        System.out.println("\n");

        //exibe as informações e verifica se o professor pode almoçar (Professor 2)
        System.out.println("Informações do Professor (a) 2:");
        professor2.exibirInformacoesPessoa();
        professor2.exibirInformacoes();
        System.out.println("Professor (a) " + professor2.nome + " pode almoçar? " + professor2.podeAlmocar(professor2.creditos));
        professor2.almocou(professor2.podeAlmocar(professor2.creditos));
        System.out.println("Créditos: R$" + professor2.creditos);
        System.out.println("\n");

        //exibe as informações e verifica se o professor pode almoçar (Professor 3)
        System.out.println("Informações do Professor (a) 3:");
        professor3.exibirInformacoesPessoa();
        professor3.exibirInformacoes();
        System.out.println("Professor (a) " + professor3.nome + " pode almoçar? " + professor3.podeAlmocar(professor3.creditos));
        professor3.almocou(professor3.podeAlmocar(professor3.creditos));
        System.out.println("Créditos: R$" + professor3.creditos);
        System.out.println("\n");
    }
}
```
### Rodando...
![java-main-–-TestMain java-2024-11-06-22-37-03](https://github.com/user-attachments/assets/b12a64ad-481a-499e-9a03-109df9fd481f)


