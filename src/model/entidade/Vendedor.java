package model.entidade;

import java.io.Serializable;
import java.util.Date;

public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private String email;
    private Date Aniversario;
    private Double SalarioBase;

    private Departamento departament;

    public Vendedor() {
    }

    public Vendedor(int id, String nome, String email, Date aniversario, Double salarioBase, Departamento departament) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        Aniversario = aniversario;
        SalarioBase = salarioBase;
        this.departament = departament;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAniversario() {
        return Aniversario;
    }

    public void setAniversario(Date aniversario) {
        Aniversario = aniversario;
    }

    public Double getSalarioBase() {
        return SalarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        SalarioBase = salarioBase;
    }

    public Departamento getDepartament() {
        return departament;
    }

    public void setDepartament(Departamento departament) {
        this.departament = departament;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vendedor vendedor = (Vendedor) o;

        return id == vendedor.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", Aniversario=" + Aniversario +
                ", SalarioBase=" + SalarioBase +
                ", departament=" + departament +
                '}';
    }
}
