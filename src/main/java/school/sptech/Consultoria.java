package school.sptech;

import java.util.ArrayList;
import java.util.List;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria() {
        this.desenvolvedores = new ArrayList<>();
    }

    public void contratar(Desenvolvedor desenvolvedor){
        if(desenvolvedores.size() < vagas){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if(desenvolvedor.isFullstack()){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios(){
        Double soma = 0.0;
        for(Desenvolvedor d : desenvolvedores){
            soma += d.calcularSalario();
        }
        return soma;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer somaD = 0;
        for(Desenvolvedor d : desenvolvedores){
            if(d instanceof DesenvolvedorMobile){
                somaD += 1;
            }
        }
        return somaD;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> desenvolvedoresEncontrados = new ArrayList<>();
        for(Desenvolvedor d : desenvolvedores){
            if(d.calcularSalario() >= salario){
                desenvolvedoresEncontrados.add(d);
            }
        }

        return desenvolvedoresEncontrados;
    }

    public Desenvolvedor buscarMenorSalario(){
        if(desenvolvedores.isEmpty()){
            return null;
        }

        Desenvolvedor menorSalario = desenvolvedores.get(0);
        for(Desenvolvedor d : desenvolvedores){
            if(d.calcularSalario() < menorSalario.calcularSalario()){
                menorSalario = d;
            }
        }
        return menorSalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> desenvolvedoresEncontrados = new ArrayList<>();
        for(Desenvolvedor d : desenvolvedores){
            if(d instanceof DesenvolvedorMobile){
                if(((DesenvolvedorMobile) d).getPlataforma() == tecnologia ||
                        ((DesenvolvedorMobile) d).getLinguagem() == tecnologia){
                    desenvolvedoresEncontrados.add(d);
                }
            }
            if(d instanceof DesenvolvedorWeb){
                if(((DesenvolvedorWeb) d).getBackend() == tecnologia ||
                        ((DesenvolvedorWeb) d).getFrontend() == tecnologia ||
                        ((DesenvolvedorWeb) d).getSgbd() == tecnologia){
                    desenvolvedoresEncontrados.add(d);
                }
            }
        }
        return desenvolvedoresEncontrados;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
       List<Desenvolvedor> desenvolvedoresEncontrados = buscarPorTecnologia(tecnologia);
       Double soma = 0.0;

       for(Desenvolvedor d : desenvolvedoresEncontrados){
           soma += d.calcularSalario();
       }
       return soma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }
}
